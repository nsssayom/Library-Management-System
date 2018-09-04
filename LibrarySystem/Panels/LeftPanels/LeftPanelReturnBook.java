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

public class LeftPanelReturnBook extends LeftPanel implements ActionListener{

 JLabel title, bookId;
 JTextField bookIdTF;
 JButton btnReturn;

  public LeftPanelReturnBook(){
      super();

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);

      title = new JLabel("Return Book");
      title.setBounds(140, 150,300, 30);
      title.setFont(f2);
      add(title);

      bookId = new JLabel("Book ID");
      bookId.setBounds(150, 280, 150, 30);
      bookId.setFont(f4);
      add(bookId);

      bookIdTF = new JTextField();
      bookIdTF.setBounds(300, 280, 200, 30);
      add(bookIdTF);

      btnReturn = new JButton("Return");
      btnReturn.setBounds(150, 380, 110, 33);
      add(btnReturn);
    }
}
