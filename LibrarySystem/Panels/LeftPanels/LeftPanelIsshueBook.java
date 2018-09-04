ackage LibrarySystem.Panels.LeftPanels;

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

public class LeftPanelIsshueBook extends LeftPanel implements ActionListener{

 JLabel title, bookId, userName ;
 JTextField bookIdTF,userNameTF;
 JButton btnIsshue;

  public LeftPanelIsshueBook(){
      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);

      title = new JLabel("Isshue Book");
      title.setBounds(140, 150,300, 30);
      title.setFont(f2);
      add(title);

      bookId = new JLabel("Book ID");
      bookId.setBounds(150, 280, 150, 30);
      bookId.setFont(f4);
      add(bookId);

      userName = new JLabel("User Name");
      userName.setBounds(150,330,150, 30);
      userName.setFont(f4);
      add(userName);

      bookIdTF = new JTextField();
      bookIdTF.setBounds(300, 280, 200, 30);
      add(bookIdTF);

      userNameTF = new JTextField();
      userNameTF.setBounds(300, 330, 200, 30);
      add(userNameTF);


      btnIsshue = new JButton("Isshue");
      btnIsshue.setBounds(150, 380, 110, 33);
      add(btnIsshue);
}
}
