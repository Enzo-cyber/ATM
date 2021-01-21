import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;





public class ATM implements ActionListener {
	
	static JLabel label1;
	static JLabel label2;
	static JLabel moneyTotal;
	static JLabel money;
	static JLabel passwordRegister; 
	static JLabel usernameRegister;
	static JTextField userName;
	static JTextField depositNum;
	static JTextField withdrawNum;
	static JTextField moneyValue;
	static JTextField userNameText;
	static JPasswordField password;
	static JPasswordField passwordText;
	static JButton login;
	static JButton register; 
	static JButton withdraw;
	static JButton deposit;
	static JButton logOut;
	static JButton bttn;
	static int totalSum;
	static String theUsername;
	static String thePassword;
	static String str1;
	static String str2;
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);
		frame.setSize(500, 300);
		frame.setResizable(false);
		
		label1 = new JLabel("Enter your username:");
		label1.setBounds(25, 35, 170, 20);
		panel.add(label1);
		
		label2 = new JLabel("Password:");
		label2.setBounds(25, 70, 170, 20);
		panel.add(label2);
		
		
		
		userName = new JTextField();
		userName.setBounds(200, 35, 170, 20);
		panel.add(userName);
		
		password = new JPasswordField();
		password.setBounds(200, 70, 170, 20);
		panel.add(password);
		
		
		
		login = new JButton("LOGIN");
		login.setBounds(170, 120, 140, 28);
		login.addActionListener(new ATM());
		panel.add(login);
		
		register = new JButton("REGISTER");
		register.setBounds(170, 155, 140, 28);
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerFrame();
			}
		});
		panel.add(register);
		
		frame.setVisible(true);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		str1 = userName.getText();
		str2 = password.getText();
		if(str1.equals(theUsername) && str2.equals(thePassword)) {
			acc();
		}else {
			System.out.println("Who the fuck are you");
		}
	}
	
	public static void registerFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);
		frame.setSize(500, 300);
		frame.setResizable(false);
		
		usernameRegister = new JLabel("Enter your username:");
		usernameRegister.setBounds(25, 70, 170, 20);
		panel.add(usernameRegister);
		
		passwordRegister = new JLabel("Password:");
		label2.setBounds(25, 105, 170, 20);
		panel.add(label2);
				
		userNameText = new JTextField();
		userNameText.setBounds(190, 70, 200, 20);
		panel.add(userNameText);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(190, 105, 200, 20);
		panel.add(passwordText);
		
		money = new JLabel("Enter your account balance:");
		money.setBounds(25, 35, 200, 20);
		panel.add(money);
		
		moneyValue = new JTextField();
		moneyValue.setBounds(190, 35, 200, 20);
		panel.add(moneyValue);
		
		bttn = new JButton("Register now");
		bttn.setBounds(25, 140, 170, 20);
		bttn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				theUsername = userNameText.getText();
				thePassword = passwordText.getText();
				String s = moneyValue.getText();
				totalSum = Integer.parseInt(s);
				System.out.println(totalSum);
				
				frame.dispose();
			}
		});
		panel.add(bttn);
		
		
		
		frame.setVisible(true);
	}
	
	public static void acc() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);
		frame.setResizable(false);
		frame.setSize(600, 600);
		String str = Integer.toString(totalSum);
		
		moneyTotal = new JLabel(str, SwingConstants.CENTER);
		moneyTotal.setBounds(200, 100, 170, 20);
		panel.add(moneyTotal);
		
		depositNum = new JTextField();
		depositNum.setBounds(220, 335, 150, 20);
		panel.add(depositNum);		
		
		withdrawNum = new JTextField();
		withdrawNum.setBounds(220, 300, 150, 20);
		panel.add(withdrawNum);
		
		withdraw = new JButton("WITHDRAW");
		withdraw.setBounds(100, 300, 100, 20);
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = withdrawNum.getText();
				int i = Integer.parseInt(s);
				totalSum = totalSum - i; 
				System.out.println(totalSum);
				s = Integer.toString(totalSum);
				moneyTotal.setText(s);
				
				withdrawNum.setText("");
			}
		});
		panel.add(withdraw);
		
		deposit = new JButton("DEPOSIT");
		deposit.setBounds(100, 335, 100, 20);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = depositNum.getText();
				int i = Integer.parseInt(s);
				totalSum = totalSum + i; 
				System.out.println(totalSum);
				s = Integer.toString(totalSum);
				moneyTotal.setText(s);
				
				depositNum.setText("");
			}
		});
		panel.add(deposit);
		
		logOut = new JButton("LOG OUT");
		logOut.setBounds(472, 12, 100, 20);
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(logOut);
		
		
	
		frame.setVisible(true);
	}
	
}
















