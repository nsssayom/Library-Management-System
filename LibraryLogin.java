import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class LibraryLogin extends JFrame implements ActionListener{

	JButton btnLogin, btnExit;
  JPanel MainPanel;

	//TopPanelLogin topPanelLogin;
//	LeftPanelLogin leftPanelLogin;
	//RightPanelReg rightPanelReg;
	TopPanel topPanel;
	//LeftPanel leftPanel;
	 // LeftPanelUserInfo leftPanelUserInfo;
	 //LeftPanelUserInfoUpdate leftPanelUserInfoUpdate;
	 // RightPanelUser rightPanelUser;
  RightPanelEmployee rightPanelEmployee;
	//ChangePassword ChangePassword;
	UpdateBookInfo updateBookInfo;

  	public LibraryLogin(){
		super("Login Window");
  	this.setSize(1280, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel = new JPanel();
		MainPanel.setLayout(null);

	//	topPanelLogin = new TopPanelLogin();
	//	leftPanelLogin= new LeftPanelLogin();
		//rightPanelReg= new RightPanelReg();
	  topPanel= new TopPanel();
	 //leftPanel= new LeftPanel();
		//leftPanelUserInfo= new LeftPanelUserInfo();
	//	leftPanelUserInfoUpdate= new LeftPanelUserInfoUpdate();
	//	rightPanelUser= new RightPanelUser();
	rightPanelEmployee= new RightPanelEmployee();
//	changePassword= new ChangePassword();
updateBookInfo= new UpdateBookInfo();


	/*	MainPanel.add(topPanelLogin);
		this.add(MainPanel);
		this.setResizable(false);*/

	/*	MainPanel.add(leftPanelLogin);
		this.add(MainPanel);
		this.setResizable(false);*/

		/*MainPanel.add(rightPanelReg);
		this.add(MainPanel);
		this.setResizable(false);*/

		MainPanel.add(topPanel);
		this.add(MainPanel);
	  this.setResizable(false);

	/*	MainPanel.add(leftPanel);
		this.add(MainPanel);
		this.setResizable(false);*/

	/*	MainPanel.add(leftPanelUserInfo);
		this.add(MainPanel);
		this.setResizable(false);*/

		/*	MainPanel.add(leftPanelUserInfoUpdate);
			this.add(MainPanel);
			this.setResizable(false);*/

	/*	MainPanel.add(rightPanelUser);
		this.add(MainPanel);
		this.setResizable(false);*/

		MainPanel.add(rightPanelEmployee);
		this.add(MainPanel);
		this.setResizable(false);

	/*	MainPanel.add(changePassword);
		this.add(MainPanel);
		this.setResizable(false);*/

		MainPanel.add(updateBookInfo);
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
