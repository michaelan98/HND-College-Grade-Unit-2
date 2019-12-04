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

public class GameRecord {

	private JFrame frame;
	private JTable GameRecordTable;
	private JScrollPane scrollPane;
	private JButton btnNew;
	
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> GameRecordCollection = simplyRugby.getCollection("GameRecord");

	/**
	 * Launch the application.
	 */
	public static void GameRecordMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameRecord window = new GameRecord();
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
	public GameRecord() {
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
		btnMenu.setBounds(426, 476, 97, 25);
		frame.getContentPane().add(btnMenu);
		frame.setTitle("Game Record table"); 
	       
      //headings for the table
        String[] headings = new String[]{"Opposition", "Date", "Location", "Time", "Result", "Score"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);

		//Find the collection from the database
        FindIterable<Document> GameRecord = GameRecordCollection.find();
       //Loop through the database and get the details
        for(Document GR : GameRecord) {
        	String Opposition_name = GR.getString("Opposition_name");
        	String DateofMatch = GR.getString("DateofMatch");
        	String Location = GR.getString("Location");
        	String Time = GR.getString("Time");
        	String Result = GR.getString("Result");
        	String Score = GR.getString("Score");
        	//Adds a row when details found
            model.addRow(new Object[] {Opposition_name,DateofMatch, Location, Time ,Result, Score});
        }
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 978, 340);
		frame.getContentPane().add(scrollPane);
		GameRecordTable = new JTable(model);
		scrollPane.setViewportView(GameRecordTable);
		GameRecordTable.setCellSelectionEnabled(true);
		GameRecordTable.setColumnSelectionAllowed(true);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGameRecord.NewGameRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNew.setBounds(533, 476, 97, 25);
		frame.getContentPane().add(btnNew);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Deleting the documents 
			      ListSelectionModel cellSelectionModel = GameRecordTable.getSelectionModel();
			      cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			      cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			        public void valueChanged(ListSelectionEvent e) {
			          String selectedData = null;

			          int[] selectedRow = GameRecordTable.getSelectedRows();
			          int[] selectedColumns = GameRecordTable.getSelectedColumns();

			          for (int i = 0; i < selectedRow.length; i++) {
			            for (int j = 0; j < selectedColumns.length; j++) {
			              selectedData = (String) GameRecordTable.getValueAt(selectedRow[i], selectedColumns[j]);
			            }
			          }
			          //Select data and delete
			          System.out.println("Selected: " + selectedData);
			          GameRecordCollection.deleteOne(Filters.eq("Opposition_name", selectedData)); 
				      System.out.println("A game record have been successfully deleted.");
			        }

			      }); 
			}
		});
		btnDelete.setBounds(327, 477, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}