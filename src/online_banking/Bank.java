package online_banking;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
import java.time.*;

public class Bank extends JFrame{
	
	String dbName ="jdbc:mysql://localhost/onlinebank";
	String dbUser="root";
	String dbPassword ="";
	String email;
	LocalDateTime time = LocalDateTime.now();
	String timeStamp = String.valueOf(time).substring(0, 16);

    public Bank() {
        // Set up the main window
        setTitle("Online Bank");
        setSize(500, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		
		//login page
		Panel login_panel = new Panel();
		login_panel.setForeground(new Color(0, 128, 128));
		contentPane.add(login_panel);
		login_panel.setLayout(null);
		
		Button login_btn = new Button("LOG IN");
		login_btn.setBackground(new Color(0, 128, 128));
		login_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		login_btn.setForeground(new Color(64, 0, 0));
		login_btn.setFocusable(false);
		login_btn.setBounds(166, 174, 70, 22);
		login_panel.add(login_btn);
		
		Button signup_btn = new Button("SIGN UP");
		signup_btn.setBackground(new Color(0, 128, 128));
		signup_btn.setForeground(new Color(64, 0, 0));
		signup_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		signup_btn.setBounds(266, 174, 70, 22);
		signup_btn.setFocusable(false);
		login_panel.add(signup_btn);
		
		Label login_email_label = new Label("EMAIL:");
		login_email_label.setFont(new Font("Dialog", Font.BOLD, 12));
		login_email_label.setBounds(69, 69, 77, 22);
		login_panel.add(login_email_label);
		
		Label login_password_label = new Label("PASSWORD:");
		login_password_label.setFont(new Font("Dialog", Font.BOLD, 12));
		login_password_label.setBounds(69, 112, 77, 22);
		login_panel.add(login_password_label);
		
		TextField login_email_textField = new TextField();
		login_email_textField.setFont(new Font("Dialog", Font.BOLD, 12));
		login_email_textField.setForeground(new Color(64, 0, 0));
		login_email_textField.setBounds(168, 69, 174, 22);
		login_panel.add(login_email_textField);
		
		Label login_label = new Label("WELCOME TO ONLINE BANK");
		login_label.setForeground(new Color(64, 0, 0));
		login_label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		login_label.setBounds(35, 0, 352, 40);
		login_panel.add(login_label);
		
		Label login_error_label = new Label("Error: INCORRECT CREDENTIALS!!!");
		login_error_label.setForeground(new Color(255, 0, 0));
		login_error_label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		login_error_label.setBounds(150, 140, 217, 22);
		login_error_label.setVisible(false);
		login_panel.add(login_error_label);
		
		JPasswordField login_passwordField = new JPasswordField();
		login_passwordField.setForeground(new Color(0, 0, 0));
		login_passwordField.setFont(new Font("Dialog", Font.PLAIN, 11));
		login_passwordField.setEchoChar('*');
		login_passwordField.setBounds(168, 114, 174, 20);
		login_panel.add(login_passwordField);
		
		Label or_label = new Label("or");
		or_label.setFont(new Font("Dialog", Font.BOLD, 13));
		or_label.setBounds(242, 174, 31, 22);
		login_panel.add(or_label);
		
		
		
		//sign up panel
		Panel signup_panel = new Panel();
		signup_panel.setForeground(new Color(0, 128, 128));
		signup_panel.setLayout(null);
		
		Button signup_button = new Button("SIGN UP");
		signup_button.setBackground(new Color(0, 128, 128));
		signup_button.setFocusable(false);
		signup_button.setForeground(new Color(64, 0, 0));
		signup_button.setFont(new Font("Dialog", Font.BOLD, 12));
		signup_button.setBounds(199, 203, 70, 22);
		signup_panel.add(signup_button);
		
		Button cancel_btn = new Button("CANCEL");
		cancel_btn.setBackground(new Color(0, 128, 128));
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		cancel_btn.setForeground(new Color(64, 0, 0));
		cancel_btn.setBounds(289, 203, 70, 22);
		cancel_btn.setFocusable(false);
		signup_panel.add(cancel_btn);
		
		Label first_name_label = new Label("ENTER FIRST NAME:");
		first_name_label.setFont(new Font("Calisto MT", Font.BOLD, 11));
		first_name_label.setBounds(45, 94, 105, 22);
		signup_panel.add(first_name_label);
		
		Label last_name_label = new Label("ENTER LAST NAME:");
		last_name_label.setFont(new Font("Calisto MT", Font.BOLD, 11));
		last_name_label.setBounds(45, 122, 105, 22);
		signup_panel.add(last_name_label);
		
		Label email_label = new Label("ENTER EMAIL:");
		email_label.setFont(new Font("Calisto MT", Font.BOLD, 11));
		email_label.setBounds(45, 66, 82, 22);
		signup_panel.add(email_label);
		
		Label password_label = new Label("CREATE PASSWORD:");
		password_label.setFont(new Font("Calisto MT", Font.BOLD, 11));
		password_label.setBounds(45, 150, 111, 22);
		signup_panel.add(password_label);
		
		Label confirm_password_label = new Label("CONFIRM PASSWORD:");
		confirm_password_label.setFont(new Font("Calisto MT", Font.BOLD, 11));
		confirm_password_label.setBounds(45, 175, 120, 22);
		signup_panel.add(confirm_password_label);
		
		Label create_account_label = new Label("CREATE AN ACCOUNT");
		create_account_label.setForeground(new Color(64, 0, 0));
		create_account_label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		create_account_label.setBounds(77, 10, 282, 50);
		signup_panel.add(create_account_label);
		
		TextField signup_email_textField = new TextField();
		signup_email_textField.setBounds(189, 66, 183, 22);
		signup_panel.add(signup_email_textField);
		
		TextField signup_firstname_textField = new TextField();
		signup_firstname_textField.setBounds(189, 94, 183, 22);
		signup_panel.add(signup_firstname_textField);
		
		TextField signup_lastname_textField = new TextField();
		signup_lastname_textField.setBounds(189, 122, 183, 22);
		signup_panel.add(signup_lastname_textField);
		
		TextField signup_password_textField = new TextField();
		signup_password_textField.setBounds(189, 150, 183, 22);
		signup_panel.add(signup_password_textField);
		
		TextField confirmPassword_textField = new TextField();
		confirmPassword_textField.setBounds(189, 175, 183, 22);
		signup_panel.add(confirmPassword_textField);
		
		Label signup_error_label = new Label("ERROR: INVALID INPUT!!!");
		signup_error_label.setForeground(new Color(255, 0, 0));
		signup_error_label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		signup_error_label.setBounds(199, 229, 160, 22);
		signup_error_label.setVisible(false);
		signup_panel.add(signup_error_label);
		
		
		
		//deposit panel
		Panel deposit_panel = new Panel();
		deposit_panel.setLayout(null);
		
		TextField deposit_amount_textField = new TextField();
		deposit_amount_textField.setBounds(167, 62, 168, 37);
		deposit_panel.add(deposit_amount_textField);
		
		Label enter_deposit_label = new Label("Enter Amount:");
		enter_deposit_label.setForeground(new Color(0, 128, 128));
		enter_deposit_label.setFont(new Font("Georgia", Font.BOLD, 12));
		enter_deposit_label.setBounds(52, 62, 109, 37);
		deposit_panel.add(enter_deposit_label);
		
		Button deposit_button = new Button("DEPOSIT");
		deposit_button.setFont(new Font("Dialog", Font.BOLD, 12));
		deposit_button.setBackground(new Color(0, 128, 128));
		deposit_button.setBounds(205, 133, 91, 31);
		deposit_button.setFocusable(false);
		deposit_panel.add(deposit_button);
		
		Label deposit_error_label = new Label("Error: Invalid input");
		deposit_error_label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		deposit_error_label.setForeground(new Color(255, 0, 0));
		deposit_error_label.setBounds(201, 105, 119, 22);
		deposit_error_label.setVisible(false);
		deposit_panel.add(deposit_error_label);
		
		
		//transfer panel
		Panel trasnfer_panel = new Panel();
		trasnfer_panel.setFont(new Font("Dialog", Font.BOLD, 12));
		trasnfer_panel.setForeground(new Color(64, 0, 0));
		trasnfer_panel.setLayout(null);
		
		Label transfer_amount_label = new Label("Enter Amount:");
		transfer_amount_label.setFont(new Font("Dialog", Font.BOLD, 12));
		transfer_amount_label.setBounds(48, 31, 88, 27);
		trasnfer_panel.add(transfer_amount_label);
		
		TextField tranfer_amount_textField = new TextField();
		tranfer_amount_textField.setBounds(195, 31, 169, 27);
		trasnfer_panel.add(tranfer_amount_textField);
		
		TextField enter_beneficiary_textField = new TextField();
		enter_beneficiary_textField.setBounds(195, 104, 169, 27);
		trasnfer_panel.add(enter_beneficiary_textField);
		
		Label beneficiary_label = new Label("Enter new Beneficiary:");
		beneficiary_label.setFont(new Font("Dialog", Font.BOLD, 12));
		beneficiary_label.setBounds(48, 104, 134, 27);
		trasnfer_panel.add(beneficiary_label);
		
		Button transfer_button = new Button("Transfer");
		transfer_button.setBackground(new Color(0, 128, 128));
		transfer_button.setBounds(233, 163, 75, 33);
		transfer_button.setFocusable(false);
		trasnfer_panel.add(transfer_button);
		
		Label transfer_error_label = new Label("Error: Insufficient Balance!!!");
		transfer_error_label.setForeground(new Color(255, 0, 0));
		transfer_error_label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		transfer_error_label.setBounds(195, 137, 169, 22);
		transfer_error_label.setVisible(false);
		trasnfer_panel.add(transfer_error_label);
		
		Label beneficiary_combo_label = new Label("Select Beneficiary:");
		beneficiary_combo_label.setFont(new Font("Dialog", Font.BOLD, 12));
		beneficiary_combo_label.setBounds(48, 71, 113, 27);
		trasnfer_panel.add(beneficiary_combo_label);
		
		JComboBox beneficiary_comboBox = new JComboBox();
		beneficiary_comboBox.setForeground(new Color(64, 0, 0));
		beneficiary_comboBox.setFont(new Font("Dialog", Font.BOLD, 12));
		beneficiary_comboBox.setBounds(195, 64, 169, 34);
		trasnfer_panel.add(beneficiary_comboBox);
		
		
		
		//Bill payment Panel
		Panel bill_payment_panel = new Panel();
		bill_payment_panel.setForeground(new Color(0, 128, 128));
		bill_payment_panel.setFont(new Font("Dialog", Font.BOLD, 14));
		bill_payment_panel.setLayout(null);
		
		JComboBox<String> bill_comboBox = new JComboBox<>();
		bill_comboBox.setForeground(new Color(64, 0, 0));
		bill_comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Electricity", "Phone", "Internet", "Water"}));
		bill_comboBox.setSelectedIndex(-1);
		bill_comboBox.setBounds(215, 55, 89, 20);
		bill_payment_panel.add(bill_comboBox);
		
		JLabel select_billtype_label = new JLabel("Select Bill Type:");
		select_billtype_label.setForeground(new Color(0, 128, 128));
		select_billtype_label.setFont(new Font("Dialog", Font.BOLD, 12));
		select_billtype_label.setBounds(99, 54, 106, 22);
		bill_payment_panel.add(select_billtype_label);
		
		JTextField bill_amount_field = new JTextField();
		bill_amount_field.setForeground(new Color(64, 0, 0));
		bill_amount_field.setBounds(215, 101, 89, 20);
		bill_payment_panel.add(bill_amount_field);
		bill_amount_field.setColumns(10);
		
		JLabel enter_billAmount_label = new JLabel("Enter Amount:");
		enter_billAmount_label.setForeground(new Color(0, 128, 128));
		enter_billAmount_label.setFont(new Font("Dialog", Font.BOLD, 12));
		enter_billAmount_label.setBounds(99, 99, 106, 22);
		bill_payment_panel.add(enter_billAmount_label);
		
		JButton pay_bill_btn = new JButton("Pay Bill");
		pay_bill_btn.setForeground(new Color(64, 0, 0));
		pay_bill_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		pay_bill_btn.setBounds(215, 148, 89, 20);
		bill_payment_panel.add(pay_bill_btn);
		
		JLabel bill_error_label = new JLabel("Error: Invalid Input!!!");
		bill_error_label.setForeground(new Color(255, 0, 0));
		bill_error_label.setFont(new Font("Dialog", Font.BOLD, 12));
		bill_error_label.setBounds(183, 125, 120, 23);
		bill_error_label.setVisible(false);
		bill_payment_panel.add(bill_error_label);
		
		
		
		//Account balance panel
		Panel balance_panel = new Panel();
		balance_panel.setLayout(null);
		
		Label currency_label = new Label("BALANCE : $");
		currency_label.setForeground(new Color(0, 128, 128));
		currency_label.setFont(new Font("Dialog", Font.BOLD, 20));
		currency_label.setBounds(84, 83, 125, 56);
		balance_panel.add(currency_label);
		
		Label acc_balance_label = new Label();
		acc_balance_label.setForeground(new Color(0, 128, 128));
		acc_balance_label.setFont(new Font("Dialog", Font.BOLD, 20));
		acc_balance_label.setBounds(209, 83, 110, 56);
		balance_panel.add(acc_balance_label);
		
		
		
		//transaction history panel
		Panel history_panel = new Panel();
		history_panel.setLayout(null);
		
		TextArea transaction_history_textArea = new TextArea();
		transaction_history_textArea.setFont(new Font("Georgia", Font.ITALIC, 12));
		transaction_history_textArea.setForeground(new Color(0, 128, 128));
		transaction_history_textArea.setEditable(false);
		transaction_history_textArea.setText("NO TRANSACTION HISTORY YET");
		transaction_history_textArea.setBounds(40, 10, 335, 210);
		history_panel.add(transaction_history_textArea);
		
		
		
		//main menu panel
		Panel menu_panel = new Panel();
		menu_panel.setLayout(null);
		
		Button deposit_btn = new Button("Deposit funds");
		deposit_btn.setFont(new Font("Georgia", Font.BOLD, 12));
		deposit_btn.setBackground(new Color(0, 128, 128));
		deposit_btn.setBounds(0, 5, 96, 47);
		deposit_btn.setFocusable(false);
		menu_panel.add(deposit_btn);
		
		Button transfer_btn = new Button("Transfer Funds");
		transfer_btn.setFont(new Font("Georgia", Font.BOLD, 12));
		transfer_btn.setBackground(new Color(0, 128, 128));
		transfer_btn.setBounds(0, 52, 96, 47);
		transfer_btn.setFocusable(false);
		menu_panel.add(transfer_btn);
		
		Button bill_btn = new Button("Bill Payment");
		bill_btn.setFont(new Font("Georgia", Font.BOLD, 12));
		bill_btn.setBackground(new Color(0, 128, 128));
		bill_btn.setBounds(0, 99, 96, 47);
		bill_btn.setFocusable(false);
		menu_panel.add(bill_btn);
		
		Button balance_btn = new Button("Check Balance");
		balance_btn.setFont(new Font("Georgia", Font.BOLD, 12));
		balance_btn.setBackground(new Color(0, 128, 128));
		balance_btn.setBounds(0, 146, 96, 47);
		balance_btn.setFocusable(false);
		menu_panel.add(balance_btn);
		
		JButton history_btn = new JButton("<html>Transaction<br/> &nbsp &nbsp History</html>");
		history_btn.setFont(new Font("", Font.BOLD, 12));
		history_btn.setBackground(new Color(0, 128, 128));
		history_btn.setBounds(0, 195, 96, 47);
		history_btn.setFocusable(false);
		menu_panel.add(history_btn);
		
		Button logout_btn = new Button("Logout");
		logout_btn.setFont(new Font("Georgia", Font.BOLD, 12));
		logout_btn.setBackground(new Color(215, 0, 0));
		logout_btn.setBounds(0, 241, 96, 35);
		logout_btn.setFocusable(false);
		menu_panel.add(logout_btn);
		
		
		//action panel to display action performed in the menu panel
		Panel action_panel = new Panel();
		action_panel.setBounds(60, 10, 370, 231);
		action_panel.setLayout(new CardLayout(0, 0));
		menu_panel.add(action_panel);
		
		
		//Action Listeners

		login_btn.addActionListener(e->{
			login_error_label.setVisible(false);
			email = login_email_textField.getText();
			String password = String.valueOf(login_passwordField.getPassword());
			if(email.length()<1||password.length()<1) {
				login_error_label.setVisible(true);
				}else {
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
				       Statement stmt=connection.createStatement(); 
				       ResultSet rs=stmt.executeQuery("SELECT `password` from `customer` WHERE `customer_email`= (  '"+email+"')");
				       String correctPassword=null;
				       while(rs.next()) {
						 correctPassword = String.valueOf(rs.getString(1));
				       }
						rs.close();
						stmt.close();
						connection.close();
						if(password.equals(correctPassword)) {
							contentPane.removeAll();
							contentPane.setVisible(false);
							contentPane.add(menu_panel);
							contentPane.setVisible(true);
							login_email_textField.setText("");
							login_passwordField.setText("");
						}else {
							login_error_label.setVisible(true);
						}
						}
					catch(Exception err){ 
						System.out.println("ERROR!!!");
						System.out.println(err);
					}
				}
		});
		
		
		signup_btn.addActionListener(e->{
			contentPane.removeAll();
			contentPane.setVisible(false);
			contentPane.add(signup_panel);
			contentPane.setVisible(true);
		});
		
		
		signup_button.addActionListener(e->{
			email = signup_email_textField.getText();
			String firstName = signup_firstname_textField.getText();
			String lastName = signup_lastname_textField.getText();
			String password = signup_password_textField.getText();
			String confirmPassword = confirmPassword_textField.getText();
			if(email.length()<1||firstName.length()<1||lastName.length()<1||password.length()<1||confirmPassword.length()<1) {
				signup_error_label.setVisible(true);
			}else {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
			       Statement stmt=connection.createStatement();
			       int acctNum = Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
			       stmt.executeUpdate("INSERT INTO `customer` ( customer_email, firstname, lastname, password, account_no ) "
				        +"VALUES ( '"+email+"','"+firstName+"','"+lastName+"','"+password+"','"+acctNum+"')");
					stmt.close();
					connection.close();
					contentPane.removeAll();
					contentPane.setVisible(false);
					contentPane.add(menu_panel);
					contentPane.setVisible(true);
					signup_email_textField.setText("");
					signup_firstname_textField.setText("");
					signup_lastname_textField.setText("");
					signup_password_textField.setText("");
					confirmPassword_textField.setText("");
					}
				catch(Exception err){ 
					System.out.println("ERROR!!!");
					System.out.println(err);
				}
			}
		});
		
		
		cancel_btn.addActionListener(e->{
			contentPane.removeAll();
			contentPane.setVisible(false);
			contentPane.add(login_panel);
			contentPane.setVisible(true);
			signup_error_label.setVisible(false);
			});
		
		
		deposit_btn.addActionListener(e->{
			contentPane.setVisible(false);
			menu_panel.setVisible(false);
			action_panel.setVisible(false);
			action_panel.removeAll();
			action_panel.add(deposit_panel);
			action_panel.setVisible(true);
			menu_panel.setVisible(true);
			contentPane.setVisible(true);
		});
		
		
		transfer_btn.addActionListener(e->{
			contentPane.setVisible(false);
			menu_panel.setVisible(false);
			action_panel.setVisible(false);
			action_panel.removeAll();
			action_panel.add(trasnfer_panel);
			action_panel.setVisible(true);
			menu_panel.setVisible(true);
			contentPane.setVisible(true);
		});
		
		
		bill_btn.addActionListener(e->{
			contentPane.setVisible(false);
			menu_panel.setVisible(false);
			action_panel.setVisible(false);
			action_panel.removeAll();
			action_panel.add(bill_payment_panel);
			action_panel.setVisible(true);
			menu_panel.setVisible(true);
			contentPane.setVisible(true);
			});
		
		
		balance_btn.addActionListener(e->{
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
		       Statement stmt=connection.createStatement(); 
		       ResultSet rs=stmt.executeQuery("SELECT `balance` from `customer` WHERE `customer_email`= (  '"+email+"')");
		       int balance=0;
		       while(rs.next()) {
				 balance = Integer.valueOf(rs.getString(1));
		       }
				rs.close();
				stmt.close();
				connection.close();
				acc_balance_label.setText(String.valueOf(balance));
				}
			catch(Exception err){ 
				System.out.println("ERROR!!!");
				System.out.println(err);
			}
			contentPane.setVisible(false);
			menu_panel.setVisible(false);
			action_panel.setVisible(false);
			action_panel.removeAll();
			action_panel.add(balance_panel);
			action_panel.setVisible(true);
			menu_panel.setVisible(true);
			contentPane.setVisible(true);
			});
		
		
		history_btn.addActionListener(e->{
			try{  
				contentPane.setVisible(false);
				menu_panel.setVisible(false);
				action_panel.setVisible(false);
				action_panel.removeAll();
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
		       Statement stmt=connection.createStatement(); 
		       ResultSet rs=stmt.executeQuery("SELECT `transaction_details` from `history` WHERE `customer_email`= (  '"+email+"')");
		       String history="";
		       while(rs.next()) {
					 history += rs.getString(1) + "\n";
			       }
		       transaction_history_textArea.setText(history);
				rs.close();
				stmt.close();
				connection.close();
				action_panel.add(history_panel);
				action_panel.setVisible(true);
				menu_panel.setVisible(true);
				contentPane.setVisible(true);
				}
			catch(Exception err){ 
				System.out.println("ERROR!!!");
				System.out.println(err);
			}
						
			});
		
		
		logout_btn.addActionListener(e->{
			contentPane.removeAll();
			contentPane.setVisible(false);
			contentPane.add(login_panel);
			contentPane.setVisible(true);
			});
		
		
		deposit_button.addActionListener(e->{
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
		       Statement stmt=connection.createStatement();
		       ResultSet rs=stmt.executeQuery("SELECT `balance` from `customer` WHERE `customer_email`= (  '"+email+"')");
		       int balance=0;
		       while(rs.next()) {
				 balance = Integer.valueOf(rs.getString(1));
		       }
				rs.close();
				balance += Integer.valueOf(deposit_amount_textField.getText());
		       stmt.executeUpdate("UPDATE `customer` SET  `balance` = ( '"+balance+"') "
			        +"WHERE `customer_email` = ( '"+email+"')");
				String details = deposit_btn.getLabel()+ " " +deposit_amount_textField.getText()+" @"+timeStamp+" balance:"+balance;
		       stmt.executeUpdate("INSERT INTO `history` ( transaction_details, customer_email ) "
				        +"VALUES ( '"+details+"','"+email+"')");
				stmt.close();
				connection.close();
				deposit_amount_textField.setText("");
				acc_balance_label.setText(String.valueOf(balance));
				contentPane.setVisible(false);
				menu_panel.setVisible(false);
				action_panel.setVisible(false);
				action_panel.removeAll();
				action_panel.add(balance_panel);
				action_panel.setVisible(true);
				menu_panel.setVisible(true);
				contentPane.setVisible(true);
				}
			catch(Exception err){ 
				System.out.println("ERROR!!!");
				System.out.println(err);
			}
		});
		
		
		transfer_button.addActionListener(e->{
			if(tranfer_amount_textField.getText().length()<1) {
				transfer_error_label.setText("Invalid input");
				transfer_error_label.setVisible(true);
			}else {
			try{  
				transfer_error_label.setVisible(false);
				Class.forName("com.mysql.jdbc.Driver");  
				Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
		       Statement stmt=connection.createStatement(); 
		       ResultSet rs=stmt.executeQuery("SELECT `balance` from `customer` WHERE `customer_email`= (  '"+email+"')");
		       int balance=0;
		       while(rs.next()) {
				 balance = Integer.valueOf(rs.getString(1));
		       }
				rs.close();
				if(balance<Integer.valueOf(tranfer_amount_textField.getText())){
					transfer_error_label.setText("Insufficient Balance");
					transfer_error_label.setVisible(true);
				}else {
					balance -= Integer.valueOf(tranfer_amount_textField.getText());
				       stmt.executeUpdate("UPDATE `customer` SET  `balance` = ( '"+balance+"') "
					        +"WHERE `customer_email` = ( '"+email+"')");
				       String details = transfer_btn.getLabel()+ " " +tranfer_amount_textField.getText()+" @"+timeStamp+" balance:"+balance;
				       stmt.executeUpdate("INSERT INTO `history` ( transaction_details, customer_email ) "
						        +"VALUES ( '"+details+"','"+email+"')");
				    acc_balance_label.setText(String.valueOf(balance));
					tranfer_amount_textField.setText("");
					enter_beneficiary_textField.setText("");
					contentPane.setVisible(false);
				menu_panel.setVisible(false);
				action_panel.setVisible(false);
				action_panel.removeAll();
				action_panel.add(balance_panel);
				action_panel.setVisible(true);
				menu_panel.setVisible(true);
				contentPane.setVisible(true);
				transfer_error_label.setVisible(false);
				}
				stmt.close();
				connection.close();
				
				}
			catch(Exception err){ 
				System.out.println("ERROR!!!");
				System.out.println(err);
			}
			}
		});
		
		
		pay_bill_btn.addActionListener(e->{
			if(bill_comboBox.getSelectedIndex()<0||bill_amount_field.getText().length()<1) {
				bill_error_label.setVisible(true);
			}else {
				try{  
					bill_error_label.setVisible(false);
					Class.forName("com.mysql.jdbc.Driver");  
					Connection connection=DriverManager.getConnection(dbName,dbUser,dbPassword); 
			       Statement stmt=connection.createStatement(); 
			       ResultSet rs=stmt.executeQuery("SELECT `balance` from `customer` WHERE `customer_email`= (  '"+email+"')");
			       int balance=0;
			       while(rs.next()) {
					 balance = Integer.valueOf(rs.getString(1));
			       }
					rs.close();
					if(balance<Integer.valueOf(bill_amount_field.getText())){
						bill_error_label.setText("Insufficient Balance!");
						bill_error_label.setVisible(true);
					}else {
						balance -= Integer.valueOf(bill_amount_field.getText());
					       stmt.executeUpdate("UPDATE `customer` SET  `balance` = ( '"+balance+"') "
						        +"WHERE `customer_email` = ( '"+email+"')");
					       String details = bill_btn.getLabel()+bill_comboBox.getSelectedItem()+ " " +bill_amount_field.getText()+" @"+timeStamp+" balance:"+balance;
					       stmt.executeUpdate("INSERT INTO `history` ( transaction_details, customer_email ) "
							        +"VALUES ( '"+details+"','"+email+"')");
					acc_balance_label.setText(String.valueOf(balance));
					bill_amount_field.setText("");
					bill_comboBox.setSelectedIndex(-1);
					contentPane.setVisible(false);
					menu_panel.setVisible(false);
					action_panel.setVisible(false);
					action_panel.removeAll();
					action_panel.add(balance_panel);
					action_panel.setVisible(true);
					menu_panel.setVisible(true);
					contentPane.setVisible(true);
					bill_error_label.setVisible(false);  
					}
					stmt.close();
					connection.close();
					}
				catch(Exception err){ 
					System.out.println("ERROR!!!");
					System.out.println(err);
				}
			}
		});
		
	}

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setVisible(true);
    }
}
