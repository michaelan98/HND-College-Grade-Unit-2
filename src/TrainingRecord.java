import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainingRecord {

	private JFrame frame;
	private JTable TrainingRecordTable;
	
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> TrainingRecordCollection = simplyRugby.getCollection("TrainingRecord");
	private JScrollPane scrollPane;
	private JButton btnNew;

	/**
	 * Launch the application.
	 */
	public static void TrainingRecordMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingRecord window = new TrainingRecord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrainingRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 996, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//This button will take the user back to the menu
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.MainMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnMenu.setBounds(424, 476, 97, 25);
		frame.getContentPane().add(btnMenu);
		frame.setTitle("Training Record table"); 
	       
      //headings for the table
        String[] headings = new String[]{"Coach", "Date", "Location", "Time", "Skills", "Players", "Accident/Injuries"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);

		//Find the collection from the database
        FindIterable<Document> TrainingRecord = TrainingRecordCollection.find();
       //Loop through the database and get the details
        for(Document TR : TrainingRecord) {
        	String Coach = TR.getString("Coach");
        	String Date = TR.getString("Date");
        	String Location = TR.getString("Location");
        	String Time = TR.getString("Time");
        	String Skills = TR.getString("Skills");
        	String Players = TR.getString("Players");
        	String Injuries = TR.getString("Injuries");
        	//Adds a row when details found
            model.addRow(new Object[] {Coach, Date, Location, Time , Skills, Players, Injuries});
        }
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 980, 340);
		frame.getContentPane().add(scrollPane);
		TrainingRecordTable = new JTable(model);
		scrollPane.setViewportView(TrainingRecordTable);
		TrainingRecordTable.setCellSelectionEnabled(true);
		TrainingRecordTable.setColumnSelectionAllowed(true);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTrainingRecord.NewTrainingRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNew.setBounds(531, 476, 97, 25);
		frame.getContentPane().add(btnNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Deleting the documents 
			      ListSelectionModel cellSelectionModel = TrainingRecordTable.getSelectionModel();
			      cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			      cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			        public void valueChanged(ListSelectionEvent e) {
			          String selectedData = null;

			          int[] selectedRow = TrainingRecordTable.getSelectedRows();
			          int[] selectedColumns = TrainingRecordTable.getSelectedColumns();

			          for (int i = 0; i < selectedRow.length; i++) {
			            for (int j = 0; j < selectedColumns.length; j++) {
			              selectedData = (String) TrainingRecordTable.getValueAt(selectedRow[i], selectedColumns[j]);
			            }
			          }
			          //Select data and delete
			          System.out.println("Selected: " + selectedData);
			          TrainingRecordCollection.deleteOne(Filters.eq("Coach", selectedData)); 
				      System.out.println("A training record have been successfully deleted.");
			        }

			      }); 
			}
		});
		btnDelete.setBounds(325, 477, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}