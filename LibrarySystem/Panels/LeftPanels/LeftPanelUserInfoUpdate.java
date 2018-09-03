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
 JButton btnSaveChanges;
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

      updateEmailLabel = new JLabel("E-mail:");
      updateEmailLabel.setBounds(150, 280, 80, 30);
      updateEmailLabel.setFont(f4);
      add(updateEmailLabel);

      updatePhoneLabel = new JLabel("Phone no:");
      updatePhoneLabel.setBounds(150, 330, 100, 30);
      updatePhoneLabel.setFont(f4);
      add(updatePhoneLabel);

      updateAddressLabel = new JLabel("Address:");
      updateAddressLabel.setBounds(150, 380, 100, 30);
      updateAddressLabel.setFont(f4);
      add(updateAddressLabel);

      updateUserNameLabel = new JLabel("User name:");
      updateUserNameLabel.setBounds(150, 460, 100, 30);
      updateUserNameLabel.setFont(f4);
      add(updateUserNameLabel);

      updateNameTF = new JTextField(Global.NAME);
      updateNameTF.setBounds(260, 230, 190, 30);
      add(updateNameTF);

      updateEmailTF = new JTextField(Global.EMAIL);
      updateEmailTF.setBounds(260, 280, 190, 30);
      add(updateEmailTF);

      updatePhoneTF = new JTextField(Global.PHONE);
      updatePhoneTF.setBounds(260, 330, 190, 30);
      add(updatePhoneTF);

      updateAddressTF = new JTextField(Global.ADDRESS);
      updateAddressTF.setBounds(260, 380, 190, 30);
      add(updateAddressTF);

      updateUserNameTF = new JTextField(Global.USERNAME);
      updateUserNameTF.setBounds(260, 460, 190, 30);
      updateUserNameTF.setEditable(false);
      add(updateUserNameTF);

      btnSaveChanges = new JButton("Save Changes");
      btnSaveChanges.setBounds(140, 540, 150, 33);
      btnSaveChanges.setForeground(new Color(0, 108, 50));
      btnSaveChanges.addActionListener(this);
      add(btnSaveChanges);

  }
    public void actionPerformed(ActionEvent ae){
      JButton pressedButton = (JButton) ae.getSource();

      String name = updateNameTF.getText();
      String email = updateEmailTF.getText();
      String phone = updatePhoneTF.getText();
      String address = updateAddressTF.getText();

  		if (pressedButton.getText().equals("Save Changes")){
  				Global.database.updateSelfInfo(name, phone, email, address);
          JOptionPane.showMessageDialog(null, "Your informations have been updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
  		}
    }
}
