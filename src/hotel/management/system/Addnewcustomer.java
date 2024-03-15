package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Addnewcustomer extends JFrame implements ActionListener{
	JLabel l1,l2,l10,l3,l5,l6,l7,l8,l9,l4;
	JButton Addcustomer,Back;
	JTextField Number,Name,Country,Deposit,Member;
	JRadioButton Male,Female;
	Choice c1;
	JComboBox  comboBox;
	JTextField Date;
	Addnewcustomer()
	{
		comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(250, 50, 200, 30);
		comboBox.setBackground(Color.WHITE);
		add(comboBox);
		
		
		c1 = new Choice();
		c1.setBounds(250,300,200,30);
		add(c1);
		
		try 
		{
			conn c = new conn();
			String q = "Select * from addrooms where available = 'Available'";
			ResultSet rs = c.s.executeQuery(q); 
			
			while(rs.next())
				{
					c1.add(rs.getString("Number"));			
				}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		Date date = new Date();
		 Date = new JTextField(""+date);
		Date.setBounds(250,350,200,30);
		add(Date);
		
		
		
		Male=new JRadioButton("Male");
		Male.setBounds(250,200,100,30);
		add(Male);
		
		Female=new JRadioButton("Female");
		Female.setBounds(350,200,100,30);
		add(Female);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(Male);
		bg.add(Female);
		
		Number = new JTextField();
		Number.setBounds(250,100,200,30);
		add(Number);
		
		Name = new JTextField();
		Name.setBounds(250,150,200,30);
		add(Name);
		
		Country = new JTextField();
		Country.setBounds(250,250,200,30);
		add(Country);
		
		Deposit = new JTextField();
		Deposit.setBounds(250,400,200,30);
		add(Deposit);
		
		Member = new JTextField();
		Member.setBounds(250,450,200,30);
		add(Member);
		
		l1=new JLabel("New Customer Form");
		l1.setBounds(200,10,400,30);
		l1.setFont(new Font("",Font.BOLD,30));
		add(l1);
		
		l2=new JLabel("Id :");
		l2.setBounds(50,50,150,30);
		l2.setFont(new Font("",Font.PLAIN,15));
		add(l2);
		
		l3=new JLabel("Number :");
		l3.setBounds(50,100,150,30);
		l3.setFont(new Font("",Font.PLAIN,15));
		add(l3);
		
		l4=new JLabel("Name :");
		l4.setBounds(50,150,150,30);
		l4.setFont(new Font("",Font.PLAIN,15));
		add(l4);
		
		l5=new JLabel("Gender :");
		l5.setBounds(50,200,150,30);
		l5.setFont(new Font("",Font.PLAIN,15));
		add(l5);
		
		l6=new JLabel("Country :");
		l6.setBounds(50,250,150,30);
		l6.setFont(new Font("",Font.PLAIN,15));
		add(l6);
		
		l7=new JLabel("Alloceted Room No. :");
		l7.setBounds(50,300,150,30);
		l7.setFont(new Font("",Font.PLAIN,15));
		add(l7);
		
		l8=new JLabel("Check-in Time :");
		l8.setBounds(50,350,150,30);
		l8.setFont(new Font("",Font.PLAIN,15));
		add(l8);
		
		l9=new JLabel("Deposit :");
		l9.setBounds(50,400,150,30);
		l9.setFont(new Font("",Font.PLAIN,15));
		add(l9);
		
		l10=new JLabel("Number Of Member :");
		l10.setBounds(50,450,150,30);
		l10.setFont(new Font("",Font.PLAIN,15));
		add(l10);
		
		Addcustomer =new JButton("Add Customer");
		Addcustomer.setBounds(50,500,150,40);
		Addcustomer.setBackground(Color.BLACK);
		Addcustomer.setForeground(Color.WHITE);
		Addcustomer.addActionListener(this);
		add(Addcustomer);
		
		Back =new JButton("Back");
		Back.setBounds(250,500,150,40);
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.WHITE);
		Back.addActionListener(this);
		add(Back);
		
		ImageIcon i1=new ImageIcon("Icons/fifth.png");
		Image i2= i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500,50,400,400);
		add(image);
		
		setLayout(null);
		setBounds(100,100,900,600);
		setVisible(true);

		
	}

	public static void main(String[] args) {

		new Addnewcustomer();
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Back)
		{
			setVisible(false);
			new Reception();
		}
		if(e.getSource()==Addcustomer)
		{
			try 
			{
				String number=Number.getText();
				String name=Name.getText();
				String country=Country.getText();
				String deposit=Deposit.getText();
				String member=Member.getText();
				String id=(String)comboBox.getSelectedItem();
				String gender=null;
				String Room=(String)c1.getSelectedItem();
				String date = Date.getText();
				
				 
				if(number.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"Enter Id No.");
	                return;
	            }
				if(Room.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"No room Available");
	                return;
	            }
				if(name.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"Enter Name");
	                return;
	            }
				if(country.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"Enter Coutry");
	                return;
	            }
				if(deposit.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"Deposit is compalsary");
	                return;
	            }
				if(member.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"Enter Number Of Members");
	                return;
	            }
				
				if(id=="Aadhar Card") 
				{
				 for(int i=0 ;i<=number.length()-1;i++)
		            {
		            	if(number.charAt(i)>='0' && number.charAt(i)<='9')
		            	{
		            		continue;
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(null,"Check Aadhar Id Number");
		            		return;
		            	}
		            	
		            }
				 if(number.length() <12)
		            {
		                JOptionPane.showMessageDialog(null,"Enter Full Adhar Number");
		                return;
		            }
				}
				
				 for(int i=0 ;i<=deposit.length()-1;i++)
		            {
		            	if(deposit.charAt(i)>='0' && deposit.charAt(i)<='9')
		            	{
		            		continue;
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(null,"Check deposit Amount");
		            		return;
		            	}
		            }
				if(id=="Driving license") 
				{
				 for(int i=0 ;i<=number.length()-1;i++)
		            {
		            	if((number.charAt(i)>='0' && number.charAt(i)<='9')||( number.charAt(i)<='A'&& number.charAt(i)<='Z'))
		            	{
		            		continue;
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(null,"Check licence Number");
		            		return;
		            	}
		            }
				}
				
				if(id=="Voter Id") 
				{
				 for(int i=0 ;i<=number.length()-1;i++)
		            {
		            	if((number.charAt(i)>='0' && number.charAt(i)<='9')||( number.charAt(i)<='A'&& number.charAt(i)<='Z'))
		            	{
		            		continue;
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(null,"Check Voter Id");
		            		return;
		            	}
		            }
				}
				
				if(id=="Passport") 
				{
				 for(int i=0 ;i<=number.length()-1;i++)
		            {
		            	if((number.charAt(i)>='0' && number.charAt(i)<='9')||( number.charAt(i)<='A'&& number.charAt(i)<='Z'))
		            	{
		            		continue;
		            	}
		            	else {
		            		JOptionPane.showMessageDialog(null,"Check Passport Id");
		            		return;
		            	}
		            }
				}
				for(int i=0 ;i<=(name.length())-1;i++)
	            {
	            	if((name.charAt(i)>='a' && name.charAt(i)<='z')|| (name.charAt(i)>='A' && name.charAt(i)<='Z')||name.charAt(i)==' ')
	            	{
	            		continue;
	            	}
	            	
	            	else {
	            		JOptionPane.showMessageDialog(null,"Number and simbles are not Allowed in Name");
	            		return;
	            	}
	            }
				
				if(Male.isSelected()) 
				{
					gender="Male";
				}
				if(Female.isSelected()) 
				{
					gender="Female";
				}
				if(!Male.isSelected() && !Female.isSelected()) 
	            {
	                JOptionPane.showMessageDialog(null,"Select Gender");
	                return;
	            }
				conn c =new conn();
				String Str="Insert into Customers values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+Room+"','"+date+"','"+deposit+"','"+member+"')";
				String Str1="update Addrooms set Available = 'Occupied' where Number ="+Room;
				c.s.executeUpdate(Str);
				c.s.executeUpdate(Str1);

				JOptionPane.showMessageDialog(null,"Customer Added successfully");
				setVisible(false);
				new Reception();
				
			}
			catch(Exception e1)
			{
				System.out.println(e);
			}
			
			
		}
	}

}
