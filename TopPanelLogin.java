import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class TopPanelLogin extends JPanel implements ActionListener{

    JLabel title, title1,colorLabel, userLabel, passLabel;
    JTextField userTF;
    JPasswordField passPF1;
    JButton btnLogin, btnForgetPassword;
    JCheckBox checkBox1;
    //ImageIcon img;
    Font f1 = new Font("Cambria",Font.BOLD, 26);
    Font f2 = new Font("Cambria",Font.BOLD, 20);

    public TopPanelLogin(){
        super();
        setBounds(0, 0, 1280, 100);
        setLayout(null);

        title = new JLabel("Welcome to AIUB Library System");
        title.setForeground(Color.WHITE);
        title.setBounds(50, 20, 450, 30);
        title.setFont(f1);
        add(title);

        title1 = new JLabel("Dive into the ocean of knowledge");
        title1.setBounds(50, 50, 450, 30);
        title1.setForeground(Color.WHITE);
        title1.setFont(f2);
        add(title1);

        userLabel = new JLabel("User Name");
        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(770, 25, 100, 30);
        add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(850, 25, 100, 30);
        add(userTF);

        passLabel = new JLabel("Password");
        passLabel.setBounds(970, 25, 100, 30);
        passLabel.setForeground(Color.WHITE);
        add(passLabel);

        passPF1 = new JPasswordField();
        passPF1.setBounds(1045,25,100,30);
        add(passPF1);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(1165, 25, 70, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);

        btnForgetPassword = new JButton("Forgot password?");
        btnForgetPassword.setBounds(1045, 65, 190, 20);
        btnForgetPassword.addActionListener(this);
        add(btnForgetPassword);

        checkBox1= new JCheckBox("Remember me");
        checkBox1.setOpaque(false);
        checkBox1.setBounds(850, 65, 175, 20);
        checkBox1.addActionListener(this);
        add(checkBox1);

        colorLabel = new JLabel();
		    colorLabel.setBounds(0, 0, 1280, 100);
        colorLabel.setBackground(new Color(127,86,68));
		    colorLabel.setOpaque(true);
        add(colorLabel);
    }

    public void actionPerformed(ActionEvent ae){}

}
