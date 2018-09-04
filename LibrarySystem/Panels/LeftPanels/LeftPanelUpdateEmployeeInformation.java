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

 JLabel title, name, role, salary ;
 JTextField  salaryTF,nameTF;
 JComboBox roleCB;
 JButton btnUpdate, btnLoadEmployee, btnDelete;
 static String peopleID = "";
 static String accountID = "";

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

      name= new JLabel("Employee Name");
      name.setBounds(150, 220, 200, 30);
      name.setFont(f4);
      add(name);

      role = new JLabel("Role");
      role.setBounds(150, 280, 150, 30);
      role.setFont(f4);
      add(role);

      salary = new JLabel("Salary");
      salary.setBounds(150, 320, 150, 30);
      salary.setFont(f4);
      add(salary);

      String []comboItems = {"General", "Manager"};
      roleCB = new JComboBox(comboItems);
      roleCB.setBounds(300, 280, 200, 30);
      add(roleCB);

      nameTF = new JTextField();
      nameTF.setBounds(300, 220, 200, 30);
      add(nameTF);

      salaryTF = new JTextField();
      salaryTF.setBounds(300, 320, 200, 30);
      add(salaryTF);


      btnLoadEmployee = new JButton("Load Employee");
      btnLoadEmployee.setBounds(510, 220, 170, 30);
    //  btnLoadEmployee.setForeground(Color.GREEN);
      add(btnLoadEmployee);
      btnLoadEmployee.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      try{
                        Object[][] bookInfo= Global.database.loadEmployeeInfo(nameTF.getText());
                        LeftPanelUpdateEmployeeInformation.peopleID = (String) bookInfo[0][0];
                        LeftPanelUpdateEmployeeInformation.accountID = (String) bookInfo[0][1];

                        String roleIDget = (String)bookInfo[0][2] ;
                        if (roleIDget.equals("2")){
                          roleCB.setSelectedItem("Manager");
                        }
                        else if (roleIDget.equals("3")){
                            roleCB.setSelectedItem("General");
                        }

                        salaryTF.setText((String)bookInfo[0][3]);

                        btnUpdate.setEnabled(true);
                        btnDelete.setEnabled(true);
                      }
                      catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Book not found!", "Error", JOptionPane.WARNING_MESSAGE);
                      }
                    }
  							   });

      btnUpdate = new JButton("Update");
      btnUpdate.setBounds(300, 400, 200, 33);
      btnUpdate.setEnabled(true);
      btnUpdate.setForeground(Color.GREEN);
      add(btnUpdate);
      btnUpdate.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      try{
                        String roleIDfetch = "";
                        String roleCBText = roleCB.getSelectedItem().toString();
                        if (roleCBText.equals("Manager")){
                          roleIDfetch = "2";
                        }
                        else{
                          roleIDfetch = "3";
                        }

                        Global.gui.updateEmployee(LeftPanelUpdateEmployeeInformation.accountID,
                                                 roleIDfetch, salaryTF.getText());
                        JOptionPane.showMessageDialog(null, "Information Updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                      }
                      catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Employee not found!", "Error", JOptionPane.WARNING_MESSAGE);
                      }
                    }
  							   });

      btnDelete = new JButton("Delete Employee");
      btnDelete.setBounds(300, 400, 250, 33);
      btnDelete.setEnabled(true);
      btnDelete.setForeground(Color.RED);
      add(btnDelete);


}
}
