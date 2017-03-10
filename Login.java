

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	Connection connection=null;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(230, 93, 114, 19);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(89, 93, 123, 19);
		panel.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 144, 114, 19);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(89, 144, 123, 19);
		panel.add(lblPassword);
		
		PanelOptions options = new PanelOptions();
				
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					String querry="select * from users where username=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(querry);
					pst.setString(1, txtUsername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;
						
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "User name and password is correct");
						
						frame.setContentPane(options);
						frame.invalidate();
						frame.validate();

					} else if (count < 1){
						JOptionPane.showMessageDialog(null, "Duplicate user and password");
					} else {
						JOptionPane.showMessageDialog(null, "Usename and possword is incorrect");
					}
					rs.close();
					pst.close();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		btnLogin.setBounds(230, 224, 117, 25);
		panel.add(btnLogin);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
