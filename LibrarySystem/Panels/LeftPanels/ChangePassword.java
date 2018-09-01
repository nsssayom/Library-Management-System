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

public class ChangePassword extends LeftPanel implements ActionListener{

JLabel titleCP,titleCPU , oldPassLabel, newPassLabel;
JButton  btnChange;
JTextField OldPassTF, newpassTF;

	public ChangePassword(){

    super();
    //setBounds(900, 100, 380, 800);
    //setLayout(null);

	  Font f4 = new Font("Cambria",Font.BOLD, 17);
		Font f2 = new Font("Cambria",Font.BOLD, 20);

		titleCP = new JLabel("Change Password");
 		titleCP.setBounds(150, 180, 200, 30);
 		titleCP.setFont(f2);
 		add(titleCP);

		titleCPU = new JLabel("___________________________________");
	 	titleCPU.setBounds(130, 200, 230, 30);
		titleCPU.setForeground(Color.RED);
		titleCPU.setFont(f4);
	 	add(titleCPU);

		oldPassLabel = new JLabel("Old Password");
		oldPassLabel.setBounds(150, 280, 150, 30);
		oldPassLabel.setFont(f4);
		add(oldPassLabel);

		newPassLabel = new JLabel("New Password");
		newPassLabel.setBounds(150, 350, 150, 30);
		newPassLabel.setFont(f4);
		add(newPassLabel);

		OldPassTF = new JTextField();
		OldPassTF.setBounds(280, 280, 200, 30);
		add(OldPassTF);


		newpassTF = new JTextField();
		newpassTF.setBounds(280, 350, 200, 30);
		add(newpassTF);

		btnChange = new JButton("Change");
		btnChange.setBounds(200, 500, 150, 33);
		btnChange.addActionListener(this);
		add(btnChange);
  }
	public void actionPerformed(ActionEvent ae){}

}
