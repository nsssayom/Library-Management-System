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

public class LeftPanelUserInfo extends LeftPanel implements ActionListener{

 JLabel userInfoMyInfoLabel, userInfoNameLabel, userInfoIdLabel, userINfoEmailLabel, userInfoPhoneLabel, userInfoAddressLabel, userInfoUserNameLabel;
 JLabel nameData,idData,emailData,phoneData,addressData,userNameData;
 JButton btnDeleteMyAccount;

  public LeftPanelUserInfo(){
      super();
      setBounds(0, 0 , 900, 800);
      setLayout(null);

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);
      Font f6= new Font("Cambria",Font.PLAIN, 18);

      userInfoMyInfoLabel = new JLabel("My Information");
      userInfoMyInfoLabel.setBounds(140, 180,150, 30);
      userInfoMyInfoLabel.setForeground(Color.RED);
      userInfoMyInfoLabel.setFont(f2);
      add(userInfoMyInfoLabel);

      userInfoNameLabel = new JLabel("Name:");
      userInfoNameLabel.setBounds(150, 250, 50, 30);
      userInfoNameLabel.setFont(f4);
      add(userInfoNameLabel);

      // userInfoIdLabel = new JLabel("ID:");
      // userInfoIdLabel.setBounds(150, 300, 50, 30);
      // userInfoIdLabel.setFont(f4);
      // add(userInfoIdLabel);

      userINfoEmailLabel = new JLabel("E-mail:");
      userINfoEmailLabel.setBounds(150, 300, 80, 30);
      userINfoEmailLabel.setFont(f4);
      add(userINfoEmailLabel);

      userInfoPhoneLabel = new JLabel("Phone no:");
      userInfoPhoneLabel.setBounds(150, 350, 100, 30);
      userInfoPhoneLabel.setFont(f4);
      add(userInfoPhoneLabel);

      userInfoAddressLabel = new JLabel("Address:");
      userInfoAddressLabel.setBounds(150, 400, 100, 30);
      userInfoAddressLabel.setFont(f4);
      add(userInfoAddressLabel);

      userInfoUserNameLabel = new JLabel("User name:");
      userInfoUserNameLabel.setBounds(150, 475, 100, 30);
      userInfoUserNameLabel.setFont(f4);
      add(userInfoUserNameLabel);

      nameData = new JLabel(Global.NAME);
      nameData.setBounds(300, 250, 500, 30);
      nameData.setFont(f6);
      add(nameData);

      // idData = new JLabel(Global.ID);
      // idData.setBounds(300, 300, 50, 30);
      // idData.setFont(f6);
      // add(idData);

      emailData = new JLabel(Global.EMAIL);
      emailData.setBounds(300, 300, 500, 30);
      emailData.setFont(f6);
      add(emailData);

      phoneData = new JLabel(Global.PHONE);
      phoneData.setBounds(300, 350, 500, 30);
      phoneData.setFont(f6);
      add(phoneData);

      addressData = new JLabel(Global.ADDRESS);
      addressData.setBounds(300, 400, 500, 30);
      addressData.setFont(f6);
      add(addressData);

      userNameData = new JLabel(Global.USERNAME);
      userNameData.setBounds(300, 475, 500, 30);
      userNameData.setFont(f6);
      add(userNameData);

    	btnDeleteMyAccount = new JButton("Delete My Account");
  		btnDeleteMyAccount.setBounds(140, 570, 250, 30);
      btnDeleteMyAccount.setFont(f4);
      btnDeleteMyAccount.setForeground(Color.RED);
      btnDeleteMyAccount.addActionListener(this);
      add(btnDeleteMyAccount);
  }
    public void actionPerformed(ActionEvent ae){
      JButton pressedButton = (JButton) ae.getSource();
  		if (pressedButton.getText().equals("Delete My Account")){
  				Global.database.deleteAccount();
          Global.gui.showLoginScreen();
          JOptionPane.showMessageDialog(null, "You can not log in anymore with your previous UserName and Password.", "Account Deleted", JOptionPane.WARNING_MESSAGE);
  		}
    }

}
