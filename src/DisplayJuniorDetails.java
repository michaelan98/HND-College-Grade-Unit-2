import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayJuniorDetails {

	JFrame frame;
	private JTable juniorTable;

	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();

	MongoCollection<Document> JuniorCollection = simplyRugby.getCollection("Junior");
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	static ArrayList<J_profile> profiles = new ArrayList();
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void DisplayJuniorMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayJuniorDetails window = new DisplayJuniorDetails();
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
	public DisplayJuniorDetails() {
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
		frame.setTitle("Junior table"); 

		//headings for the table
		String[] headings = new String[]{"SRUNumber", "Name", "DoB", "Email", "Address", "Postcode", "Tel", "Mobile", "Position"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);
		profiles = new ArrayList();

		FindIterable<Document> juniors = JuniorCollection.find();

		//Loop through the database and get the details
		for(Document j : juniors) {
			String SRUNumber = j.getString("SRUNumber");
			String Name = j.getString("Name");
			String DOB = j.getString("DoB");
			String Email = j.getString("Email");
			String Address = j.getString("Address");
			String Postcode = j.getString("Postcode");
			String Tel = j.getString("Tel");
			String Mobile = j.getString("Mobile");
			String Position = j.getString("Position");

			Document profile = j.get("Profile", Document.class);

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

			J_profile readProfile = new J_profile(pass_standard, pass_spin, pass_pop,
					tackle_front, tackle_rear, tackle_side, tackle_scrabble, 
					kick_drop, kick_punt, kick_grubbler, kick_goal);

			readProfile.set_id(j.getObjectId("_id"));
			profiles.add(readProfile);

			//Adds a row when details found
			model.addRow(new Object[] {SRUNumber,Name, DOB, Email ,Address, Postcode,Tel,Mobile,Position});
		}

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 978, 340);
		frame.getContentPane().add(scrollPane);

		juniorTable = new JTable(model);

		scrollPane.setViewportView(juniorTable);
		juniorTable.setCellSelectionEnabled(true);
		juniorTable.setColumnSelectionAllowed(true);

		btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JRProfile.JRProfileMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(530, 563, 97, 25);
		frame.getContentPane().add(btnNewButton);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Deleting the documents 
				ListSelectionModel cellSelectionModel = juniorTable.getSelectionModel();
				cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

				cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						String selectedData = null;

						int[] selectedRow = juniorTable.getSelectedRows();
						int[] selectedColumns = juniorTable.getSelectedColumns();

						for (int i = 0; i < selectedRow.length; i++) {
							for (int j = 0; j < selectedColumns.length; j++) {
								selectedData = (String) juniorTable.getValueAt(selectedRow[i], selectedColumns[j]);
							}
						}
						//Select data and delete
						System.out.println("Selected: " + selectedData);
						JuniorCollection.deleteOne(Filters.eq("SRUNumber", selectedData)); 
						System.out.println("A player have been successfully deleted.");
					}

				}); 
				/* MongoCollection<Document> JuniorCollection = simplyRugby.getCollection("Junior");
			      System.out.println("Collection myCollection selected successfully"); 

			      JuniorCollection.updateOne(Filters.eq("SRUNumber", "asd"), Updates.set("likes", 150));       
			      System.out.println("Document update successfully...");  

			      // Retrieving the documents after updation 
			      // Getting the iterable object
			      FindIterable<Document> iterDoc = JuniorCollection.find(); 
			      int i = 1; 

			      // Getting the iterator 
			      Iterator it = iterDoc.iterator(); 

			      while (it.hasNext()) {  
			         System.out.println(it.next());  
			         i++; 
			      }*/
			}
		});
		btnDelete.setBounds(314, 563, 97, 25);
		frame.getContentPane().add(btnDelete);
	}
}













