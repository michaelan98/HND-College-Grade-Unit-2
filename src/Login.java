import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.awt.Font;


public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private String username;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void loginScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBounds(100, 100, 756, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBounds(301, 216, 177, 22);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(301, 244, 177, 22);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(224, 219, 65, 16);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(224, 247, 65, 16);
		frame.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username = txtUsername.getText();
				password = txtPassword.getText();
				ConnectDB login = new ConnectDB();
				login.authLogin(username, password, frame);
			}
		});
		btnLogin.setBounds(301, 279, 97, 25);
		frame.getContentPane().add(btnLogin);

		JLabel lblSimplyRugby = new JLabel("Simply Rugby");
		lblSimplyRugby.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSimplyRugby.setBounds(283, 76, 155, 54);
		frame.getContentPane().add(lblSimplyRugby);
	}
}
