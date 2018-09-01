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

public class RightPanelUser extends JPanel implements ActionListener, MouseListener{

JLabel myAccountLabel, btnMyInfo;
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

    btnMyInfo = new JLabel("My info");
    btnMyInfo.setBounds(130, 170, 150, 40);
  //  btnMyInfo.addActionListener(this);
		btnMyInfo.addMouseListener(this);
//		btnMyinfo.setOpaque(true);
    add(btnMyInfo);

  btnBorrowedBooks = new JButton("Borrowed books");
  btnBorrowedBooks.setBounds(130, 250, 150, 40);
  //btnBorrowedBooks.addActionListener(this);
	btnBorrowedBooks.addMouseListener(this);
	add(btnBorrowedBooks);
  }

	  public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
		public void mouseClicked(MouseEvent me){}


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
