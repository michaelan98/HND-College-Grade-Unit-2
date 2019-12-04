import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Junior {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSRU;
	private JTextField txtDOB;
	private JTextField txtEmail;
	private JTextField txtAd;
	private JTextField txtPostcode;
	private JTextField txtTel;
	private JTextField txtMobile;
	private JLabel lblMobile;
	private JTextField txtG1;
	private JLabel lblGuardian;
	private JLabel lblGuardian_1;
	private JTextField txtG2;
	private JTextField txtRel1;
	private JLabel lblRelationship;
	private JLabel label;
	private JTextField txtRel2;
	private JTextField txtAd1;
	private JLabel lblAddress1;
	private JTextField txtAd2;
	private JLabel lblAddress2;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JLabel lblTel1;
	private JLabel lblTel2;
	private JLabel lblDoctor;
	private JTextField txtDoctor;
	private JTextField txtAd4;
	private JLabel lblAd3;
	private JTextField txtTel3;
	private JLabel lblTel3;
	
	// connect to db and get junior collection
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> JuniorCollection = simplyRugby.getCollection("Junior");
	
	
	private JTextField txtPosition;
	private JButton btnBack;
	/*
	 * Launch the application.
	 */
	public static void JrMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Junior window = new Junior();
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
	public Junior() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 705, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(95, 97, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 100, 38, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblSruNumber = new JLabel("SRU Number:");
		lblSruNumber.setBounds(12, 75, 78, 16);
		frame.getContentPane().add(lblSruNumber);
		
		txtSRU = new JTextField();
		txtSRU.setColumns(10);
		txtSRU.setBounds(95, 72, 116, 22);
		frame.getContentPane().add(txtSRU);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setBounds(12, 132, 76, 16);
		frame.getContentPane().add(lblDateOfBirth);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(95, 129, 116, 22);
		frame.getContentPane().add(txtDOB);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(50, 161, 38, 16);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 161, 155, 22);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(37, 190, 51, 16);
		frame.getContentPane().add(lblAddress);
		
		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(95, 187, 155, 40);
		frame.getContentPane().add(txtAd);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		lblPostcode.setBounds(32, 240, 56, 16);
		frame.getContentPane().add(lblPostcode);
		
		txtPostcode = new JTextField();
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(95, 240, 116, 22);
		frame.getContentPane().add(txtPostcode);
		
		
		JLabel lblJuniorRegister = new JLabel("Junior Register");
		lblJuniorRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJuniorRegister.setBounds(276, 13, 132, 50);
		frame.getContentPane().add(lblJuniorRegister);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(95, 265, 116, 22);
		frame.getContentPane().add(txtTel);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(65, 268, 23, 16);
		frame.getContentPane().add(lblTel);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(95, 290, 116, 22);
		frame.getContentPane().add(txtMobile);
		
		lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(46, 293, 42, 16);
		frame.getContentPane().add(lblMobile);
		
		txtG1 = new JTextField();
		txtG1.setBounds(389, 72, 97, 22);
		frame.getContentPane().add(txtG1);
		txtG1.setColumns(10);
		
		lblGuardian = new JLabel("Guardian 1:");
		lblGuardian.setBounds(319, 75, 67, 16);
		frame.getContentPane().add(lblGuardian);
		
		lblGuardian_1 = new JLabel("Guardian 2:");
		lblGuardian_1.setBounds(498, 75, 67, 16);
		frame.getContentPane().add(lblGuardian_1);
		
		txtG2 = new JTextField();
		txtG2.setColumns(10);
		txtG2.setBounds(566, 72, 97, 22);
		frame.getContentPane().add(txtG2);
		
		txtRel1 = new JTextField();
		txtRel1.setColumns(10);
		txtRel1.setBounds(389, 97, 97, 22);
		frame.getContentPane().add(txtRel1);
		
		lblRelationship = new JLabel("Relationship:");
		lblRelationship.setBounds(308, 100, 78, 16);
		frame.getContentPane().add(lblRelationship);
		
		label = new JLabel("Relationship:");
		label.setBounds(487, 100, 78, 16);
		frame.getContentPane().add(label);
		
		txtRel2 = new JTextField();
		txtRel2.setColumns(10);
		txtRel2.setBounds(566, 97, 97, 22);
		frame.getContentPane().add(txtRel2);
		
		txtAd1 = new JTextField();
		txtAd1.setColumns(10);
		txtAd1.setBounds(389, 129, 97, 40);
		frame.getContentPane().add(txtAd1);
		
		lblAddress1 = new JLabel("Address:");
		lblAddress1.setBounds(335, 132, 51, 16);
		frame.getContentPane().add(lblAddress1);
		
		txtAd2 = new JTextField();
		txtAd2.setColumns(10);
		txtAd2.setBounds(566, 129, 97, 40);
		frame.getContentPane().add(txtAd2);
		
		lblAddress2 = new JLabel("Address:");
		lblAddress2.setBounds(514, 132, 51, 16);
		frame.getContentPane().add(lblAddress2);
		
		txtTel1 = new JTextField();
		txtTel1.setColumns(10);
		txtTel1.setBounds(389, 171, 97, 22);
		frame.getContentPane().add(txtTel1);
		
		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(566, 171, 97, 22);
		frame.getContentPane().add(txtTel2);
		
		lblTel1 = new JLabel("Tel:");
		lblTel1.setBounds(361, 174, 23, 16);
		frame.getContentPane().add(lblTel1);
		
		lblTel2 = new JLabel("Tel:");
		lblTel2.setBounds(542, 174, 23, 16);
		frame.getContentPane().add(lblTel2);
		
		lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(344, 240, 42, 16);
		frame.getContentPane().add(lblDoctor);
		
		txtDoctor = new JTextField();
		txtDoctor.setColumns(10);
		txtDoctor.setBounds(389, 237, 97, 22);
		frame.getContentPane().add(txtDoctor);
		
		txtAd4 = new JTextField();
		txtAd4.setColumns(10);
		txtAd4.setBounds(389, 265, 97, 40);
		frame.getContentPane().add(txtAd4);
		
		lblAd3 = new JLabel("Address:");
		lblAd3.setBounds(335, 268, 51, 16);
		frame.getContentPane().add(lblAd3);
		
		txtTel3 = new JTextField();
		txtTel3.setColumns(10);
		txtTel3.setBounds(537, 237, 97, 22);
		frame.getContentPane().add(txtTel3);
		
		lblTel3 = new JLabel("Tel:");
		lblTel3.setBounds(510, 240, 23, 16);
		frame.getContentPane().add(lblTel3);
		
		txtPosition = new JTextField();
		txtPosition.setBounds(95, 320, 116, 22);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(37, 322, 56, 16);
		frame.getContentPane().add(lblPosition);
		
		//Save Junior player details button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			// player details
			String SRUNumber = txtSRU.getText();
			String name = txtName.getText();
			Date cnvDOB = new Date();
			//Get the format from DateUtil
			cnvDOB = DateUtil.convertToDate(txtDOB.getText());
			String pattern = "dd/MM/yyyy";
			DateFormat df = new SimpleDateFormat(pattern);
			String dob = df.format(cnvDOB);
			String email = txtEmail.getText();
			String address = txtAd.getText();
			String postcode = txtPostcode.getText();
			String telNumber = txtTel.getText();
			String mobileNumber = txtMobile.getText();
			String position = txtPosition.getText();

			// guardian 1 details
			String g1 = txtG1.getText();
			String g1_relatonship = txtRel1.getText();
			String g1_address = txtAd1.getText();
			String g1_telNumber = txtTel1.getText();

			// guardian 2 details
			String g2 = txtG2.getText();
			String g2_relatonship = txtRel2.getText();
			String g2_address = txtAd2.getText();
			String g2_telNumber = txtTel2.getText();

			//  doctor detials
			String doctor_name = txtDoctor.getText();
			String doctor_address = txtAd4.getText();
			String doctor_telNumber = txtTel3.getText();
			
			
			
			// player profile 
			J_profile newProfile = new J_profile(1,1,1,1,1,1,1,1,1,1,1);

			//Storing data into the database	
			Document document = new Document();

			ObjectId _id = new ObjectId();
			
			//Storing Player details
			document.append("_", _id)
			.append("SRUNumber", SRUNumber)
			.append("Name", name)
			.append("DoB", dob)
			.append("Email", email)
			.append("Address", address)
			.append("Postcode", postcode)
			.append("Tel", telNumber)
			.append("Mobile", mobileNumber)
			.append("Position", position);
			
			/// Storing Guardian 1 and 2 details
			 document.append("Guardians",
                    new Document("Guardian_1",
                            new Document("Name", g1)
                                    .append("Relationship", g1_relatonship)
                                    .append("Address", g1_address)
                                    .append("TelNumber", g1_telNumber))
                            .append("Guardian_2",
                                    new Document("Name", g2)
                                            .append("Relationship", g2_relatonship)
                                            .append("Address", g2_address )
                                            .append("TelNumber", g2_telNumber )));
				
			 //Storing doctor details
				document.append("Doctor", 
						new Document("Name", doctor_name)
						.append("Address", doctor_address)
						.append("Tel", doctor_telNumber)
						);
				
				 document.append("Profile",
		                    new Document("Passing",
		                            new Document("Standard", newProfile.getPass_standard())
		                                    .append("Spin", newProfile.getPass_spin())
		                                    .append("Pop", newProfile.getPass_pop()))
		                            .append("Tacklng",
		                                    new Document("Front", newProfile.getTackle_front())
		                                            .append("Rear", newProfile.getTackle_rear())
		                                            .append("Side", newProfile.getTackle_side())
		                                            .append("Scrabble", newProfile.getTackle_scrabble()))
		                            .append("Kicking",
		        		                     new Document("Drop", newProfile.getKick_drop())
		                                            .append("Punt", newProfile.getKick_punt())
		                                            .append("Grubbler", newProfile.getKick_grubbler())
		                                            .append("Goal", newProfile.getKick_goal())
                                        ));
				//Insert one document onto the database
				JuniorCollection.insertOne(document);
				
				//Takes the user back to the menu
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
				//Display message when record is saved
				JOptionPane.showMessageDialog(null,"New Record Saved");
			}
		});
		btnSave.setBounds(542, 374, 97, 25);
		frame.getContentPane().add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(50, 374, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}

class J_profile{
	
	private ObjectId _id;
	/// varibles
	// passsing deails
	private int pass_standard;
	private int pass_spin;
	private int pass_pop;
	// tackling details
	private int tackle_front;
	private int tackle_rear;
	private int tackle_side;
	private int tackle_scrabble;
	//kicking details
	private int kick_drop;
	private int kick_punt;
	private int kick_grubbler;
	private int kick_goal;
	
	public J_profile(int pass_standard, int pass_spin, int pass_pop, int tackle_front, int tackle_rear,
			int tackle_side, int tackle_scrabble, int kick_drop, int kick_punt, int kick_grubbler, int kick_goal) {
		super();
		this.pass_standard = pass_standard;
		this.pass_spin = pass_spin;
		this.pass_pop = pass_pop;
		this.tackle_front = tackle_front;
		this.tackle_rear = tackle_rear;
		this.tackle_side = tackle_side;
		this.tackle_scrabble = tackle_scrabble;
		this.kick_drop = kick_drop;
		this.kick_punt = kick_punt;
		this.kick_grubbler = kick_grubbler;
		this.kick_goal = kick_goal;
	}
	public int getPass_standard() {
		return pass_standard;
	}
	public void setPass_standard(int pass_standard) {
		this.pass_standard = pass_standard;
	}
	public int getPass_spin() {
		return pass_spin;
	}
	public void setPass_spin(int pass_spin) {
		this.pass_spin = pass_spin;
	}
	public int getPass_pop() {
		return pass_pop;
	}
	public void setPass_pop(int pass_front) {
		this.pass_pop = pass_front;
	}
	public int getTackle_front() {
		return tackle_front;
	}
	public void setTackle_front(int tackle_front) {
		this.tackle_front = tackle_front;
	}
	public int getTackle_rear() {
		return tackle_rear;
	}
	public void setTackle_rear(int tackle_rear) {
		this.tackle_rear = tackle_rear;
	}
	public int getTackle_side() {
		return tackle_side;
	}
	public void setTackle_side(int tackle_side) {
		this.tackle_side = tackle_side;
	}
	public int getTackle_scrabble() {
		return tackle_scrabble;
	}
	public void setTackle_scrabble(int tackle_scrabble) {
		this.tackle_scrabble = tackle_scrabble;
	}
	public int getKick_drop() {
		return kick_drop;
	}
	public void setKick_drop(int kick_drop) {
		this.kick_drop = kick_drop;
	}
	public int getKick_punt() {
		return kick_punt;
	}
	public void setKick_punt(int kick_punt) {
		this.kick_punt = kick_punt;
	}
	public int getKick_grubbler() {
		return kick_grubbler;
	}
	public void setKick_grubbler(int kick_grubbler) {
		this.kick_grubbler = kick_grubbler;
	}
	public int getKick_goal() {
		return kick_goal;
	}
	public void setKick_goal(int kick_goal) {
		this.kick_goal = kick_goal;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
}

