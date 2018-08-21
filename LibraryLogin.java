import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class LibraryLogin extends JFrame implements ActionListener{

	JButton btnLogin, btnExit;

	JPanel MainPanel;

	TopPanelLogin topPanelLogin;
	LeftPanel leftPanel;
	RightPanelReg rightPanelReg;

  	public LibraryLogin(){
		super("Login Window");

		this.setSize(1280, 730);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel = new JPanel();
		MainPanel.setLayout(null);


		topPanelLogin = new TopPanelLogin();
		leftPanel= new LeftPanel();
		rightPanelReg= new RightPanelReg();


		MainPanel.add(topPanelLogin);
		this.add(MainPanel);
		this.setResizable(false);

		MainPanel.add(leftPanel);
		this.add(MainPanel);
		this.setResizable(false);

		MainPanel.add(rightPanelReg);
		this.add(MainPanel);
		this.setResizable(false);
	}

/*public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}*/

public void actionPerformed(ActionEvent ae)
	{
		String str = ae.getActionCommand();
		if(str.equals(btnLogin.getText()))
		{}
		else if(str.equals(btnExit.getText()))
		{
			System.exit(0);
		}
		else{}
	}
}
