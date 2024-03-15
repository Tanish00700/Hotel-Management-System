package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
	JMenuItem Addemp,Addroom,Adddriver,Reception;
	Dashboard()
	{
		setBounds(0, 0, 1550, 1000);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("icons/third.jpg");
		//Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		//ImageIcon i3 = new ImageIcon(i2);
		JLabel Image = new JLabel(i1);
		add(Image);
		Image.setBounds(0,0,1550,1000);
		
		JLabel L1 = new JLabel("The Taj Hotel Welcomes You");
		L1.setBounds(400,80,1000,70);
		Image.add(L1);
		L1.setFont(new Font("",Font.BOLD,60));
		L1.setForeground(Color.WHITE);
		
		JMenuBar Bar = new JMenuBar();
		Bar.setBounds(0,0,1550,40);
		Image.add(Bar);
		Bar.setBackground(Color.BLACK);
		
		JMenu Hotel = new JMenu("HOTEL MANAGEMENT");
		Bar.add(Hotel);
		Hotel.setForeground(Color.white);
		Hotel.setFont(new Font("",Font.BOLD,15));
		
		JMenu Admin = new JMenu("ADMIN");
		Bar.add(Admin);
		Admin.setForeground(Color.white);
		Admin.setFont(new Font("",Font.BOLD,15));
		
		Reception = new JMenuItem("Reception");
		Reception.addActionListener(this);

		Hotel.add(Reception);
		
		 Addroom = new JMenuItem("Add Room");
		 Addroom.addActionListener(this);

		Admin.add(Addroom);
		
		Adddriver = new JMenuItem("Add Driver");
		Adddriver.addActionListener(this);
		Admin.add(Adddriver);
		
		Addemp = new JMenuItem("Add Employee");
		Admin.add(Addemp);
		Addemp.addActionListener(this);
		
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new Dashboard();
		
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Addemp)
		{
			setVisible(true);
			new AddEmployee();
		}
		if(e.getSource()==Addroom)
		{
			setVisible(true);
			new Addrooms();
		}
		if(e.getSource()==Adddriver)
		{
			setVisible(true);
			new Adddriver();
		}
		if(e.getSource()==Reception)
		{
			setVisible(true);
			new Reception();
		}
		
	}

}
