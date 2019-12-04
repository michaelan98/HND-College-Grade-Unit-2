import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Register {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void RegiMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 527, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJunior = new JButton("Junior");
		btnJunior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Junior.JrMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnJunior.setBounds(50, 124, 97, 25);
		frame.getContentPane().add(btnJunior);
		
		JButton btnSenior = new JButton("Senior");
		btnSenior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Senior.SRMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnSenior.setBounds(210, 124, 97, 25);
		frame.getContentPane().add(btnSenior);
		
		JButton btnNonmember = new JButton("Non-Member");
		btnNonmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Non_Member.NonMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNonmember.setBounds(369, 124, 107, 25);
		frame.getContentPane().add(btnNonmember);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.MainMenu(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnMenu.setBounds(210, 207, 97, 25);
		frame.getContentPane().add(btnMenu);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegister.setBounds(223, 35, 82, 36);
		frame.getContentPane().add(lblRegister);
	}

}
