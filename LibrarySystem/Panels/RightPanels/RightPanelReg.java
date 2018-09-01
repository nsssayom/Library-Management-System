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

public class RightPanelReg extends JPanel implements ActionListener{

  JLabel signLabel, nameLabel, idLabel, emailLabel, phoneLabel, addressLabel, userNameLabel, passwordLabel, termLabel, termLabel2;
	JTextField  nameTF, idTF, emailTF, phoneTF, addressTF,userNameTF;
	JPasswordField  passPF2;
	JButton btnLogin, btnExit, btnSignUp;

	public RightPanelReg(){

    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

    Font f1 = new Font("Cambria",Font.BOLD, 26);
    Font f2 = new Font("Cambria",Font.BOLD, 20);
    Font f4= new Font("Cambria",Font.BOLD, 17);

    signLabel = new JLabel("New here? Create a free account");
    signLabel.setBounds(30, 70, 400, 30);
    signLabel.setFont(f2);
    signLabel.setOpaque(true);
    add(signLabel);

    nameLabel = new JLabel("Name:");
    nameLabel.setBounds(30, 150, 50, 30);
    nameLabel.setFont(f4);
    add(nameLabel);

    idLabel = new JLabel("ID:");
    idLabel.setBounds(30, 190, 50, 30);
    idLabel.setFont(f4);
    add(idLabel);

    emailLabel = new JLabel("E-mail:");
    emailLabel.setBounds(30, 230, 80, 30);
    emailLabel.setFont(f4);
    add(emailLabel);

    phoneLabel = new JLabel("Phone no:");
    phoneLabel.setBounds(30, 270, 100, 30);
    phoneLabel.setFont(f4);
    add(phoneLabel);

    addressLabel = new JLabel("Address:");
    addressLabel.setBounds(30, 310, 100, 30);
    addressLabel.setFont(f4);
    add(addressLabel);

    userNameLabel = new JLabel("User name:");
    userNameLabel.setBounds(30, 370, 100, 30);
    userNameLabel.setFont(f4);
    add(userNameLabel);

    passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(30,410 , 100, 30);
    passwordLabel.setFont(f4);
    add(passwordLabel);

    nameTF = new JTextField();
    nameTF.setBounds(130, 150, 170, 30);
    add(nameTF);

    idTF = new JTextField();
    idTF.setBounds(130, 190, 170, 30);
    add(idTF);

    emailTF = new JTextField();
    emailTF.setBounds(130, 230, 170, 30);
    add(emailTF);

    phoneTF = new JTextField();
    phoneTF.setBounds(130, 270, 170, 30);
    add(phoneTF);

    addressTF = new JTextField();
    addressTF.setBounds(130, 310, 170, 30);
    add(addressTF);

    userNameTF = new JTextField();
    userNameTF.setBounds(130, 370, 170, 30);
    add(userNameTF);

    passPF2 = new JPasswordField();
    passPF2.setBounds(130,410,170,30);
    add(passPF2);

    btnSignUp = new JButton("Sign up");
    btnSignUp.setBounds(30, 470, 90, 33);
    btnSignUp.addActionListener(this);
    add(btnSignUp);

    termLabel = new JLabel("By clicking this I am accepting ");
    termLabel.setBounds(132, 464, 300, 30);
    add(termLabel);
    termLabel2 = new JLabel("all the terms and conditions");
    termLabel2.setBounds(132, 484, 300, 30);
    add(termLabel2);

    btnExit = new JButton("Exit");
    btnExit.setBounds(265, 550, 70, 30);
    btnExit.addActionListener(this);
    add(btnExit);

  }
  public void actionPerformed(ActionEvent ae){}

}
