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
import java.util.*;
import java.util.List;

public class GUI extends JFrame implements ActionListener{
	JButton btnLogin, btnExit;
  JPanel mainPanel;
	UpdateBookInfo updateBookInfo;

	LeftPanel leftPanel;
	LeftPanelLogin leftPanelLogin;
	LeftPanelUserInfo leftPanelUserInfo;
	LeftPanelUserInfoUpdate leftPanelUserInfoUpdate;
	LeftPanelChangePassword leftPanelChangePassword;

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
		this.showLoginScreen();
	}

	public void showLoginScreen(){

		try{
			mainPanel.removeAll();
			mainPanel.revalidate();
			mainPanel.repaint();
		}
		catch(Exception ex){}

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
		mainPanel.revalidate();
		mainPanel.repaint();
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
		}
		else{
			rightPanelEmployee = new RightPanelEmployee();
			mainPanel.add(rightPanelEmployee);
		}

		String [] index;
		index= new String[]{"ID", "Book Title", "Author Name",
											"publication Year", "Shelf", "Quantity"};

		try{
			Object[][] rawData = Global.database.readBookList();
			//Object[][] rawData = Global.database.search("bookTitle", "is");
			tablePanel = new TablePanel(index, rawData);
			mainPanel.add(tablePanel);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}


public void clearLeftPanel(){
	Component[] components = mainPanel.getComponents();
	for (int i = 0; i < components.length; i++){
		if((components[i].getClass().getSuperclass().getName()) == "LibrarySystem.Panels.LeftPanels.LeftPanel"){
			mainPanel.remove(components[i]);
		}
	}
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	public void showSearch(String Dataset, String KeyWord){
		this.clearLeftPanel();
		String [] index;
		index= new String[]{"ID", "Book Title", "Author Name",
											"publication Year", "Shelf", "Quantity"};

		try{
			Object[][] rawData = Global.database.search(Dataset, KeyWord);
			tablePanel = new TablePanel(index, rawData);
			mainPanel.add(tablePanel);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}

	public void viewSelfInformation(){
		this.clearLeftPanel();

		leftPanelUserInfo = new LeftPanelUserInfo();
		mainPanel.add(leftPanelUserInfo);

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}


	public void editSelfInformation(){
		this.clearLeftPanel();

		leftPanelUserInfoUpdate = new LeftPanelUserInfoUpdate();
		mainPanel.add(leftPanelUserInfoUpdate);

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}

	public void changePassword(){
		this.clearLeftPanel();

		leftPanelChangePassword = new LeftPanelChangePassword();
		mainPanel.add(leftPanelChangePassword);

		mainPanel.revalidate();
		mainPanel.repaint();
		this.revalidate();
		this.repaint();
	}

	public void viewUserInfo(int mode){
		this.clearLeftPanel();

		String [] index;
		index= new String[]{"Name", "Phone", "Email", "Address"};

		try{
			Object[][] rawData = Global.database.readUserInfo(mode);
			tablePanel = new TablePanel(index, rawData);
			mainPanel.add(tablePanel);
		}
		catch(Exception ex){
			ex.printStackTrace();
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
		else if(str.equals(btnExit.getText())){
			System.exit(0);
		}
		else{}
		}
	}
