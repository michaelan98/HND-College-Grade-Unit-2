import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void MainMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 598, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Menu");
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.RegiMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnRegister.setBounds(49, 66, 164, 43);
		frame.getContentPane().add(btnRegister);
		
		JButton btnGR = new JButton("Game Record");
		btnGR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameRecord.GameRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnGR.setBounds(49, 156, 164, 51);
		frame.getContentPane().add(btnGR);
		
		JButton btnTR = new JButton("Training Record");
		btnTR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingRecord.TrainingRecordMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnTR.setBounds(51, 245, 162, 52);
		frame.getContentPane().add(btnTR);
		
		JButton btnJunior = new JButton("Junior");
		btnJunior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayJuniorDetails.DisplayJuniorMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnJunior.setBounds(357, 66, 162, 43);
		frame.getContentPane().add(btnJunior);
		
		JButton btnSenior = new JButton("Senior");
		btnSenior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisplaySeniorDetails.DisplaySeniorMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnSenior.setBounds(357, 156, 162, 51);
		frame.getContentPane().add(btnSenior);
		
		JButton btnNonmember = new JButton("Non-member");
		btnNonmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisplayNonMemberDetails.DisplayNonMemberMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNonmember.setBounds(357, 245, 162, 51);
		frame.getContentPane().add(btnNonmember);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.loginScreen(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnLogout.setBounds(221, 340, 137, 51);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenu.setBounds(264, 13, 54, 15);
		frame.getContentPane().add(lblMenu);
	}
}
