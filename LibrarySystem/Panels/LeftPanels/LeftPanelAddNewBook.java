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

public class LeftPanelAddNewBook extends LeftPanel implements ActionListener{

 JLabel addBookLabel, bookTitle, authorName, isbn, publicationYear, shelf, totalQuantity;
 JButton btnAdd;
 JTextField  bookTF, authorNameTF, isbnTF, publicationYearTF, shelfTF, totalQuantityTF;

  public LeftPanelAddNewBook(){

      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      addBookLabel = new JLabel("Add New Book");
      addBookLabel.setBounds(140, 160,200, 30);
      addBookLabel.setForeground(Color.RED);
      addBookLabel.setFont(f2);
      add(addBookLabel);

      bookTitle = new JLabel("Book Title");
      bookTitle.setBounds(150, 230, 50, 30);
      bookTitle.setFont(f4);
      add(bookTitle);

      authorName = new JLabel("Author Name");
      authorName.setBounds(150, 280, 50, 30);
      authorName.setFont(f4);
      add(authorName);

      isbn = new JLabel("ISBN:");
      isbn.setBounds(150, 330, 80, 30);
      isbn.setFont(f4);
      add(isbn);

      publicationYear = new JLabel("Publication Year");
      publicationYear.setBounds(150, 380, 100, 30);
      publicationYear.setFont(f4);
      add(publicationYear);

      shelf = new JLabel("Shelf");
      shelf.setBounds(150, 430, 100, 30);
      shelf.setFont(f4);
      add(shelf);

      totalQuantity = new JLabel("Total Quantity");
      totalQuantity.setBounds(150, 480, 100, 30);
      totalQuantity.setFont(f4);
      add(totalQuantity);


      bookTF = new JTextField();
      bookTF.setBounds(260, 230, 190, 30);
      add(bookTF);

      authorNameTF = new JTextField();
      authorNameTF.setBounds(260, 280, 190, 30);
      add(authorNameTF);

      isbnTF = new JTextField();
      isbnTF.setBounds(260, 330, 190, 30);
      add(isbnTF);

      publicationYearTF = new JTextField();
      publicationYearTF.setBounds(260, 380, 190, 30);
      add(publicationYearTF);

      shelfTF = new JTextField();
      shelfTF.setBounds(260, 430, 190, 30);
      add(shelfTF);

      totalQuantityTF = new JTextField();
      totalQuantityTF.setBounds(260, 480, 190, 30);
      add(totalQuantityTF);

      btnAdd = new JButton("Add");
      btnAdd.setBounds(150, 530, 100, 33);
    //  btnAdd.addActionListener(this);
      add(btnAdd);

    }
  }
