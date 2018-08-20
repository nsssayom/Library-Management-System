import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class LibraryLogin extends JFrame implements ActionListener{
	JLabel signLabel, nameLabel, emailLabel, passwordLabel,termLabel,termLabel2;
	JTextField  nameTF, emailTF;
	JPasswordField  passPF2;
	JButton btnLogin, btnExit, btnSignUp;

	JPanel MainPanel;
	TopPanelLogin topPanelLogin;
	LeftPanel leftPanel;

	Font f4= new Font("Cambria",Font.BOLD, 17);

	public LibraryLogin(){
		super("Login Window");

		this.setSize(1280, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f1 = new Font("Cambria",Font.BOLD, 26);
		Font f2 = new Font("Cambria",Font.BOLD, 20);
		MainPanel = new JPanel();
		MainPanel.setLayout(null);

		topPanelLogin = new TopPanelLogin();
		leftPanel= new LeftPanel();

		signLabel = new JLabel("New here? Create a free account");
		signLabel.setBounds(925, 200, 400, 30);
		signLabel.setFont(f2);
		signLabel.setOpaque(true);
		MainPanel.add(signLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(930, 280, 50, 30);
		nameLabel.setFont(f4);
		MainPanel.add(nameLabel);

		emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(930, 320, 80, 30);
	  emailLabel.setFont(f4);
		MainPanel.add(emailLabel);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(930, 360, 100, 30);
		passwordLabel.setFont(f4);
		MainPanel.add(passwordLabel);

		nameTF = new JTextField();
		nameTF.setBounds(1025, 280, 170, 30);
		MainPanel.add(nameTF);

		emailTF = new JTextField();
		emailTF.setBounds(1025, 320, 170, 30);
		MainPanel.add(emailTF);

		passPF2 = new JPasswordField();
		passPF2.setBounds(1025,360,170,30);
		MainPanel.add(passPF2);

		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(930, 440, 90, 33);
		btnSignUp.addActionListener(this);
		MainPanel.add(btnSignUp);

	    termLabel = new JLabel("By clicking this I am accepting ");
		termLabel.setBounds(1025, 430, 300, 30);
		MainPanel.add(termLabel);
		termLabel2 = new JLabel("all the terms and conditions");
		termLabel2.setBounds(1025, 450, 300, 30);
		MainPanel.add(termLabel2);

		btnExit = new JButton("Exit");
		btnExit.setBounds(1165, 630, 70, 30);
		btnExit.addActionListener(this);
		MainPanel.add(btnExit);

		MainPanel.add(topPanelLogin);
		this.add(MainPanel);
		this.setResizable(false);

		MainPanel.add(leftPanel);
		this.add(MainPanel);
		this.setResizable(false);
	}

/*public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}*/

public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals(btnLogin.getText()))
		{}
		else if(str.equals(btnExit.getText()))
		{
			System.exit(0);
		}
		else{}
	}
}
