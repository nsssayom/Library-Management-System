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

	JLabel myAccountLabel, btnMyInfo, borderLabel, colorLabelT1;
	JButton  btnBorrowedBooks;

	public RightPanelUser(){
    super();
    setBounds(900, 100, 380, 800);
    setLayout(null);

    Font f2 = new Font("Cambria",Font.BOLD, 20);

    myAccountLabel = new JLabel("My Library Account");
    myAccountLabel.setBounds(120, 63, 400, 40);
    myAccountLabel.setFont(f2);
    myAccountLabel.setOpaque(true);
    add(myAccountLabel);

    btnMyInfo = new JLabel("My informations");
    btnMyInfo.setBounds(130, 170, 150, 40);
  	//btnMyInfo.addActionListener(this);
    add(btnMyInfo);

	  btnBorrowedBooks = new JButton("Borrowed books");
	  btnBorrowedBooks.setBounds(130, 250, 150, 40);
	  //btnBorrowedBooks.addActionListener(this);
		add(btnBorrowedBooks);

		colorLabelT1 = new JLabel();
    colorLabelT1.setBounds(900, 100, 380, 800);
    colorLabelT1.setBackground(new Color(127,86,68));
    colorLabelT1.setOpaque(true);
    add(colorLabelT1);
  }

  public void actionPerformed(ActionEvent ae){
		String text = ae.getActionCommand();
		/*if(text.equals(btnMyInfo.getText()))
		{
    /* LeftPanelUserInfo LU= new LeftPanelUserInfo();
			LU.setVisible(true);
			System.exit(0);

		}*/
		//if(ae.getSource== btnMyInfo){
		//	System.exit(0);
  //}

	}

}
