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
JButton btnAddNewBook, btnIssueBook, btnReturnBook, btnUpdateBookInfo;

	public RightPanelEmployee(){

    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

    Font f4= new Font("Cambria",Font.BOLD, 16);

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

    btnViewEmployeeInfo = new JButton("View Employee Information");
    btnViewEmployeeInfo.setBounds(50,200 , 250, 30);
    btnViewEmployeeInfo.setFont(f4);
    add(btnViewEmployeeInfo);

    btnAddNewEmployee = new JButton("Add New Employee");
    btnAddNewEmployee.setBounds(50, 250, 250, 30);
    btnAddNewEmployee.setFont(f4);
    add(btnAddNewEmployee);

		btnAddNewBook = new JButton("Add New Book");
    btnAddNewBook.setBounds(50, 300, 250, 30);
    btnAddNewBook.setFont(f4);
    add(btnAddNewBook);

    btnIssueBook = new JButton("Issue Book");
    btnIssueBook.setBounds(50, 350, 250, 30);
    btnIssueBook.setFont(f4);
    add(btnIssueBook);

    btnReturnBook = new JButton("Return Book");
    btnReturnBook.setBounds(50,400 , 250, 30);
    btnReturnBook.setFont(f4);
    add(btnReturnBook);

    btnUpdateBookInfo = new JButton("Update Book Information");
    btnUpdateBookInfo.setBounds(50, 450, 250, 30);
    btnUpdateBookInfo.setFont(f4);
    add(btnUpdateBookInfo);
  }
}
