import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class LeftPanelUserInfo extends LeftPanel implements ActionListener{

 JLabel userInfoMyInfoLabel, userInfoNameLabel, userInfoIdLabel, userINfoEmailLabel, userInfoPhoneLabel, userInfoAddressLabel, userInfoUserNameLabel;
 JButton btnUpdateInfo;

  public LeftPanelUserInfo(){
      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);

      userInfoMyInfoLabel = new JLabel("My Information");
      userInfoMyInfoLabel.setBounds(140, 180,150, 30);
      userInfoMyInfoLabel.setForeground(Color.RED);
      userInfoMyInfoLabel.setFont(f2);
      add(userInfoMyInfoLabel);

      userInfoNameLabel = new JLabel("Name:");
      userInfoNameLabel.setBounds(150, 250, 50, 30);
      userInfoNameLabel.setFont(f4);
      add(userInfoNameLabel);

      userInfoIdLabel = new JLabel("ID:");
      userInfoIdLabel.setBounds(150, 300, 50, 30);
      userInfoIdLabel.setFont(f4);
      add(userInfoIdLabel);

      userINfoEmailLabel = new JLabel("E-mail:");
      userINfoEmailLabel.setBounds(150, 350, 80, 30);
      userINfoEmailLabel.setFont(f4);
      add(userINfoEmailLabel);

      userInfoPhoneLabel = new JLabel("Phone no:");
      userInfoPhoneLabel.setBounds(150, 400, 100, 30);
      userInfoPhoneLabel.setFont(f4);
      add(userInfoPhoneLabel);

      userInfoAddressLabel = new JLabel("Address:");
      userInfoAddressLabel.setBounds(150, 450, 100, 30);
      userInfoAddressLabel.setFont(f4);
      add(userInfoAddressLabel);

      userInfoUserNameLabel = new JLabel("User name:");
      userInfoUserNameLabel.setBounds(150, 500, 100, 30);
      userInfoUserNameLabel.setFont(f4);
      add(userInfoUserNameLabel);

        btnUpdateInfo = new JButton("Update Information");
        btnUpdateInfo.setBounds(150, 570, 150, 33);
        btnUpdateInfo.addActionListener(this);
        add(btnUpdateInfo);


  }
    public void actionPerformed(ActionEvent ae){}

}
