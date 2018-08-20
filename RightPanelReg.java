import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class RightPanelReg extends JPanel implements ActionListener{

  JLabel signLabel, nameLabel, emailLabel, passwordLabel,termLabel,termLabel2;
	JTextField  nameTF, emailTF;
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
    signLabel.setBounds(30, 90, 400, 30);
    signLabel.setFont(f2);
    signLabel.setOpaque(true);
    add(signLabel);

    nameLabel = new JLabel("Name:");
    nameLabel.setBounds(30, 200, 50, 30);
    nameLabel.setFont(f4);
    add(nameLabel);

    emailLabel = new JLabel("E-mail:");
    emailLabel.setBounds(30, 240, 80, 30);
    emailLabel.setFont(f4);
    add(emailLabel);

    passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(30, 280, 100, 30);
    passwordLabel.setFont(f4);
    add(passwordLabel);

    nameTF = new JTextField();
    nameTF.setBounds(120, 200, 170, 30);
    add(nameTF);

    emailTF = new JTextField();
    emailTF.setBounds(120, 240, 170, 30);
    add(emailTF);

    passPF2 = new JPasswordField();
    passPF2.setBounds(120,280,170,30);
    add(passPF2);

    btnSignUp = new JButton("Sign up");
    btnSignUp.setBounds(30, 360, 90, 33);
    btnSignUp.addActionListener(this);
    add(btnSignUp);

    termLabel = new JLabel("By clicking this I am accepting ");
    termLabel.setBounds(132, 350, 300, 30);
    add(termLabel);
    termLabel2 = new JLabel("all the terms and conditions");
    termLabel2.setBounds(132, 370, 300, 30);
    add(termLabel2);

    btnExit = new JButton("Exit");
    btnExit.setBounds(265, 550, 70, 30);
    btnExit.addActionListener(this);
    add(btnExit);

  }
  public void actionPerformed(ActionEvent ae){}

}
