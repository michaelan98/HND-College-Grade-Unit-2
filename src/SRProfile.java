import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SRProfile {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable SRProfileTable;
	
	/**
	 * Launch the application.
	 */
	public static void SRProfileMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SRProfile window = new SRProfile();
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
	public SRProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 1005, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] headings = new String[]{"pass_standard", "pass_spin", "pass_pop",
				 "tackle_front", "tackle_rear", "tackle_side", "tackle_scrabble", 
				 "kick_drop", "kick_punt", "kick_grubbler", "kick_goal"};

		DefaultTableModel model = new DefaultTableModel(headings, 0);
		
		ArrayList<S_profile> profiles = DisplaySeniorDetails.profiles;
		//Loop through the array and pass the skill level into a table
		for(int i = 0; i<profiles.size(); i++) {
		int pass_standard = profiles.get(i).getPass_standard();
		int pass_spin = profiles.get(i).getPass_spin();
		int pass_pop = profiles.get(i).getPass_pop();
		// tackling details
		int tackle_front = profiles.get(i).getTackle_front();
		int tackle_rear = profiles.get(i).getTackle_rear();
		int tackle_side = profiles.get(i).getTackle_side();
		int tackle_scrabble = profiles.get(i).getTackle_scrabble();
		//kicking details
		int kick_drop = profiles.get(i).getKick_drop();
		int kick_punt = profiles.get(i).getKick_punt();
		int kick_grubbler = profiles.get(i).getKick_grubbler();
		int kick_goal = profiles.get(i).getKick_goal();
		
		model.addRow(new Object[] {pass_standard,pass_spin, pass_pop,
		tackle_front ,tackle_rear, tackle_side,tackle_scrabble,
		kick_drop,kick_punt,kick_grubbler,kick_goal});
		
		}
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 969, 320);
		frame.getContentPane().add(scrollPane);
		
		SRProfileTable = new JTable(model);
		scrollPane.setViewportView(SRProfileTable);
		SRProfileTable.setCellSelectionEnabled(true);
		SRProfileTable.setColumnSelectionAllowed(true);
		
		
		//Back button
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplaySeniorDetails.DisplaySeniorMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnBack.setBounds(483, 467, 97, 25);
		frame.getContentPane().add(btnBack);
		frame.setTitle("Senior Player Profile table");
	}
}
