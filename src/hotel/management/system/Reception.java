package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
	
	JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12;
	Reception()
	{
		
		
		B1 = new JButton("New Customer Form");
		B1.setBounds(50,50,150,30);
		B1.setBackground(Color.BLACK);
		B1.setForeground(Color.WHITE);
		B1.addActionListener(this);
		add(B1);
		
		B2 = new JButton("Rooms");
		B2.setBounds(50,100,150,30);
		B2.setBackground(Color.BLACK);
		B2.setForeground(Color.WHITE);
		B2.addActionListener(this);
		add(B2);
		
		B3 = new JButton("Department");
		B3.setBounds(50,150,150,30);
		B3.setBackground(Color.BLACK);
		B3.setForeground(Color.WHITE);
		B3.addActionListener(this);
		//add(B3);
		
		B4 = new JButton("All Employee");
		B4.setBounds(50,200,150,30);
		B4.setBackground(Color.BLACK);
		B4.setForeground(Color.WHITE);
		B4.addActionListener(this);
		add(B4);
		
		B5 = new JButton("Customer info");
		B5.setBounds(50,250,150,30);
		B5.setBackground(Color.BLACK);
		B5.setForeground(Color.WHITE);
		B5.addActionListener(this);
		add(B5);
		
		B6 = new JButton("Manager info");
		B6.setBounds(50,300,150,30);
		B6.setBackground(Color.BLACK);
		B6.setForeground(Color.WHITE);
		B6.addActionListener(this);
		add(B6);
		
		B7 = new JButton("Check out");
		B7.setBounds(50,350,150,30);
		B7.setBackground(Color.BLACK);
		B7.setForeground(Color.WHITE);
		B7.addActionListener(this);
		add(B7);
		
		B8 = new JButton("Update Status");
		B8.setBounds(50,400,150,30);
		B8.setBackground(Color.BLACK);
		B8.setForeground(Color.WHITE);
		B8.addActionListener(this);
		//add(B8);
		
		B9 = new JButton("Update Room Status");
		B9.setBounds(50,450,150,30);
		B9.setBackground(Color.BLACK);
		B9.setForeground(Color.WHITE);
		B9.addActionListener(this);
		add(B9);
		
		B10 = new JButton("Pick up services");
		B10.setBounds(50,400,150,30);
		B10.setBackground(Color.BLACK);
		B10.setForeground(Color.WHITE);
		B10.addActionListener(this);
		add(B10);
		
		B11= new JButton("Search Rooms");
		B11.setBounds(50,150,150,30);
		B11.setBackground(Color.BLACK);
		B11.setForeground(Color.WHITE);
		B11.addActionListener(this);
		add(B11);
		
		B12 = new JButton("Log out");
		B12.setBounds(50,500,150,30);
		B12.setBackground(Color.BLACK);
		B12.setForeground(Color.WHITE);
		B12.addActionListener(this);
		add(B12);
		
		ImageIcon i1=new ImageIcon("Icons/fourth.jpg");
		Image i3=i1.getImage().getScaledInstance(600, 550,Image.SCALE_DEFAULT);
		ImageIcon i4= new ImageIcon(i3);
		JLabel i2 = new JLabel(i4);
		
		i2.setBounds(250,50,600,550);
		add(i2);
		
		setLayout(null);
		setBounds(200,100,900,700);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Reception();
	}

	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==B1)
		{
			setVisible(false);
			new Addnewcustomer();
			
		}
		if(e.getSource()==B2)
		{
			setVisible(false);
			new Room();
		}
		if(e.getSource()==B3)
		{
			
		}
		
		if(e.getSource()==B4)
		{
			setVisible(false);
			new Employee();
		}
		if(e.getSource()==B5)
		{
			setVisible(false);
			new CustomerInfo();
		}
		if(e.getSource()==B6)
		{
			setVisible(false);
			new ManagerInfo();
		}
		if(e.getSource()==B7)
		{
			setVisible(false);
			new CheckOut();
		}
		if(e.getSource()==B8)
		{
			
		}
		if(e.getSource()==B9)
		{
			setVisible(false);
			new UpdateRoom();
		}
		if(e.getSource()==B10)
		{
			setVisible(false);
			new PickUp();
		}
		if(e.getSource()==B11)
		{
			setVisible(false);
			new Roomsearch();
		}
		if(e.getSource()==B12)
		{
			setVisible(false);
			new Dashboard();
		}
		
	}

}
