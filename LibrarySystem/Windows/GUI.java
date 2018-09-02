package LibrarySystem.Windows;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;
import LibrarySystem.Panels.Tables.*;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{
	JButton btnLogin, btnExit;
  JPanel mainPanel;
	ChangePassword ChangePassword;
	UpdateBookInfo updateBookInfo;

	LeftPanel leftPanel;
	LeftPanelLogin leftPanelLogin;
	LeftPanelUserInfo leftPanelUserInfo;
	LeftPanelUserInfoUpdate leftPanelUserInfoUpdate;

	RightPanelReg rightPanelReg;
	RightPanelUser rightPanelUser;
  RightPanelEmployee rightPanelEmployee;

	TopPanelLogin topPanelLogin;
	TopPanel topPanel;

	TablePanel tablePanel;

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

	public void showHome(){
		mainPanel.removeAll();
		mainPanel.revalidate();
		mainPanel.repaint();

		topPanel = new TopPanel();
		mainPanel.add(topPanel);

		if(Global.ROLEID == 4){
			rightPanelUser = new RightPanelUser();
			mainPanel.add(rightPanelUser);

			//leftPanelUserInfo = new LeftPanelUserInfo();
			//mainPanel.add(leftPanelUserInfo);
			String [] index;
			index= new String[]{"Rank", "Country", "GDP(millions of US$)"};
			Object[][] rawData = new Object[] [] {
										{"1", "USA", "$19.42 Trillion"},
										{"2", "China","$11.8 Trillion"}
										};
			tablePanel = new TablePanel(index, rawData);
			mainPanel.add(tablePanel);
		}

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}



	public void actionPerformed(ActionEvent ae){
		String str = ae.getActionCommand();
		if(str.equals(btnLogin.getText())){

		}
		else if(str.equals(btnExit.getText()))
		{
			System.exit(0);
		}
		else{}
		}
	}
