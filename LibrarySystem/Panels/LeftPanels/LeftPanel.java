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

public class LeftPanel extends JPanel implements ActionListener{
  public LeftPanel(){
      super();
      setBounds(0, 0 , 900, 800);
      setLayout(null);
      setOpaque(true);
      setBackground(new Color(214,208,196));
    }
    public void actionPerformed(ActionEvent ae){}

}
