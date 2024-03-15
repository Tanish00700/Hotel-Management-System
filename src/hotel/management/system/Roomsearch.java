package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Roomsearch extends JFrame{
	JComboBox c1,c2,c3;
	JTable Table;
	JLabel L1,L2,L3,L4,L5;
	Roomsearch()
	{
		L1 = new JLabel("Bed Type");
		L1.setBounds(190, 180,100,20);
		add(L1);
		
		L2 = new JLabel("Price");
		L2.setBounds(370, 180, 100, 20);
		add(L2);
		
		L3 = new JLabel("Available");
		L3.setBounds(550,180, 100,20);
		add(L3);
		
		L5 = new JLabel("Clean Status");
		L5.setBounds(730, 180, 100, 20);
		add(L5);

		
		L4 = new JLabel("Room Number");
		L4.setBounds(0,180, 100, 20);
		add(L4);
		
		JLabel J1 = new JLabel("Search Room");
		J1.setBounds(300,5,200,30);
		J1.setFont(new Font("",Font.BOLD,30));
		add(J1);
		
		Table=new JTable();
		Table.setBounds(0,200,900,300);
		add(Table);
		
		JLabel J2 =new JLabel("Room bed Type :");
		J2.setBounds(50,40,150,30);
		add(J2);
		
		String St[] = {"Single","Double"};
		c1= new JComboBox(St);
		c1.setBounds(200,40,150,30);
		add(c1);
		
		String St1[] = {"Available","Occupied"};
		c2= new JComboBox(St1);
		c2.setBounds(400,40,150,30);
		add(c2);
		
		String St2[] = {"Clean","Not Clean"};
		c3= new JComboBox(St2);
		c3.setBounds(600,40,150,30);
		add(c3);
		
		JButton B1 = new JButton("Load Data");
		B1.setBounds(300,100,150,30);
		B1.setBackground(Color.BLACK);
		B1.setForeground(Color.WHITE);
		add(B1);
		
		JButton B2 = new JButton("Cancel");
		B2.setBounds(600,510,150,30);
		B2.setBackground(Color.BLACK);
		B2.setForeground(Color.WHITE);
		add(B2);
		B2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Reception();
			}
			
			
		
		});
		
		JButton B3 = new JButton("Show all");
		B3.setBounds(500,100,150,30);
		B3.setBackground(Color.BLACK);
		B3.setForeground(Color.WHITE);
		add(B3);
		B3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try 
				{
					conn c = new conn();
					String displayCustomersql = "select * from Addrooms";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					Table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e2)
				{
					System.out.print(e2);
				}
				
			}
		});;
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String s1 = (String)c1.getSelectedItem();
					String s2 = (String)c2.getSelectedItem();

					String s3 = (String)c3.getSelectedItem();

                                    conn c = new conn();
					String displayCustomersql = "select * from Addrooms where bed ='"+s1+"'&& clean='"+s3+"'&& Available='"+s2+"'";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					Table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
	
		
		
		
		
		setLayout(null);
		setBounds(100,100,900,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		new Roomsearch();
	}

}
