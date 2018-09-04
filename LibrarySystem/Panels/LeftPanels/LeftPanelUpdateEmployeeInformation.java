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

public class LeftPanelUpdateEmployeeInformation extends LeftPanel implements ActionListener{

 JLabel title, role, salary ;
 JTextField  salaryTF;
 JComboBox roleCB;
 JButton btnUpdate;

  public LeftPanelUpdateEmployeeInformation(){
      super();
      //setBounds(0, 100 , 900, 800);
      //setLayout(null);

      Font f2 = new Font("Cambria", Font.BOLD, 20);
      Font f4= new Font("Cambria", Font.BOLD, 17);

      title = new JLabel("Update Employee Information");
      title.setBounds(140, 150,350, 30);
      title.setFont(f2);
      add(title);

      role = new JLabel("Role");
      role.setBounds(150, 220, 150, 30);
      role.setFont(f4);
      add(role);

      salary = new JLabel("Salary");
      salary.setBounds(150, 280, 150, 30);
      salary.setFont(f4);
      add(salary);

      String []comboItems = {"General", "Manager"};
      roleCB = new JComboBox(comboItems);
      roleCB.setBounds(300, 220, 200, 30);
      add(roleCB);

      salaryTF = new JTextField();
      salaryTF.setBounds(300, 280, 200, 30);
      add(salaryTF);


}
}
