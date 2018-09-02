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

public class LeftPanelLogin extends LeftPanel implements ActionListener{

    JLabel imgLabel1;
    ImageIcon img;

    public LeftPanelLogin(){
        super();
        img = new ImageIcon("pic1.jpg");
        imgLabel1 = new JLabel(img);
        imgLabel1.setBounds(0, 0, 900, 800);
        add(imgLabel1);
      }

        public void actionPerformed(ActionEvent ae){

        }
}
