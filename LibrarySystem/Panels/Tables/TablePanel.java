package LibrarySystem.Panels.Tables;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class TablePanel extends LeftPanel implements ActionListener{
  JTable table;
  DefaultTableModel dTableModel;
  Font f2 = new Font("Cambria",Font.PLAIN, 20);

  public TablePanel(String[] header, Object[][] rawData){
    super();
    setLayout(null);
    setBounds(0, 100, 900, 800);
    try{
      dTableModel = new DefaultTableModel(rawData, header);

      table = new JTable(dTableModel){
        public boolean isCellEditable(int row, int column) {
                return false;
        };
      };
      //table.setPreferredScrollableViewportSize(new Dimension(900,800));
      //table.setFillsViewportHeight(true);
      //table.setBounds(0, 0, 900, 800);
      table.setFont(f2);
    }
    catch(Exception ex){
      JOptionPane.showMessageDialog(null, "Table creation failed.", "Error: ", JOptionPane.WARNING_MESSAGE);
    }
    try{
      table.getColumn("Rank").setMaxWidth(30);
      table.getColumn("ID").setMaxWidth(30);
      table.getColumn("Name").setMaxWidth(200);
      table.getColumn("Book Title").setMaxWidth(200);
    }
    catch(Exception ex){

    }

    JScrollPane js=new JScrollPane(table);
    js.setVisible(true);
    js.setBounds(0, 0, 900, 600);
    add(js);



  }
}
