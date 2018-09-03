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
  JButton btnLogOut, btnSearch;
  JComboBox searchCB;

  public TopPanel(){
    super();
    setBounds(0, 0, 1280, 100);
    setLayout(null);
    setOpaque(true);
    setBackground(new Color(127,86,68));

    Font f2 = new Font("Cambria",Font.BOLD, 20);
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

      user = new JLabel("User");
      user.setForeground(Color.WHITE);
      user.setBounds(1045,25,120,30);
      user.setFont(f2);
      add(user);

      role = new JLabel("Role");
      role.setForeground(Color.WHITE);
      role.setBounds(1045,55,120,30);
      role.setFont(f2);
      add(role);

      btnLogOut = new JButton("Log Out");
      btnLogOut.setBounds(1170, 20, 90, 60);
      btnLogOut.setFont(f5);
      btnLogOut.addActionListener(this);
      add(btnLogOut);

<<<<<<< HEAD
      img = new ImageIcon("pic2.jpg");
      imgLabel2 = new JLabel(img);
      imgLabel2.setBounds(23, 22, 60, 60);
      add(imgLabel2);


  /*  titleT1 = new JLabel("Softopian Library System");
    titleT1.setForeground(Color.WHITE);
    titleT1.setBounds(800, 20, 450, 30);
    titleT1.setFont(f4);
    add(titleT1);*/
=======
>>>>>>> d4927db021aaa542f6fff12645f6f3aefae1395d
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
    else{
      JOptionPane.showMessageDialog(null, "Can not search empty string.", "Nothing to Search: ", JOptionPane.WARNING_MESSAGE);
    }
  }
}
