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

public class UpdateBookInfo extends LeftPanel implements ActionListener{

 JLabel bookInfoLabel, bookID,booktitle, author, publicationYear, quantity ;
 JTextField bookIdTF, booktitleTF, authorTF, publicationYearTF, quantityTF;
 JButton btnUpdate, btnAddBooks, btnDeleteBooks, loadBookInfo;

  public UpdateBookInfo(){
      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      Font f2 = new Font("Cambria", Font.BOLD, 20);
      Font f4= new Font("Cambria", Font.BOLD, 17);

      bookInfoLabel = new JLabel("Update Book Information");
      bookInfoLabel.setBounds(140, 150,300, 30);
      bookInfoLabel.setFont(f2);
      add(bookInfoLabel);

      bookID = new JLabel("Book ID");
      bookID.setBounds(150, 210, 150, 30);
      bookID.setFont(f4);
      add(bookID);

      bookIdTF = new JTextField();
  		bookIdTF.setBounds(250, 210, 200, 30);
  		add(bookIdTF);

      loadBookInfo = new JButton("Load Book Info");
      loadBookInfo.setBounds(400, 210, 200, 30);
      loadBookInfo.addActionListener(this);
      add(loadBookInfo);

      booktitle = new JLabel("Book Title");
      booktitle.setBounds(150, 300, 150, 30);
      booktitle.setFont(f4);
      add(booktitle);

      author = new JLabel("Author Name");
      author.setBounds(150, 350, 150, 30);
      author.setFont(f4);
      add(author);

      publicationYear = new JLabel("Publication Year");
      publicationYear.setBounds(150,400,150, 30);
      publicationYear.setFont(f4);
      add(publicationYear);

      quantity = new JLabel("Quantity");
      quantity.setBounds(150, 450,100, 30);
      quantity.setFont(f4);
      add(quantity);

      booktitleTF = new JTextField();
  		booktitleTF.setBounds(300, 300, 200, 30);
  		add(booktitleTF);

      authorTF = new JTextField();
  		authorTF.setBounds(300, 350, 200, 30);
  		add(authorTF);

      publicationYearTF = new JTextField();
      publicationYearTF.setBounds(300, 400, 200, 30);
      add(publicationYearTF);

      quantityTF = new JTextField();
      quantityTF.setBounds(300, 450, 200, 30);
      add(quantityTF);

      btnUpdate = new JButton("Update");
      btnUpdate.setBounds(300, 550, 200, 33);
      btnUpdate.setForeground(Color.GREEN);
      btnUpdate.addActionListener(this);
      add(btnUpdate);


      btnDeleteBooks = new JButton("Delete books");
  		btnDeleteBooks.setBounds(350, 600, 150, 33);
  		btnDeleteBooks.addActionListener(this);
  		add(btnDeleteBooks);

    }
    public void actionPerformed(ActionEvent ae){}
  }
