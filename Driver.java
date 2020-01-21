import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;

public class Driver {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver window = new Driver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};
		
		//try{ 
			//Class.forName("com.mysql.jdbc.Driver");  
			//Connection con=DriverManager.getConnection(  
			//"jdbc:mysql://database-1.cofl4q5j4z47.us-east-1.rds.amazonaws.com","admin","Rn5YjnsWkeMm8Ymf5X6Q");  
			// db name: amazon1 root: admin password: Rn5YjnsWkeMm8Ymf5X6Q  
			//Statement stmt=con.createStatement();  
			//ResultSet rs=stmt.executeQuery("select * from components.Program");  
			//while(rs.next())  
			//System.out.println("Programs: " + rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			//con.close();  
			//}catch(Exception e){ System.out.println(e);}  
		//}  

	/**
	 * Create the application.
	 */
	public Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.setBounds(100, 100, 927, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(196, 160, 166, 63);
		lblUsername.setBackground(Color.WHITE);
		frame.getContentPane().add(lblUsername);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(196, 215, 64, 42);
		lblPassword.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().add(lblPassword);
		
		JRadioButton rdbtnTd = new JRadioButton("TD");
		rdbtnTd.setBounds(287, 288, 64, 25);
		rdbtnTd.setContentAreaFilled(false);
		rdbtnTd.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().add(rdbtnTd);
		
		JRadioButton rdbtnEcm = new JRadioButton("ECM");
		rdbtnEcm.setBounds(287, 307, 64, 43);
		rdbtnEcm.setContentAreaFilled(false);
		frame.getContentPane().add(rdbtnEcm);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(385, 462, 108, 32);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(rdbtnEcm.isSelected() && rdbtnTd.isSelected())
			{
				{
					System.out.println("Only one button should be selected");
				}
			}
			else 
			{
				if(rdbtnEcm.isSelected())
				{
					frame.setVisible(false);
					CreateLoad.main(null, true);
				}
				if(rdbtnTd.isSelected())
				{
					frame.setVisible(false);
					CreateLoad.main(null, false);
				}
			}
			}});
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(329, 180, 263, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(329, 224, 263, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEcmBuildTracking = new JLabel("ECM Build Tracking Tool Login Page");
		lblEcmBuildTracking.setBounds(226, 33, 366, 42);
		frame.getContentPane().add(lblEcmBuildTracking);
	}
}
