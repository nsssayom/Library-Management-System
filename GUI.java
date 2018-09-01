import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{
	public static Database database = new Database("54.37.227.144", "my_library", "Library009", "library_database");

	JButton btnLogin, btnExit;
  JPanel mainPanel;
	TopPanelLogin topPanelLogin;
	LeftPanel leftPanel;
	LeftPanelLogin leftPanelLogin;
	LeftPanelUserInfo leftPanelUserInfo;
	LeftPanelUserInfoUpdate leftPanelUserInfoUpdate;
	RightPanelReg rightPanelReg;
	RightPanelUser rightPanelUser;
  RightPanelEmployee rightPanelEmployee;
	ChangePassword ChangePassword;
	UpdateBookInfo updateBookInfo;

	public GUI(){
		//initiating the JFrame instance
		super("Login");
  	this.setSize(1280, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		//initiating mainPanel to hold other panels
		mainPanel = new JPanel();
		mainPanel.setLayout(null);

		//initiating topPanelLogin instance and adding to mainPanel
		topPanelLogin= new TopPanelLogin();
		mainPanel.add(topPanelLogin);

		//initiating rightPanelReg instance and adding to mainPanel
		rightPanelReg= new RightPanelReg();
		mainPanel.add(rightPanelReg);

		//initiating leftPanelLogin instance and adding to mainPanel
		leftPanelLogin = new LeftPanelLogin();
		mainPanel.add(leftPanelLogin);

		//adding mainpanel to the JFrame instance
		this.add(mainPanel);
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
