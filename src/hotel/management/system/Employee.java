package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Employee extends JFrame{
	JLabel j1,j2,j3,j4,j5,j6,j7,j8;
	Employee()
	{
		setLayout(null);
		j1=new JLabel("Name");
		j1.setBounds(0,80,150,30);
		add(j1);
		
		j2=new JLabel("Age");
		j2.setBounds(120,80,150,30);
		add(j2);
		
		j3=new JLabel("Gender");
		j3.setBounds(240,80,150,30);
		add(j3);
		
		j4=new JLabel("Post");
		j4.setBounds(360,80,150,30);
		add(j4);
		
		j5=new JLabel("Salary");
		j5.setBounds(480,80,150,30);
		add(j5);
		
		j6=new JLabel("Phone No.");
		j6.setBounds(600,80,150,30);
		add(j6);
		
		j7=new JLabel("Adhar No.");
		j7.setBounds(720,80,150,30);
		add(j7);
		
		j8=new JLabel("G-Mail");
		j8.setBounds(840,80,150,30);
		add(j8);
		
		
		
		ImageIcon i1= new ImageIcon("Icons/tenth.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(00,280,900,400);
		add(l1);
		
		final JTable jt = new JTable();
		jt.setBounds(0,110,900,200);
		add(jt);
		
		JButton B1 = new JButton(" Show Employee");
		B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
        B1.setBounds(200,20,150,30);
        add(B1);
        
        JButton B2 = new JButton("Back");
		B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
        B2.setBounds(600,20,100,30);
        add(B2);
        B2.addActionListener(new ActionListener() 
        {
        
			public void actionPerformed(ActionEvent e) 
			{
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
      
		B1.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					conn c= new conn();
					String str = "Select * from Addemployee";
					ResultSet rs =c.s.executeQuery(str);
					jt.setModel(DbUtils.resultSetToTableModel(rs));

					
					
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
				});
		
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(200,100,900,600);
		setVisible(true);
		
	}

	public static void main(String[] args) {

		new Employee();
	}

}
