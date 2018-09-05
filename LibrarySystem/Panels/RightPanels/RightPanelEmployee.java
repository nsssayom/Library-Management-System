package LibrarySystem.Panels.RightPanels;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class RightPanelEmployee extends JPanel{

JButton btnViewMyInfo,btnEditMyInfo,btnViewUserInfo,btnViewEmployeeInfo,btnAddNewEmployee ;
JButton btnAddNewBook, btnIssueBook, btnReturnBook, btnUpdateBookInfo, btnChangePassword, btnUpdateEmployeeInfo;

	public RightPanelEmployee(){

    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

    Font f4= new Font("Cambria",Font.BOLD, 16);
		Font f1= new Font("Cambria",Font.BOLD, 15);

		btnViewMyInfo = new JButton("View My Account");
		btnViewMyInfo.setBounds(50, 50, 250, 30);
		btnViewMyInfo.setFont(f4);
		add(btnViewMyInfo);
		btnViewMyInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.viewSelfInformation();
							    }
							});

    btnEditMyInfo = new JButton("Edit My Information");
    btnEditMyInfo.setBounds(50, 100, 250, 30);
    btnEditMyInfo.setFont(f4);
    add(btnEditMyInfo);
		btnEditMyInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.editSelfInformation();
							    }
							});

    btnViewUserInfo = new JButton("View User Information");
    btnViewUserInfo.setBounds(50, 150, 250, 30);
    btnViewUserInfo.setFont(f4);
    add(btnViewUserInfo);
		btnViewUserInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.viewUserInfo(0);
							    }
							});

    btnViewEmployeeInfo = new JButton("View Employee Information");
    btnViewEmployeeInfo.setBounds(50,200 , 250, 30);
    btnViewEmployeeInfo.setFont(f4);
		if (Global.ROLEID > 2){btnViewEmployeeInfo.setEnabled(false);}
    add(btnViewEmployeeInfo);
		btnViewEmployeeInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.viewUserInfo(1);
							    }
							});

    btnAddNewEmployee = new JButton("Add New Employee");
    btnAddNewEmployee.setBounds(50, 250, 250, 30);
    btnAddNewEmployee.setFont(f4);
		if (Global.ROLEID > 2){btnAddNewEmployee.setEnabled(false);}
    add(btnAddNewEmployee);
		btnAddNewEmployee.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.addNewEmployee();
							    }
							});


		btnAddNewBook = new JButton("Add New Book");
    btnAddNewBook.setBounds(50, 300, 250, 30);
    btnAddNewBook.setFont(f4);
    add(btnAddNewBook);
		btnAddNewBook.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
							        Global.gui.addNewBook();
							    }
							});

    btnIssueBook = new JButton("Issue Book");
    btnIssueBook.setBounds(50, 350, 250, 30);
    btnIssueBook.setFont(f4);
    add(btnIssueBook);
		btnIssueBook.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
												Global.gui.issueBook();
							    }
							});

    btnReturnBook = new JButton("Return Book");
    btnReturnBook.setBounds(50,400 , 250, 30);
    btnReturnBook.setFont(f4);
    add(btnReturnBook);
		btnReturnBook.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
												Global.gui.returnBook();
							    }
							});

    btnUpdateBookInfo = new JButton("Update Book Information");
    btnUpdateBookInfo.setBounds(50, 450, 250, 30);
    btnUpdateBookInfo.setFont(f4);
    add(btnUpdateBookInfo);
		btnUpdateBookInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
												Global.gui.updateBook();
							    }
							});

  	btnUpdateEmployeeInfo = new JButton("Update Employee Information");
		btnUpdateEmployeeInfo.setBounds(50, 500, 250, 30);
		btnUpdateEmployeeInfo.setFont(f1);
		add(btnUpdateEmployeeInfo);
		btnUpdateEmployeeInfo.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
												Global.gui.updateEmployee();
							    }
							});

		btnChangePassword = new JButton("Change Password");
	  btnChangePassword.setBounds(50, 550, 250, 30);
		btnChangePassword.setFont(f4);
		add(btnChangePassword);
		btnChangePassword.addActionListener(new ActionListener() {
							    @Override
							    public void actionPerformed(ActionEvent evt) {
												Global.gui.changePassword();
							    }
							});

  }
}
