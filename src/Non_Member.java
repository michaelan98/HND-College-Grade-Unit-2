import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Non_Member {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSRU;
	private JTextField txtDOB;
	private JTextField txtEmail;
	private JTextField txtAd;
	private JTextField txtPostcode;
	private JTextField txtTel;
	private JTextField txtMobile;

	// connect to db and get junior collection
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();

	MongoCollection<Document> NonMemberCollection = simplyRugby.getCollection("Non_Member");

	/**
	 * Launch the application.
	 */
	public static void NonMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Non_Member window = new Non_Member();
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
	public Non_Member() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 598, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(262, 98, 116, 22);
		frame.getContentPane().add(txtName);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(217, 101, 38, 16);
		frame.getContentPane().add(lblName);

		JLabel lblSRU = new JLabel("SRU Number:");
		lblSRU.setBounds(179, 76, 78, 16);
		frame.getContentPane().add(lblSRU);

		txtSRU = new JTextField();
		txtSRU.setColumns(10);
		txtSRU.setBounds(262, 73, 116, 22);
		frame.getContentPane().add(txtSRU);

		JLabel lblDOB = new JLabel("Date of birth:");
		lblDOB.setBounds(179, 133, 76, 16);
		frame.getContentPane().add(lblDOB);

		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(262, 130, 116, 22);
		frame.getContentPane().add(txtDOB);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(217, 162, 38, 16);
		frame.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(262, 162, 155, 22);
		frame.getContentPane().add(txtEmail);

		JLabel lblAd = new JLabel("Address:");
		lblAd.setBounds(204, 191, 51, 16);
		frame.getContentPane().add(lblAd);

		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(262, 188, 155, 40);
		frame.getContentPane().add(txtAd);

		JLabel lblPostcode = new JLabel("Postcode:");
		lblPostcode.setBounds(199, 241, 56, 16);
		frame.getContentPane().add(lblPostcode);

		txtPostcode = new JTextField();
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(262, 241, 116, 22);
		frame.getContentPane().add(txtPostcode);

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(262, 266, 116, 22);
		frame.getContentPane().add(txtTel);

		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(232, 269, 23, 16);
		frame.getContentPane().add(lblTel);

		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(262, 291, 116, 22);
		frame.getContentPane().add(txtMobile);

		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(213, 294, 42, 16);
		frame.getContentPane().add(lblMobile);

		JLabel lblNonmemberRegister = new JLabel("Non-Member Register");
		lblNonmemberRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNonmemberRegister.setBounds(199, 13, 193, 50);
		frame.getContentPane().add(lblNonmemberRegister);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Non member details
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

				//Storing data into the database	
				Document document = new Document();

				//Storing Player details
				document.append("SRUNumber", SRUNumber)
				.append("Name", name)
				.append("DoB", dob)
				.append("Email", email)
				.append("Address", address)
				.append("Postcode", postcode)
				.append("Tel", telNumber)
				.append("Mobile", mobileNumber);

				NonMemberCollection.insertOne(document);
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
				//Display message when record is saved
				JOptionPane.showMessageDialog(null,"New Record Saved");
			}
		});
		btnSave.setBounds(325, 351, 70, 25);
		frame.getContentPane().add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(235, 351, 78, 25);
		frame.getContentPane().add(btnBack);
	}
}
