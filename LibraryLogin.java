import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class LibraryLogin extends JFrame implements ActionListener
{
<<<<<<< HEAD
	JLabel signLabel, nameLabel, emailLabel, passwordLabel,termLabel,termLabel2,imgLabel1;
	JTextField  nameTF, emailTF;
	JPasswordField  passPF2;
	JButton btnLogin, btnExit, btnSignUp;
	//private JCheckBox checkBox1;
=======
	JLabel  signLabel, nameLabel, emailLabel, passwordLabel,termLabel,termLabel2,imgLabel1;
	JTextField  nameTF, emailTF;
	JPasswordField  passPF2;
	JButton  btnExit, btnSignUp;
//	private JCheckBox checkBox1;
>>>>>>> 527190a9c6930eb8f0ae429c118a6aad25a550ee
	private ImageIcon img;
	JPanel MainPanel;
	TopPanelLogin topPanelLogin;

	public LibraryLogin(){
		super("Login Window");

		this.setSize(1280, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f1 = new Font("Cambria",Font.BOLD, 26);
		Font f2 = new Font("Cambria",Font.BOLD, 20);
		MainPanel = new JPanel();
		MainPanel.setLayout(null);

		topPanelLogin = new TopPanelLogin();

		signLabel = new JLabel("New here? Create a free account");
		signLabel.setBounds(925, 200, 400, 30);
		signLabel.setFont(f2);
		signLabel.setOpaque(true);
		MainPanel.add(signLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(925, 280, 50, 30);
		MainPanel.add(nameLabel);

		emailLabel = new JLabel("E-mail:");
		emailLabel.setBounds(925, 320, 50, 30);
		MainPanel.add(emailLabel);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(925, 360, 100, 30);
		MainPanel.add(passwordLabel);

		nameTF = new JTextField();
		nameTF.setBounds(1005, 280, 170, 30);
		MainPanel.add(nameTF);

		emailTF = new JTextField();
		emailTF.setBounds(1005, 320, 170, 30);
		MainPanel.add(emailTF);

		passPF2 = new JPasswordField();
		passPF2.setBounds(1005,360,170,30);
		MainPanel.add(passPF2);

		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(925, 430, 90, 30);
		btnSignUp.addActionListener(this);
		MainPanel.add(btnSignUp);

	    termLabel = new JLabel("By clicking this I am accepting ");
		termLabel.setBounds(1020, 420, 300, 30);
		MainPanel.add(termLabel);
		termLabel2 = new JLabel("all the terms and conditions");
		termLabel2.setBounds(1020, 440, 300, 30);
		MainPanel.add(termLabel2);

		btnExit = new JButton("Exit");
		btnExit.setBounds(1165, 630, 70, 30);
		btnExit.addActionListener(this);
		MainPanel.add(btnExit);

		img = new ImageIcon("pic1.jpg");
		imgLabel1 = new JLabel(img);
		imgLabel1.setBounds(-310, 100, 1280, 600);
		MainPanel.add(imgLabel1);

		MainPanel.add(topPanelLogin);
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
