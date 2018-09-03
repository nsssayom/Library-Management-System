package LibrarySystem.Panels.LeftPanels;

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

public class LeftPanelUserInfoUpdate extends LeftPanel implements ActionListener{

 JLabel updateMyInfoLabel, updateNameLabel, updateIdLabel, updateEmailLabel, updatePhoneLabel, updateAddressLabel, updateUserNameLabel;
 JButton btnDeleteAccount,btnChangePass, btnLogOut;
 JTextField  updateNameTF, updateIdTF, updateEmailTF, updatePhoneTF, updateAddressTF,updateUserNameTF;

  public LeftPanelUserInfoUpdate(){

      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);

      updateMyInfoLabel = new JLabel("Edit Information");
      updateMyInfoLabel.setBounds(140, 160,200, 30);
      updateMyInfoLabel.setForeground(Color.RED);
      updateMyInfoLabel.setFont(f2);
      add(updateMyInfoLabel);

      updateNameLabel = new JLabel("Name:");
      updateNameLabel.setBounds(150, 230, 50, 30);
      updateNameLabel.setFont(f4);
      add(updateNameLabel);

      updateIdLabel = new JLabel("ID:");
      updateIdLabel.setBounds(150, 280, 50, 30);
      updateIdLabel.setFont(f4);
      add(updateIdLabel);

      updateEmailLabel = new JLabel("E-mail:");
      updateEmailLabel.setBounds(150, 330, 80, 30);
      updateEmailLabel.setFont(f4);
      add(updateEmailLabel);

      updatePhoneLabel = new JLabel("Phone no:");
      updatePhoneLabel.setBounds(150, 380, 100, 30);
      updatePhoneLabel.setFont(f4);
      add(updatePhoneLabel);

      updateAddressLabel = new JLabel("Address:");
      updateAddressLabel.setBounds(150, 430, 100, 30);
      updateAddressLabel.setFont(f4);
      add(updateAddressLabel);

      updateUserNameLabel = new JLabel("User name:");
      updateUserNameLabel.setBounds(150, 480, 100, 30);
      updateUserNameLabel.setFont(f4);
      add(updateUserNameLabel);

      updateNameTF = new JTextField();
      updateNameTF.setBounds(260, 230, 190, 30);
      add(updateNameTF);

      updateIdTF = new JTextField();
      updateIdTF.setBounds(260, 280, 190, 30);
      add(updateIdTF);

      updateEmailTF = new JTextField();
      updateEmailTF.setBounds(260, 330, 190, 30);
      add(updateEmailTF);

      updatePhoneTF = new JTextField();
      updatePhoneTF.setBounds(260, 380, 190, 30);
      add(updatePhoneTF);

      updateAddressTF = new JTextField();
      updateAddressTF.setBounds(260, 430, 190, 30);
      add(updateAddressTF);

      updateUserNameTF = new JTextField();
      updateUserNameTF.setBounds(260, 480, 190, 30);
      add(updateUserNameTF);

      btnChangePass = new JButton("Change Password ");
      btnChangePass.setBounds(140, 540, 150, 33);
      btnChangePass.addActionListener(this);
      add(btnChangePass);

      btnDeleteAccount = new JButton("Delete Account ");
      btnDeleteAccount.setBounds(140, 605, 150, 33);
      btnDeleteAccount.setForeground(Color.RED);
      btnDeleteAccount.addActionListener(this);
      add(btnDeleteAccount);

      btnLogOut = new JButton("Log Out ");
      btnLogOut.setBounds(300, 605, 150, 33);
      btnLogOut.addActionListener(this);
      add(btnLogOut);


  }
    public void actionPerformed(ActionEvent ae){}

}
