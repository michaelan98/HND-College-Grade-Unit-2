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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DisplaySeniorDetails {

	private JFrame frame;
	private JTable seniorTable;
	
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> SeniorCollection = simplyRugby.getCollection("Senior");
	private JScrollPane scrollPane;
	static ArrayList<S_profile> profiles = new ArrayList();
	private JButton btnProfile;

	/**
	 * Launch the application.
	 */
	public static void DisplaySeniorMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplaySeniorDetails window = new DisplaySeniorDetails();
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
	public DisplaySeniorDetails() {
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
		frame.setTitle("Senior table"); 
	       
      //headings for the table
        String[] headings = new String[]{"SRUNumber", "Name", "DoB", "Email", "Address", "Postcode", "Tel", "Mobile", "Position", 
        		 "Kin", "Tel", "Doctor", "Tel"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);
		profiles = new ArrayList();

		//Find the collection from the database
        FindIterable<Document> seniors = SeniorCollection.find();
       //Loop through the database and get the details
        for(Document s : seniors) {
        	String SRUNumber = s.getString("SRUNumber");
        	String Name = s.getString("Name");
        	String DOB = s.getString("DoB");
        	String Email = s.getString("Email");
        	String Address = s.getString("Address");
        	String Postcode = s.getString("Postcode");
        	String Tel = s.getString("Tel");
        	String Mobile = s.getString("Mobile");
        	String Position = s.getString("Position");
        	String kin_name = s.getString("kin_name");
        	String kin_telNumber = s.getString("kin_telNumber");
        	String doctor_name = s.getString("doctor_name");
        	String doctor_telNumber = s.getString("doctor_telNumber");
        	
        	Document profile = s.get("Profile", Document.class);
        	
        	Document passing = profile.get("Passing", Document.class);
        	Document tackling = profile.get("Tacklng", Document.class);
        	Document kicking = profile.get("Kicking", Document.class);
        	
        	//Passing
	       	 int pass_standard = passing.getInteger("Standard");
	       	 int pass_spin = passing.getInteger("Spin");
	       	 int pass_pop = passing.getInteger("Pop");
	       	// tackling details
	       	 int tackle_front = tackling.getInteger("Front");
	       	 int tackle_rear = tackling.getInteger("Rear");
	       	 int tackle_side = tackling.getInteger("Side");
	       	 int tackle_scrabble = tackling.getInteger("Scrabble");
	       	//kicking details
	       	 int kick_drop = kicking.getInteger("Drop");
	       	 int kick_punt = kicking.getInteger("Punt");
	       	 int kick_grubbler = kicking.getInteger("Grubbler");
	       	 int kick_goal = kicking.getInteger("Goal");
	       	 
	       	 S_profile readProfile = new S_profile(pass_standard, pass_spin, pass_pop,
        			 tackle_front, tackle_rear, tackle_side, tackle_scrabble, 
        			 kick_drop, kick_punt, kick_grubbler, kick_goal);
	       	 
	       	readProfile.set_id(s.getObjectId("_id"));
	       	profiles.add(readProfile);
        	//Adds a row when details found
            model.addRow(new Object[] {SRUNumber,Name, DOB, Email ,Address, Postcode,Tel,Mobile,Position,
            		kin_name,kin_telNumber, doctor_name, doctor_telNumber});
        }
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 978, 340);
		frame.getContentPane().add(scrollPane);
		seniorTable = new JTable(model);
		scrollPane.setViewportView(seniorTable);
		seniorTable.setCellSelectionEnabled(true);
		seniorTable.setColumnSelectionAllowed(true);
		
		btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SRProfile.SRProfileMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnProfile.setBounds(533, 563, 97, 25);
		frame.getContentPane().add(btnProfile);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Deleting the documents 
			      ListSelectionModel cellSelectionModel = seniorTable.getSelectionModel();
			      cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			      cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
				        public void valueChanged(ListSelectionEvent e) {
				          String selectedData = null;

				          int[] selectedRow = seniorTable.getSelectedRows();
				          int[] selectedColumns = seniorTable.getSelectedColumns();

				          for (int i = 0; i < selectedRow.length; i++) {
				            for (int j = 0; j < selectedColumns.length; j++) {
				              selectedData = (String) seniorTable.getValueAt(selectedRow[i], selectedColumns[j]);
				            }
				          }
				          //Select data and delete
				          System.out.println("Selected: " + selectedData);
					      SeniorCollection.deleteOne(Filters.eq("SRUNumber", selectedData)); 
					      System.out.println("A player have been successfully deleted.");
				        }

				      }); 
			}
		});
		btnDelete.setBounds(320, 564, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
}