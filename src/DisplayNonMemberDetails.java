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

public class DisplayNonMemberDetails {

	private JFrame frame;
	private JTable NonMemberTable;
	
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> NonMemberCollection = simplyRugby.getCollection("Non_Member");
	private JScrollPane scrollPane;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void DisplayNonMemberMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayNonMemberDetails window = new DisplayNonMemberDetails();
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
	public DisplayNonMemberDetails() {
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
		btnMenu.setBounds(421, 563, 97, 25);
		frame.getContentPane().add(btnMenu);
		frame.setTitle("Non-Member table"); 
	       
      //headings for the table
        String[] headings = new String[]{"SRUNumber", "Name", "DoB", "Email", "Address", "Postcode", "Tel", "Mobile"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);

		//Find the collection from the database
        FindIterable<Document> non_member = NonMemberCollection.find();
       //Loop through the database and get the details
        for(Document nm : non_member) {
        	String SRUNumber = nm.getString("SRUNumber");
        	String Name = nm.getString("Name");
        	String DOB = nm.getString("DoB");
        	String Email = nm.getString("Email");
        	String Address = nm.getString("Address");
        	String Postcode = nm.getString("Postcode");
        	String Tel = nm.getString("Tel");
        	String Mobile = nm.getString("Mobile");
        	//Adds a row when details found
            model.addRow(new Object[] {SRUNumber,Name, DOB, Email ,Address, Postcode,Tel,Mobile});
        }
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 978, 340);
		frame.getContentPane().add(scrollPane);
		NonMemberTable = new JTable(model);
		scrollPane.setViewportView(NonMemberTable);
		NonMemberTable.setCellSelectionEnabled(true);
		NonMemberTable.setColumnSelectionAllowed(true);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Deleting the documents 
			      ListSelectionModel cellSelectionModel = NonMemberTable.getSelectionModel();
			      cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			      cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
				        public void valueChanged(ListSelectionEvent e) {
				          String selectedData = null;

				          int[] selectedRow = NonMemberTable.getSelectedRows();
				          int[] selectedColumns = NonMemberTable.getSelectedColumns();

				          for (int i = 0; i < selectedRow.length; i++) {
				            for (int j = 0; j < selectedColumns.length; j++) {
				              selectedData = (String) NonMemberTable.getValueAt(selectedRow[i], selectedColumns[j]);
				            }
				          }
				          //Select data and delete
				          System.out.println("Selected: " + selectedData);
					      NonMemberCollection.deleteOne(Filters.eq("SRUNumber", selectedData)); 
					      System.out.println("A player have been successfully deleted.");
				        }

				      }); 
			}
		});
		btnDelete.setBounds(315, 564, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}