import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Senior {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSRU;
	private JTextField txtDOB;
	private JTextField txtEmail;
	private JTextField txtAd;
	private JTextField txtPostcode;
	private JTextField txtTel;
	private JTextField txtMobile;
	private JTextField txtDoctor;
	private JTextField txtTel2;
	private JTextField txtKin;
	private JTextField txtTel1;

	// connect to db and get junior collection
		ConnectDB dbClass = new ConnectDB();
		MongoDatabase simplyRugby = dbClass.getDatabase();
		
		MongoCollection<Document> SeniorCollection = simplyRugby.getCollection("Senior");
		private JTextField txtPosition;
	
	/**
	 * Launch the application.
	 */
	public static void SRMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Senior window = new Senior();
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
	public Senior() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 670, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(121, 111, 116, 22);
		frame.getContentPane().add(txtName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(76, 114, 38, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblSRU = new JLabel("SRU Number:");
		lblSRU.setBounds(38, 89, 78, 16);
		frame.getContentPane().add(lblSRU);
		
		txtSRU = new JTextField();
		txtSRU.setColumns(10);
		txtSRU.setBounds(121, 86, 116, 22);
		frame.getContentPane().add(txtSRU);
		
		JLabel lblDOB = new JLabel("Date of birth:");
		lblDOB.setBounds(38, 146, 76, 16);
		frame.getContentPane().add(lblDOB);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(121, 143, 116, 22);
		frame.getContentPane().add(txtDOB);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(76, 175, 38, 16);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(121, 175, 155, 22);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblAd = new JLabel("Address:");
		lblAd.setBounds(63, 204, 51, 16);
		frame.getContentPane().add(lblAd);
		
		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(121, 201, 155, 40);
		frame.getContentPane().add(txtAd);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		lblPostcode.setBounds(58, 254, 56, 16);
		frame.getContentPane().add(lblPostcode);
		
		txtPostcode = new JTextField();
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(121, 254, 116, 22);
		frame.getContentPane().add(txtPostcode);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(121, 279, 116, 22);
		frame.getContentPane().add(txtTel);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(91, 282, 23, 16);
		frame.getContentPane().add(lblTel);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(121, 304, 116, 22);
		frame.getContentPane().add(txtMobile);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(72, 307, 42, 16);
		frame.getContentPane().add(lblMobile);
		
		JLabel lblSeniorRegister = new JLabel("Senior Register");
		lblSeniorRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeniorRegister.setBounds(247, 25, 135, 50);
		frame.getContentPane().add(lblSeniorRegister);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(329, 257, 42, 16);
		frame.getContentPane().add(lblDoctor);
		
		txtDoctor = new JTextField();
		txtDoctor.setColumns(10);
		txtDoctor.setBounds(374, 254, 97, 22);
		frame.getContentPane().add(txtDoctor);
		
		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(522, 254, 97, 22);
		frame.getContentPane().add(txtTel2);
		
		JLabel lblTel2 = new JLabel("Tel:");
		lblTel2.setBounds(495, 257, 23, 16);
		frame.getContentPane().add(lblTel2);
		
		JLabel lblKin = new JLabel("Next of kin:");
		lblKin.setBounds(304, 92, 65, 16);
		frame.getContentPane().add(lblKin);
		
		txtKin = new JTextField();
		txtKin.setColumns(10);
		txtKin.setBounds(374, 89, 97, 22);
		frame.getContentPane().add(txtKin);
		
		txtTel1 = new JTextField();
		txtTel1.setColumns(10);
		txtTel1.setBounds(522, 89, 97, 22);
		frame.getContentPane().add(txtTel1);
		
		JLabel lblTel1 = new JLabel("Tel:");
		lblTel1.setBounds(495, 92, 23, 16);
		frame.getContentPane().add(lblTel1);
		
		txtPosition = new JTextField();
		txtPosition.setBounds(121, 339, 116, 22);
		frame.getContentPane().add(txtPosition);
		txtPosition.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(63, 342, 55, 16);
		frame.getContentPane().add(lblPosition);
		
		//Save Senior player details Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				String kin_name = txtKin.getText();
				String kin_telNumber = txtTel1.getText();
				
				String doctor_name = txtDoctor.getText();
				String doctor_telNumber = txtTel2.getText();
				
				// player profile 
				S_profile newProfile = new S_profile(1,1,1,1,1,1,1,1,1,1,1);
				
				//Storing data into the database	
				Document document = new Document();
				
				ObjectId _id = new ObjectId();

				//Storing Player details, Kin and Doctor Details
				document.append("_", _id)
				.append("SRUNumber", SRUNumber)
				.append("Name", name)
				.append("DoB", dob)
				.append("Email", email)
				.append("Address", address)
				.append("Postcode", postcode)
				.append("Tel", telNumber)
				.append("Mobile", mobileNumber)
				.append("Position", position)
				.append("kin_name", kin_name)
				.append("kin_telNumber", kin_telNumber)
				.append("doctor_name", doctor_name)
				.append("doctor_telNumber", doctor_telNumber);
				
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
				//Insert one document onto the databse
				SeniorCollection.insertOne(document);
				
				//Takes the user back to the menu
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
				//Display message when record is saved
				JOptionPane.showMessageDialog(null,"New Record Saved");
			}
		});
		btnSave.setBounds(509, 400, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(63, 400, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}

class S_profile{
	
	
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
	
	public S_profile(int pass_standard, int pass_spin, int pass_pop, int tackle_front, int tackle_rear,
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
		
		//Setters and Getters
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
