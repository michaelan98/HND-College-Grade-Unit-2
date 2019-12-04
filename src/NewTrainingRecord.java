import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NewTrainingRecord {

	private JFrame frame;
	private JTextField txtCoach;
	private JTextField txtDate;
	private JTextField txtLocation;
	private JTextField txtTime;
	private JTextField txtSkills;
	private JTextField txtPlayers;
	private JLabel lblAccidentsinjuries;
	private JTextField txtInjuries;
	private JButton btnBack;
	private JButton btnSave;
	
	ConnectDB dbClass = new ConnectDB();
	MongoDatabase simplyRugby = dbClass.getDatabase();
	
	MongoCollection<Document> TrainingRecordCollection = simplyRugby.getCollection("TrainingRecord");

	/**
	 * Launch the application.
	 */
	public static void NewTrainingRecordMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTrainingRecord window = new NewTrainingRecord();
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
	public NewTrainingRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.getContentPane().setLayout(null);
		
		JLabel lblCoach = new JLabel("Coach:");
		lblCoach.setBounds(145, 65, 40, 16);
		frame.getContentPane().add(lblCoach);
		
		txtCoach = new JTextField();
		txtCoach.setBounds(186, 62, 116, 22);
		frame.getContentPane().add(txtCoach);
		txtCoach.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(432, 62, 40, 16);
		frame.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(473, 59, 116, 22);
		frame.getContentPane().add(txtDate);
		
		JLabel lblTrainingRecord = new JLabel("Training Record");
		lblTrainingRecord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrainingRecord.setBounds(312, 5, 145, 46);
		frame.getContentPane().add(lblTrainingRecord);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(133, 97, 52, 16);
		frame.getContentPane().add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		txtLocation.setBounds(186, 94, 116, 22);
		frame.getContentPane().add(txtLocation);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(432, 94, 40, 16);
		frame.getContentPane().add(lblTime);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(473, 91, 116, 22);
		frame.getContentPane().add(txtTime);
		
		JLabel lblSkills = new JLabel("Skills and activites:");
		lblSkills.setBounds(183, 153, 116, 16);
		frame.getContentPane().add(lblSkills);
		
		txtSkills = new JTextField();
		txtSkills.setBounds(183, 171, 406, 82);
		frame.getContentPane().add(txtSkills);
		txtSkills.setColumns(10);
		
		JLabel lblPlayersPresent = new JLabel("Players Present:");
		lblPlayersPresent.setBounds(186, 255, 93, 16);
		frame.getContentPane().add(lblPlayersPresent);
		
		txtPlayers = new JTextField();
		txtPlayers.setBounds(186, 272, 403, 61);
		frame.getContentPane().add(txtPlayers);
		txtPlayers.setColumns(10);
		
		lblAccidentsinjuries = new JLabel("Accidents/Injuries:");
		lblAccidentsinjuries.setBounds(186, 335, 109, 16);
		frame.getContentPane().add(lblAccidentsinjuries);
		
		txtInjuries = new JTextField();
		txtInjuries.setColumns(10);
		txtInjuries.setBounds(186, 354, 403, 61);
		frame.getContentPane().add(txtInjuries);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingRecord.TrainingRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});	
		btnBack.setBounds(77, 372, 97, 25);
		frame.getContentPane().add(btnBack);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Training Record details
				String Coach = txtCoach.getText();
				Date cnvDate = new Date();
				//Get the format from DateUtil
				cnvDate = DateUtil.convertToDate(txtDate.getText());
				String pattern = "dd/MM/yyyy";
				DateFormat df = new SimpleDateFormat(pattern);
				String Date = df.format(cnvDate);
				String Location = txtLocation.getText();
				String Time = txtTime.getText();
				
				//Activity, Players and accidents
				String Skills = txtSkills.getText();
				String Players = txtPlayers.getText();
				String Injuries = txtInjuries.getText();
				
				//Storing data into the database	
				Document document = new Document();

				//Storing game detais
				document.append("Coach", Coach)
				.append("Date", Date)
				.append("Location", Location)
				.append("Time", Time)
				.append("Skills", Skills)
				.append("Players", Players)
				.append("Injuries", Injuries);
				/* //Activity
				document.append("Activity", 
						new Document("Skills", Skills)
						.append("Players", Players)
						.append("Injuries", Injuries)
						);*/
				TrainingRecordCollection.insertOne(document);
				TrainingRecord.TrainingRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
				//Display message when record is saved
				JOptionPane.showMessageDialog(null,"New Record Saved");
			}
		});
		btnSave.setBounds(601, 372, 97, 25);
		frame.getContentPane().add(btnSave);
		frame.setBounds(100, 100, 813, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
