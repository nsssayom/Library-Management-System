package LibrarySystem.Panels.TopPanels;

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

public class TopPanelLogin extends JPanel implements ActionListener{

    JLabel title, title1, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF1;
    JButton btnLogin,  btnForgetPassword;

    public TopPanelLogin(){
        super();
        setBounds(0, 0, 1280, 100);
        setLayout(null);
        setOpaque(true);
        setBackground(new Color(127,86,68));

        Font f1 = new Font("Cambria",Font.BOLD, 26);
        Font f2 = new Font("Cambria",Font.BOLD, 20);
        Font f3 = new Font("Cambria",Font.BOLD, 16);

        title = new JLabel("Welcome to Softopian Library System");
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
    }

    public void actionPerformed(ActionEvent ae){
      JButton pressedButton = (JButton) ae.getSource();
      String userName = userTF.getText();
      String password = new String(passPF1.getPassword());

      if (pressedButton.getText() == "Login"){
        System.out.println("Login Button Pressed!");
        System.out.println(userName + " | " + password);

        if ((userName != null && !userName.isEmpty())
        && (password != null && !password.isEmpty())) {
          try{
    				Global.database.logIn(userName, password);
            //JOptionPane.showMessageDialog(null, "Successfully Looged in!", "Success", JOptionPane.WARNING_MESSAGE);
            Global.gui.showHome();
    			}
    			catch(LibraryException lx){
            JOptionPane.showMessageDialog(null, lx.getMessage(), "Error: " + lx.getCode(), JOptionPane.WARNING_MESSAGE);
    			}
        }
        else{
          JOptionPane.showMessageDialog(null, "Required fields must not be kept blank.", "Error: " + "Field Left Blank", JOptionPane.WARNING_MESSAGE);
        }
      }
    }
}
