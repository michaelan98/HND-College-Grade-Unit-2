import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.util.Date;

public class NewGameRecord {

	private JFrame frame;
	private JTextField txtOpponent;
	private JTextField txtDateofMatch;
	private JTextField txtTime;
	private JTextField txtScore;
	private JTextField txtLocation;
	private JTextField txtResult;
	private JTextField txtSRComment;
	private JTextField txtSRScore;
	private JTextField txtOppComment;
	private JTextField txtOppScore;
	private JTextField txtSRComment2;
	private JTextField txtOppComment2;
	private JTextField txtSRScore2;
	private JTextField txtOppScore2;
	
	// connect to db and get junior collection
			ConnectDB dbClass = new ConnectDB();
			MongoDatabase simplyRugby = dbClass.getDatabase();
			
			MongoCollection<Document> GameRecordCollection = simplyRugby.getCollection("GameRecord");

	/**
	 * Launch the application.
	 */
	public static void NewGameRecordMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGameRecord window = new NewGameRecord();
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
	public NewGameRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 624, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtOpponent = new JTextField();
		txtOpponent.setBounds(74, 11, 86, 20);
		frame.getContentPane().add(txtOpponent);
		txtOpponent.setColumns(10);
		
		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setBounds(10, 14, 63, 14);
		frame.getContentPane().add(lblOpponent);
		
		txtDateofMatch = new JTextField();
		txtDateofMatch.setBounds(465, 10, 116, 22);
		frame.getContentPane().add(txtDateofMatch);
		txtDateofMatch.setColumns(10);
		
		JLabel lblDateOfMatch = new JLabel("Date of match:");
		lblDateOfMatch.setBounds(376, 13, 86, 14);
		frame.getContentPane().add(lblDateOfMatch);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(465, 36, 116, 22);
		frame.getContentPane().add(txtTime);
		
		JLabel lblKoTime = new JLabel("K/O time:");
		lblKoTime.setBounds(407, 40, 55, 14);
		frame.getContentPane().add(lblKoTime);
		
		txtScore = new JTextField();
		txtScore.setBounds(465, 62, 116, 22);
		frame.getContentPane().add(txtScore);
		txtScore.setColumns(10);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(417, 67, 45, 14);
		frame.getContentPane().add(lblScore);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(20, 39, 53, 14);
		frame.getContentPane().add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(10);
		txtLocation.setBounds(74, 36, 86, 20);
		frame.getContentPane().add(txtLocation);
		
		txtResult = new JTextField();
		txtResult.setColumns(10);
		txtResult.setBounds(74, 62, 86, 20);
		frame.getContentPane().add(txtResult);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(30, 65, 45, 14);
		frame.getContentPane().add(lblResult);
		
		JLabel lblGameRecord = new JLabel("Game Record");
		lblGameRecord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGameRecord.setBounds(224, 11, 123, 45);
		frame.getContentPane().add(lblGameRecord);
		
		JLabel lblFirstHalf = new JLabel("First half");
		lblFirstHalf.setBounds(17, 157, 56, 16);
		frame.getContentPane().add(lblFirstHalf);
		
		txtSRComment = new JTextField();
		txtSRComment.setBounds(10, 207, 116, 131);
		frame.getContentPane().add(txtSRComment);
		txtSRComment.setColumns(10);
		
		JLabel lblSimplyRugby = new JLabel("Simply Rugby");
		lblSimplyRugby.setBackground(Color.WHITE);
		lblSimplyRugby.setBounds(17, 178, 86, 16);
		frame.getContentPane().add(lblSimplyRugby);
		
		JLabel lblScore_1 = new JLabel("For");
		lblScore_1.setBounds(12, 341, 33, 16);
		frame.getContentPane().add(lblScore_1);
		
		txtSRScore = new JTextField();
		txtSRScore.setBounds(10, 355, 116, 22);
		frame.getContentPane().add(txtSRScore);
		txtSRScore.setColumns(10);
		
		JLabel lblOpposition = new JLabel("Opposition");
		lblOpposition.setBackground(Color.WHITE);
		lblOpposition.setBounds(135, 178, 63, 16);
		frame.getContentPane().add(lblOpposition);
		
		JLabel lblSecondHalf = new JLabel("Second half");
		lblSecondHalf.setBounds(339, 157, 74, 16);
		frame.getContentPane().add(lblSecondHalf);
		
		txtOppComment = new JTextField();
		txtOppComment.setColumns(10);
		txtOppComment.setBounds(135, 207, 116, 131);
		frame.getContentPane().add(txtOppComment);
		
		txtOppScore = new JTextField();
		txtOppScore.setColumns(10);
		txtOppScore.setBounds(135, 355, 116, 22);
		frame.getContentPane().add(txtOppScore);
		
		JLabel lblAgainst = new JLabel("Against");
		lblAgainst.setBounds(135, 341, 45, 16);
		frame.getContentPane().add(lblAgainst);
		
		JLabel lblSimplyRugby2 = new JLabel("Simply Rugby");
		lblSimplyRugby2.setBackground(Color.WHITE);
		lblSimplyRugby2.setBounds(339, 178, 86, 16);
		frame.getContentPane().add(lblSimplyRugby2);
		
		txtSRComment2 = new JTextField();
		txtSRComment2.setColumns(10);
		txtSRComment2.setBounds(339, 207, 116, 131);
		frame.getContentPane().add(txtSRComment2);
		
		txtOppComment2 = new JTextField();
		txtOppComment2.setColumns(10);
		txtOppComment2.setBounds(465, 207, 116, 131);
		frame.getContentPane().add(txtOppComment2);
		
		JLabel lblOpposition2 = new JLabel("Opposition");
		lblOpposition2.setBackground(Color.WHITE);
		lblOpposition2.setBounds(465, 178, 63, 16);
		frame.getContentPane().add(lblOpposition2);
		
		txtSRScore2 = new JTextField();
		txtSRScore2.setColumns(10);
		txtSRScore2.setBounds(339, 355, 116, 22);
		frame.getContentPane().add(txtSRScore2);
		
		JLabel lblFor = new JLabel("For");
		lblFor.setBounds(339, 341, 33, 16);
		frame.getContentPane().add(lblFor);
		
		txtOppScore2 = new JTextField();
		txtOppScore2.setColumns(10);
		txtOppScore2.setBounds(465, 355, 116, 22);
		frame.getContentPane().add(txtOppScore2);
		
		JLabel lblAgainst_1 = new JLabel("Against");
		lblAgainst_1.setBounds(465, 341, 45, 16);
		frame.getContentPane().add(lblAgainst_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Game details
				String Opposition_name = txtOpponent.getText();
				Date cnvDateofMatch = new Date();
				//Get the format from DateUtil
				cnvDateofMatch = DateUtil.convertToDate(txtDateofMatch.getText());
				String pattern = "dd/MM/yyyy";
				DateFormat df = new SimpleDateFormat(pattern);
				String DateofMatch = df.format(cnvDateofMatch);
				String Location = txtLocation.getText();
				String Time = txtTime.getText();
				String Result = txtResult.getText();
				String Score = txtScore.getText();
				
				//First half
				String SRComment = txtSRComment.getText();
				String SRScore = txtSRScore.getText();
				String OppComment = txtOppComment.getText();
				String OppScore = txtOppScore.getText();
				
				//Second half
				String SRComment2 = txtSRComment2.getText();
				String SRScore2 = txtSRScore2.getText();
				String OppComment2 = txtOppComment2.getText();
				String OppScore2 = txtOppScore2.getText();
				
				//Storing data into the database	
				Document document = new Document();

				//Storing game detais
				document.append("Opposition_name", Opposition_name)
				.append("DateofMatch", DateofMatch)
				.append("Location", Location)
				.append("Time", Time)
				.append("Result", Result)
				.append("Score", Score);
				
				 //Storing first half
				document.append("First half", 
						new Document("SRComment", SRComment)
						.append("SRScore", SRScore)
						.append("OppComment", OppComment)
						.append("OppScore", OppScore)
						);
				//Storing Second half
				document.append("Second half", 
						new Document("SRComment2", SRComment2)
						.append("SRScore2", SRScore2)
						.append("OppComment2", OppComment2)
						.append("OppScore2", OppScore2)
						);
				GameRecordCollection.insertOne(document);
				GameRecord.GameRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
				//Display message when record is saved
				JOptionPane.showMessageDialog(null,"New Record Saved");
			}
		});
		btnSave.setBounds(295, 396, 97, 25);
		frame.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GameRecord.GameRecordMenu(null);
			frame.setVisible(false);
			frame.dispose();
			}
		});
		btnBack.setBounds(187, 396, 97, 25);
		frame.getContentPane().add(btnBack);
		
		
	}
}
