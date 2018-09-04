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
      bookInfoLabel.setBounds(140, 160,300, 30);
      bookInfoLabel.setFont(f2);
      add(bookInfoLabel);

      bookID = new JLabel("Book ID");
      bookID.setBounds(150, 220, 150, 30);
      bookID.setFont(f4);
      add(bookID);

      bookIdTF = new JTextField();
  		bookIdTF.setBounds(300, 220, 200, 30);
  		add(bookIdTF);

      loadBookInfo = new JButton("Load Book Info");
      loadBookInfo.setBounds(530, 220, 150, 30);
      loadBookInfo.addActionListener(this);
      add(loadBookInfo);
      loadBookInfo.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      try{
                        Object[][] bookInfo= Global.database.loadBookInfo(bookIdTF.getText());
                        booktitleTF.setText((String)bookInfo[0][0]);
                        authorTF.setText((String)bookInfo[0][1]);
                        publicationYearTF.setText((String)bookInfo[0][2]);
                        quantityTF.setText((String)bookInfo[0][3]);
                        btnUpdate.setEnabled(true);
                        btnDeleteBooks.setEnabled(true);
                      }
                      catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Book not found!", "Error", JOptionPane.WARNING_MESSAGE);
                      }
                    }
  							   });

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
      btnUpdate.setEnabled(false);
      btnUpdate.addActionListener(this);
      add(btnUpdate);
      btnUpdate.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      String bookID = bookIdTF.getText();
                      String title = booktitleTF.getText();
                      String author = authorTF.getText();
                      String pubYear = publicationYearTF.getText();
                      String quantity = quantityTF.getText();

                      try{
                        Global.database.updateBook(bookID, title, author, pubYear, quantity);
                        JOptionPane.showMessageDialog(null, "Book information has been updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                      }
                      catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Can not update book information!", "Error", JOptionPane.WARNING_MESSAGE);
                      }
                    }
  							   });

      btnDeleteBooks = new JButton("Delete books");
  		btnDeleteBooks.setBounds(140, 550, 150, 30);
      btnDeleteBooks.setForeground(Color.RED);
      btnDeleteBooks.setEnabled(false);
  		btnDeleteBooks.addActionListener(this);
  		add(btnDeleteBooks);
      btnDeleteBooks.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      String bookID = bookIdTF.getText();

                      try{
                        Global.database.deleteBook(bookID);
                        JOptionPane.showMessageDialog(null, "Book has been deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                      }
                      catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Can not delete book", "Error", JOptionPane.WARNING_MESSAGE);
                      }
                    }
  							   });
    }
    public void actionPerformed(ActionEvent ae){}
  }
