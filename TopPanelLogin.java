import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class TopPanelLogin extends JPanel implements ActionListener{

    JLabel title, title1,colorLabel, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF1;
    JButton btnLogin,  btnForgetPassword;
    JCheckBox checkBox1;

    public TopPanelLogin(){
        super();
        setBounds(0, 0, 1280, 100);
        setLayout(null);

        Font f1 = new Font("Cambria",Font.BOLD, 26);
        Font f2 = new Font("Cambria",Font.BOLD, 20);
        Font f3 = new Font("Cambria",Font.BOLD, 16);

        title = new JLabel("Welcome to AIUB Library System");
        title.setForeground(Color.WHITE);
        title.setBounds(50, 20, 450, 30);
        title.setFont(f1);
        add(title);

        title1 = new JLabel("Dive into the ocean of knowledge");
        title1.setBounds(50, 50, 450, 30);
        title1.setForeground(Color.CYAN);
        title1.setFont(f2);
        add(title1);

        userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(746, 25, 100, 30);
        userLabel.setFont(f3);
        add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(830, 25, 128, 30);
        add(userTF);

        passLabel = new JLabel("Password");
        passLabel.setBounds(970, 25, 100, 30);
        passLabel.setFont(f3);
        passLabel.setForeground(Color.WHITE);
        add(passLabel);

        passPF1 = new JPasswordField();
        passPF1.setBounds(1045,25,120,30);
        add(passPF1);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(1170, 25, 70, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnForgetPassword = new JButton("Forgot password?");
        btnForgetPassword.setBounds(1045, 65, 195, 20);
        btnForgetPassword.setForeground(Color.RED);
        btnForgetPassword.addActionListener(this);
        add(btnForgetPassword);

        checkBox1= new JCheckBox("Remember me");
        checkBox1.setOpaque(false);
        checkBox1.setBounds(830, 65, 175, 20);
        checkBox1.addActionListener(this);
        add(checkBox1);

        colorLabel = new JLabel();
		    colorLabel.setBounds(0, 0, 1280, 100);
        colorLabel.setBackground(new Color(127,86,68));
		    colorLabel.setOpaque(true);
        add(colorLabel);
    }

    public void actionPerformed(ActionEvent ae){
      JButton pressedButton = (JButton) ae.getSource();
      String userName = userTF.getText();
      String password = new String(passPF1.getPassword());

      if ((userName == "") || (password == "")){
        JOptionPane.showMessageDialog(null, "ALERT MESSAGE", "TITLE", JOptionPane.WARNING_MESSAGE);
        return;
      }

      if (pressedButton.getText() == "Login"){
        System.out.println("Login Button Pressed!");
        System.out.println(userName + "|" + password);
        try{
  				GUI.database.logIn(userName, password);
          JOptionPane.showMessageDialog(null, "Successfully Looged in!", "Success", JOptionPane.WARNING_MESSAGE);
  			}
  			catch(LibraryException lx){
          JOptionPane.showMessageDialog(null, lx.getMessage(), "Error: " + lx.getCode(), JOptionPane.WARNING_MESSAGE);
  			}
      }
    }
}
