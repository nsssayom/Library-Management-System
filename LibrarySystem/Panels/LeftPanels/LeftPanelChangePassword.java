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

public class LeftPanelChangePassword extends LeftPanel implements ActionListener{

JLabel titleCP,titleCPU , oldPassLabel, newPassLabel, confirmPassLabel;
JButton  btnChange;
JPasswordField OldPassTF, newpassTF, confirmPassTF;

	public LeftPanelChangePassword(){

    super();
    //setBounds(900, 100, 380, 800);
    //setLayout(null);

	  Font f4 = new Font("Cambria",Font.BOLD, 17);
		Font f2 = new Font("Cambria",Font.BOLD, 20);

		titleCP = new JLabel("Change Password");
 		titleCP.setBounds(150, 210, 200, 30);
 		titleCP.setFont(f2);
 		add(titleCP);


		oldPassLabel = new JLabel("Old Password");
		oldPassLabel.setBounds(150, 280, 150, 30);
		oldPassLabel.setFont(f4);
		add(oldPassLabel);

		newPassLabel = new JLabel("New Password");
		newPassLabel.setBounds(150, 350, 150, 30);
		newPassLabel.setFont(f4);
		add(newPassLabel);

		confirmPassLabel = new JLabel("Confirm Password");
		confirmPassLabel.setBounds(150, 400, 150, 30);
		confirmPassLabel.setFont(f4);
		add(confirmPassLabel);

		OldPassTF = new JPasswordField();
		OldPassTF.setBounds(330, 280, 200, 30);
		add(OldPassTF);

		newpassTF = new JPasswordField();
		newpassTF.setBounds(330, 350, 200, 30);
		add(newpassTF);

		confirmPassTF = new JPasswordField();
		confirmPassTF.setBounds(330, 400, 200, 30);
		add(confirmPassTF);

		btnChange = new JButton("Change");
		btnChange.setBounds(150, 470, 150, 33);
		btnChange.addActionListener(this);
		add(btnChange);
  }
	public void actionPerformed(ActionEvent ae){
		JButton pressedButton = (JButton) ae.getSource();

		String oldPwd = new String (OldPassTF.getPassword());
		String newPwd = new String (newpassTF.getPassword());
		String confirmNewPwd = new String (confirmPassTF.getPassword());

		if (pressedButton.getText().equals("Change")){
			if ((oldPwd != null && !oldPwd.isEmpty())
			&& (newPwd != null && !newPwd.isEmpty())
			&& (confirmNewPwd != null && !confirmNewPwd.isEmpty())){
				if (Global.database.verifyPassword(oldPwd)){
					if (newPwd.equals(confirmNewPwd)){
						Global.database.updatePassword(newPwd);
						JOptionPane.showMessageDialog(null, "Your password has been changed.", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "New password didn't match.", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "You have entered a wrong password.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
