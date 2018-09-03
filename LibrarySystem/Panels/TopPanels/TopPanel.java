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

  JLabel titleT1, user, role, imgLabel2;
  ImageIcon img;
  JTextField searchTF;
  JButton btnLogOut, btnExit, btnSearch;
  JComboBox searchCB;

  public TopPanel(){
    super();
    setBounds(0, 0, 1280, 100);
    setLayout(null);
    setOpaque(true);
    setBackground(new Color(127,86,68));

    Font f2 = new Font("Courier",Font.BOLD, 15);
    Font f5 = new Font("Cambria",Font.BOLD, 15);

    searchTF = new JTextField();
    searchTF.setBounds(100, 30, 500, 35);
    add(searchTF);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(790, 30, 110, 35);
    btnSearch.setFont(f5);
    btnSearch.addActionListener(this);
    add(btnSearch);

    String []comboItems = {"Book", "Author", "ISBN"};
    searchCB = new JComboBox(comboItems);
		searchCB.setBounds(620, 30, 150, 35);
  	add(searchCB);

      user = new JLabel(Global.NAME);
      user.setForeground(Color.WHITE);
      user.setBounds(950,25,200,30);
      user.setFont(f2);
      add(user);

      role = new JLabel(Global.getRole());
      role.setForeground(Color.WHITE);
      role.setBounds(950,50,120,30);
      role.setFont(f2);
      add(role);

      btnLogOut = new JButton("Log Out");
      btnLogOut.setBounds(1160, 25, 80, 30);
    //  btnLogOut.setFont(f5);
      btnLogOut.addActionListener(this);
      add(btnLogOut);

      btnExit = new JButton("Exit");
      btnExit.setBounds(1160, 60, 80, 30);
      //btnExit.setFont(f5);
      btnExit.addActionListener(this);
      add(btnExit);

      img = new ImageIcon("pic2.jpg");
      imgLabel2 = new JLabel(img);
      imgLabel2.setBounds(23, 22, 60, 60);
      add(imgLabel2);
    }

  public void actionPerformed(ActionEvent ae){
    JButton pressedButton = (JButton) ae.getSource();
    String dataSet = searchCB.getSelectedItem().toString();
    String keyWord = searchTF.getText();
    if ((pressedButton.getText().equals("Search")) && (keyWord != null && !keyWord.isEmpty())){
      if (dataSet.equals("Book")){
        Global.gui.showSearch("bookTitle", keyWord);
      }
      else if (dataSet.equals("Author")){
        Global.gui.showSearch("authorName", keyWord);
      }
      else if(dataSet.equals("ISBN")){
        Global.gui.showSearch("ISBN", keyWord);
      }
    }
    else if (pressedButton.getText().equals("Log Out")){
      try{
        Global.gui.showLoginScreen();
        JOptionPane.showMessageDialog(null, "You have successfully logged out.", "Good Bye!", JOptionPane.WARNING_MESSAGE);
      }
      catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Can not log out!", "Error", JOptionPane.WARNING_MESSAGE);
      }
    }
    else if (pressedButton.getText().equals("Exit")){
      System.exit(0);
    }
    else{
      JOptionPane.showMessageDialog(null, "Can not search empty string.", "Nothing to Search: ", JOptionPane.WARNING_MESSAGE);
    }
  }
}
