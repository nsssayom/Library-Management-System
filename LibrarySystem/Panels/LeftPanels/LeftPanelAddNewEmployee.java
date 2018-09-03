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

public class LeftPanelAddNewEmployee extends LeftPanel implements ActionListener{

 JLabel nameLabel, userNameLabel, idLabel, passLabel, roleLabel, phoneLabel, salaryLabel;
 JTextField nameTF, userNameTF, idTF, postTF, salaryTF;
 JButton btnAdd;

  public LeftPanelAddNewEmployee(){
      super();
      setBounds(0, 0 , 900, 800);
      setLayout(null);
    }
  public void actionPerformed(ActionEvent ae){}
  }
