import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class TopPanel extends JPanel implements ActionListener{

  JLabel titleT1, colorLabelT1;
//  JComboBox comboBoxT1;



  public TopPanel(){
    super();
    setBounds(0, 0, 1280, 100);
    setLayout(null);

    Font f4 = new Font("Cambria",Font.BOLD, 28);


    titleT1 = new JLabel("Welcome to AIUB Library System");
    titleT1.setForeground(Color.WHITE);
    titleT1.setBounds(800, 20, 450, 30);
    titleT1.setFont(f4);
    add(titleT1);

    colorLabelT1 = new JLabel();
    colorLabelT1.setBounds(0, 0, 1280, 100);
    colorLabelT1.setBackground(new Color(127,86,68));
    colorLabelT1.setOpaque(true);
    add(colorLabelT1);

  }
  public void actionPerformed(ActionEvent ae){}
}
