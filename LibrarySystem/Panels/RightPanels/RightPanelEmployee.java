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

public class RightPanelEmployee extends JPanel implements ActionListener{

JLabel employeeAccountLabel, btnEmployeeMyInfo, btnEmployeeInfo, btnCustomerInfo, btnUpdateBookInfo ;


	public RightPanelEmployee(){

    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

		Font f2 = new Font("Cambria",Font.BOLD, 20);
    Font f4= new Font("Cambria",Font.BOLD, 17);

		employeeAccountLabel = new JLabel("Employee Account");
		employeeAccountLabel.setBounds(120, 63, 400, 40);
		employeeAccountLabel.setFont(f2);
		add(employeeAccountLabel);

    btnEmployeeMyInfo = new JLabel("My Information");
    btnEmployeeMyInfo.setBounds(100, 170, 200, 30);
    btnEmployeeMyInfo.setFont(f4);
    add(btnEmployeeMyInfo);

    btnEmployeeInfo = new JLabel("Employee Information");
    btnEmployeeInfo.setBounds(100, 220, 200, 30);
    btnEmployeeInfo.setFont(f4);
    add(btnEmployeeInfo);

    btnCustomerInfo = new JLabel("Customer Information");
    btnCustomerInfo.setBounds(100,270 , 200, 30);
    btnCustomerInfo.setFont(f4);
    add(btnCustomerInfo);

    btnUpdateBookInfo = new JLabel("Update Book Information");
    btnUpdateBookInfo.setBounds(100, 320, 200, 40);
    btnUpdateBookInfo.setFont(f4);
    add(btnUpdateBookInfo);
  }

  public void actionPerformed(ActionEvent ae){}

}
