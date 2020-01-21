/*
 * This class is used to send an email of the created CSV
 * @author Nicholas Stocker 
 * @version 1.4
 * @date 11/26/2019
 */

import java.awt.EventQueue;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.*;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.event.ActionEvent;

//import javax.swing.
import javax.swing.*;
import java.awt.event.ActionListener;

public class EmailWindow {

	private JFrame frame;
	private JTextField textFieldEmailTo;
	private JTextField textFieldEmailFrom;
	private JTextField textFieldFromUser;
	//private final Action action = new SwingAction ();
	private JButton btnEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailWindow window = new EmailWindow();
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
	public EmailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 897, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmailTo = new JLabel("Email To:");
		lblEmailTo.setBounds(86, 87, 56, 16);
		frame.getContentPane().add(lblEmailTo);
		
		JLabel lblEmailFrom = new JLabel("Email From:");
		lblEmailFrom.setBounds(86, 116, 70, 16);
		frame.getContentPane().add(lblEmailFrom);
		
		JLabel lblFromUsername = new JLabel("From Email:");
		lblFromUsername.setBounds(86, 205, 103, 16);
		frame.getContentPane().add(lblFromUsername);
		
		JLabel lblFromPassword = new JLabel("From Password:");
		lblFromPassword.setBounds(86, 234, 103, 16);
		frame.getContentPane().add(lblFromPassword);
		
		textFieldEmailTo = new JTextField();
		textFieldEmailTo.setBounds(193, 84, 220, 22);
		frame.getContentPane().add(textFieldEmailTo);
		textFieldEmailTo.setColumns(10);
		
		textFieldEmailFrom = new JTextField();
		textFieldEmailFrom.setBounds(193, 113, 220, 22);
		frame.getContentPane().add(textFieldEmailFrom);
		textFieldEmailFrom.setColumns(10);
		
		textFieldFromUser = new JTextField();
		textFieldFromUser.setBounds(201, 202, 220, 22);
		frame.getContentPane().add(textFieldFromUser);
		textFieldFromUser.setColumns(10);
		
		btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String to = textFieldEmailTo.getText(); //whoever the email is being sent to, only field being filled in, ECMtrackbuildingtool@gmail.com 
			        String from = textFieldEmailFrom.getText(); // our general email, ECMtrackbuildingtool@gmail.com
			        final String username = textFieldFromUser.getText();//our general email, ECMtrackbuildingtool@gmail.com
			        final String password = passwordField.getText();//our general email's password, mansaray19 
			    /*   
			        String to = textFieldEmailTo.getText(); //whoever the email is being sent to, only field being filled in 
			        String from = "Our email"; // our general email
			        final String username = "Our email";//our general email
			        final String password = "Our emails password";//our general email's password
			        
			    */
			        // Assuming you are sending email through relay.jangosmtp.net, GET RID OF 
			        Properties props = new Properties();
			        props.put("mail.smtp.host", "smtp.gmail.com"); //may have to change based off of ASRC address smtp
			        props.put("mail.smtp.socketFactory.port", "465");
			        props.put("mail.smtp.socketFactory.class",
			                "javax.net.ssl.SSLSocketFactory");
			        props.put("mail.smtp.auth", "true");
			        props.put("mail.smtp.port", "465");
			        
			        // Get the Session object.
			        Session session = Session.getInstance(props,
			                new javax.mail.Authenticator() {
			                    protected PasswordAuthentication getPasswordAuthentication() {
			                        return new PasswordAuthentication(username, password);
			                    }
			                });
			        
			        try {
			            // Create a default MimeMessage object.
			            Message message = new MimeMessage(session);
			            // Set From: header field of the header.
			            message.setFrom(new InternetAddress(from));
			            // Set To: header field of the header.
			            message.setRecipients(Message.RecipientType.TO,
			                    InternetAddress.parse(to));
			            
			            // Set Subject: header field
			            message.setSubject("Attachment");
			            // Create the message part
			            BodyPart messageBodyPart = new MimeBodyPart();
			            // Now set the actual message
			            messageBodyPart.setText("Please find the attachment below");
			            // Create a multipar message
			            Multipart multipart = new MimeMultipart();
			            // Set text message part
			            multipart.addBodyPart(messageBodyPart);
			            // Part two is attachment
			            messageBodyPart = new MimeBodyPart();
			            
			            //filepath to the csv file that will be sent
			            String filename = "C:/Users/thesi/OneDrive/Documents/College/Application Stuff/Nicholas_Stocker_Resume.PDF";
			            
			            //DataSource source = new FileDataSource(filePathName); //Make into the same class CSV and Email
			            DataSource source = new FileDataSource(filename);
			            messageBodyPart.setDataHandler(new DataHandler(source));
			            messageBodyPart.setFileName(filename);
			            multipart.addBodyPart(messageBodyPart);
			            // Send the complete message parts
			            message.setContent(multipart);
			            // Send message
			            Transport.send(message);
			            //can take out println instead make a window that prints our success when button pressed 
			    		JOptionPane.showMessageDialog(null,  "Email successfully sent", "Email", JOptionPane.PLAIN_MESSAGE);
			    		
			    		//closes the window 
			    		System.exit(0);
			    		
			        } catch (MessagingException mE) {
			    		JOptionPane.showMessageDialog(null,  "Email not sent try again", "Email", JOptionPane.PLAIN_MESSAGE);
			        }
				
				
				
			}
		});
		btnEmail.setBounds(134, 364, 97, 25);
		frame.getContentPane().add(btnEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 231, 220, 22);
		frame.getContentPane().add(passwordField);
	}

}
