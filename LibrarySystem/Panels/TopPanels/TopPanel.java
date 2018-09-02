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

public class TopPanel extends JPanel implements ActionListener{

  JLabel titleT1;

  public TopPanel(){
    super();
    setBounds(0, 0, 1280, 100);
    setLayout(null);
    setOpaque(true);
    setBackground(new Color(127,86,68));

    Font f4 = new Font("Cambria",Font.BOLD, 28);

    titleT1 = new JLabel("Welcome to Softopian Library System");
    titleT1.setForeground(Color.WHITE);
    titleT1.setBounds(800, 20, 450, 30);
    titleT1.setFont(f4);
    add(titleT1);
  }
  public void actionPerformed(ActionEvent ae){}
}
