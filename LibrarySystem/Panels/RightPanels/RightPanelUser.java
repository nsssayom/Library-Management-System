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

public class RightPanelUser extends JPanel implements ActionListener{

JLabel colorLabelT1;
JButton btnViewMyInfo, btnEditMyInfo, btnChangePass, btnBorrowedBooks, btnMyWishList, btnSendEmail;

	public RightPanelUser(){
    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

		Font f4= new Font("Cambria",Font.BOLD, 17);

    btnViewMyInfo = new JButton("View My Informations");
    btnViewMyInfo.setBounds(50, 50, 250, 50);
		btnViewMyInfo.setFont(f4);
  	btnViewMyInfo.addActionListener(this);
    add(btnViewMyInfo);

	  btnEditMyInfo = new JButton("Edit My Information");
	  btnEditMyInfo.setBounds(50, 120, 250, 50);
		btnEditMyInfo.setFont(f4);
		btnEditMyInfo.addActionListener(this);
		add(btnEditMyInfo);

		btnChangePass = new JButton("Change Password");
		btnChangePass.setBounds(50, 190, 250, 50);
		btnChangePass.setFont(f4);
		btnChangePass.addActionListener(this);
		add(btnChangePass);

		btnBorrowedBooks = new JButton("Borrowed books");
		btnBorrowedBooks.setBounds(50, 260, 250, 50);
		btnBorrowedBooks.setFont(f4);
		btnBorrowedBooks.addActionListener(this);
		add(btnBorrowedBooks);

		btnMyWishList = new JButton("My WishList");
		btnMyWishList.setBounds(50, 330, 250, 50);
		btnMyWishList.setFont(f4);
		btnMyWishList.setEnabled(false);
		btnMyWishList.addActionListener(this);
		add(btnMyWishList);

		btnSendEmail = new JButton("Send E-mail");
		btnSendEmail.setBounds(50, 400, 250, 50);
		btnSendEmail.setFont(f4);
		btnSendEmail.setEnabled(false);
		btnSendEmail.addActionListener(this);
		add(btnSendEmail);

		colorLabelT1 = new JLabel();
    colorLabelT1.setBounds(900, 100, 380, 800);
    colorLabelT1.setBackground(new Color(127,86,68));
    colorLabelT1.setOpaque(true);
    add(colorLabelT1);
  }

  public void actionPerformed(ActionEvent ae){
		JButton pressedButton = (JButton) ae.getSource();
		if (pressedButton.getText().equals("View My Informations")){
				Global.gui.viewSelfInformation();
		}
		else if (pressedButton.getText().equals("Edit My Information")){
				Global.gui.editSelfInformation();
		}
		else if (pressedButton.getText().equals("Change Password")){
				Global.gui.changePassword();
		}
		else if (pressedButton.getText().equals("Borrowed books")){

		}
		else if (pressedButton.getText().equals("My WishList")){

		}
		else if (pressedButton.getText().equals("Send E-mail")){

		}

	}

}
