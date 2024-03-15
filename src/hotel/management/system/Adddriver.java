package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.regex.Pattern;

import javax.swing.*;

public class Adddriver extends JFrame implements ActionListener
{
	JButton b1,b2;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JRadioButton Male,Female;
	JComboBox c1;
	
	Adddriver()
	{
		l1 =new JLabel("Add Driver");
		l1.setBounds(300,10,300,30);
		l1.setFont(new Font("",Font.BOLD,30));
		add(l1);
		
		l2=new JLabel("Name :");
		l2.setBounds(50,60,150,30);
		l2.setFont(new Font("",Font.PLAIN,15));
		add(l2);
		
		l3=new JLabel("Age :");
		l3.setBounds(50,120,150,30);
		l3.setFont(new Font("",Font.PLAIN,15));
		add(l3);
		
		l4=new JLabel("Gender :");
		l4.setBounds(50,180,150,30);
		l4.setFont(new Font("",Font.PLAIN,15));
		add(l4);
		
		l5=new JLabel("Car Company :");
		l5.setBounds(50,240,150,30);
		l5.setFont(new Font("",Font.PLAIN,15));
		add(l5);
		
		l6=new JLabel("Car Model :");
		l6.setBounds(50,300,150,30);
		l6.setFont(new Font("",Font.PLAIN,15));
		add(l6);
		
		l7=new JLabel("Available :");
		l7.setBounds(50,360,150,30);
		l7.setFont(new Font("",Font.PLAIN,15));
		add(l7);
		
		l8=new JLabel("Location :");
		l8.setBounds(50,420,150,30);
		l8.setFont(new Font("",Font.PLAIN,15));
		add(l8);
		
		b1 = new JButton("Sumit");
		b1.setBounds(60, 475, 100,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(200, 475, 100,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		tf1 =new JTextField();
		tf1.setBounds(180,60,150,30);
		add(tf1);
		
		tf2 =new JTextField();
		tf2.setBounds(180,120,150,30);
		add(tf2);
		
		tf3 =new JTextField();
		tf3.setBounds(180,240,150,30);
		add(tf3);
		
		tf4 =new JTextField();
		tf4.setBounds(180,300,150,30);
		add(tf4);
		
		tf5 =new JTextField();
		tf5.setBounds(180,420,150,30);
		add(tf5);
		
		Male = new JRadioButton("MALE");
        Male.setBackground(Color.WHITE);
        Male.setBounds(180, 180,60, 30);
        add(Male);

        Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(250, 180, 80, 30);
        add(Female);

        ButtonGroup bg =new ButtonGroup();
        bg.add(Male);
        bg.add(Female);
        
        String course[] = {"Avalable","Not Avalable"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(180,360,150,30);
        add(c1);
        
		ImageIcon i1= new ImageIcon("Icons/eleven.jpg");
		Image i3 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
		ImageIcon i4 =new ImageIcon(i3);
		JLabel i2 = new JLabel(i4);
		i2.setBounds(350,80,500,400);
		add(i2);
		
		
		setLayout(null);
		setBounds(100,100,900,600);
		setVisible(true);
        getContentPane().setBackground(Color.WHITE);
	}

	public static void main(String[] args)
	{
		new Adddriver();
	}

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1) 
		{
			try 
			{
				String name = tf1.getText();
				String age = tf2.getText();
				String carcom = tf3.getText();
				String carMod = tf4.getText();
				String location = tf5.getText();
				String Available = (String) c1.getSelectedItem();
				String Gender = null;
				 for(int i=0 ;i<=(age.length())-1;i++)
		            {
		            	if(age.charAt(i)>='0' && age.charAt(i)<='9')
		            	{
		            		continue;
		            	}
		            	else 
		            	{
		            		JOptionPane.showMessageDialog(null,"Enter Valid age");
		            		return;
		            	}
		            }
				 
				 if(Pattern.matches("\\D*",name))
				 {
					 
				 }
				 
				 if(name.equals(""))
				 {
		                JOptionPane.showMessageDialog(null,"enter Name");
		                return;
		         }
		            if(age.equals(""))
		            {
		                JOptionPane.showMessageDialog(null,"enter Age");
		                return;
		            }
		            if(location.equals(""))
		            {
		                JOptionPane.showMessageDialog(null,"enter Location");
		                return;
		            }
		            if(carMod.equals(""))
		            {
		                JOptionPane.showMessageDialog(null,"enter Car Model");
		                return;
		            }
		            if(carcom.equals(""))
		            {
		                JOptionPane.showMessageDialog(null,"enter Car Company");
		                return;
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
		            
				if(Male.isSelected()){
	                Gender = "male";
	            
	            }else if(Female.isSelected()){
	                Gender = "female";
	            }
				
				conn c=new conn();
				String src="Insert into Adddriver values ('"+name+"','"+age+"','"+Gender+"','"+carcom+"','"+carMod+"','"+Available+"','"+location+"')";
				c.s.executeUpdate(src);
				JOptionPane.showMessageDialog(null,"Driver Added");
                setVisible(false);
                new Dashboard();
				
			}
			catch(Exception e1)
			{
				System.out.print(e1);
			}
		}
		if(e.getSource()==b2)
		{
			setVisible(false);
			new Dashboard();
			
		}
	}
}
	

