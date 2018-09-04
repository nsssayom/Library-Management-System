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

public class LeftPanelAddNewEmployee extends LeftPanel implements ActionListener{

 JLabel addNewEmpLabel,nameLabel,roleLabel, phoneLabel,emailLabel, addressLabel, salaryLabel,userNameLabel, passLabel;
 JTextField nameTF, phoneTF,emailTF, addressTF, salaryTF,roleTF,userNameTF;
 JPasswordField passTF;
 JButton btnAdd;
 JComboBox roleCB;

  public LeftPanelAddNewEmployee(){
      super();
      setBounds(0, 0 , 900, 800);
      setLayout(null);

      Font f2 = new Font("Cambria",Font.BOLD, 20);
      Font f4= new Font("Cambria",Font.BOLD, 17);

      addNewEmpLabel = new JLabel("Add New Employee");
      addNewEmpLabel.setBounds(140, 160,200, 30);
      addNewEmpLabel.setFont(f2);
      add(addNewEmpLabel);

      nameLabel = new JLabel("Name");
      nameLabel.setBounds(150, 230, 150, 30);
      nameLabel.setFont(f4);
      add(nameLabel);

      emailLabel = new JLabel("E-mail");
      emailLabel.setBounds(150, 280, 150, 30);
      emailLabel.setFont(f4);
      add(emailLabel);

      phoneLabel = new JLabel("Phone Number");
      phoneLabel.setBounds(150,330,150, 30);
      phoneLabel.setFont(f4);
      add(phoneLabel);

      addressLabel = new JLabel("Address");
      addressLabel.setBounds(150, 380,100, 30);
      addressLabel.setFont(f4);
      add(addressLabel);

      salaryLabel = new JLabel("Salary");
      salaryLabel.setBounds(150, 430,100, 30);
      salaryLabel.setFont(f4);
      add(salaryLabel);

      roleLabel = new JLabel("Role");
      roleLabel.setBounds(150, 480,100, 30);
      roleLabel.setFont(f4);
      add(roleLabel);

      userNameLabel = new JLabel("User Name");
      userNameLabel.setBounds(150, 540,100, 30);
      userNameLabel.setFont(f4);
      add(userNameLabel);

      passLabel = new JLabel("Password");
      passLabel.setBounds(150, 590,100, 30);
      passLabel.setFont(f4);
      add(passLabel);

      nameTF = new JTextField();
      nameTF.setBounds(300, 230, 200, 30);
      add(nameTF);

      emailTF = new JTextField();
      emailTF.setBounds(300, 280, 200, 30);
      add(emailTF);

      phoneTF = new JTextField();
      phoneTF.setBounds(300, 330, 200, 30);
      add(phoneTF);


      addressTF = new JTextField();
      addressTF.setBounds(300, 380, 200, 30);
      add(addressTF);

      salaryTF = new JTextField();
      salaryTF.setBounds(300, 430, 200, 30);
      add(salaryTF);

      String []comboItems = {"General", "Manager"};
      roleCB = new JComboBox(comboItems);
      roleCB.setBounds(300, 480, 200, 30);
      add(roleCB);

      userNameTF = new JTextField();
      userNameTF.setBounds(300, 540, 200, 30);
      add(userNameTF);

      passTF = new JPasswordField();
      passTF.setBounds(300, 590, 200, 30);
      add(passTF);

      btnAdd = new JButton("Add");
      btnAdd.setBounds(150, 650, 100, 33);
      add(btnAdd);
      btnAdd.addActionListener(new ActionListener() {
  							    @Override
  							    public void actionPerformed(ActionEvent evt) {
                      String name = nameTF.getText();
                      String email = emailTF.getText();
                      String phone = phoneTF.getText();
                      String address = addressTF.getText();
                      String userName = userNameTF.getText();
                      String password = new String (passTF.getPassword());
                      String salary =  salaryTF.getText();
                      String roleID = "";
                      if (roleCB.getSelectedItem().toString().equals("Manager")){
                          roleID = "2";
                      }
                      else{
                        roleID = "3";
                      }

  							      Global.database.signUp(name, "", email, phone, address, userName, password, roleID, salary);
                      JOptionPane.showMessageDialog(null, "New employee Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
  							    }
  							});
    }
  }
