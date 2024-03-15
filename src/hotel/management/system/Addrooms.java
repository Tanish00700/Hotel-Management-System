package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Addrooms extends JFrame implements ActionListener{
	
	JTextField tf1,tf2;
	JButton b1,b2;
	JComboBox  c1,c2,c3;
	Addrooms(){
		
		setBounds(200,150,900,600);
		setLayout(null);
		
		JLabel l1 = new JLabel("Add Rooms");
		l1.setBounds(150,40,300,35);
		l1.setFont(new Font("",Font.BOLD,30));
		add(l1);
		
		JLabel l2 = new JLabel("Room Number:");
		l2.setBounds(50, 100, 150, 30);
		l2.setFont(new Font("",Font.PLAIN,20));

		add(l2);
		
		JLabel l3 = new JLabel("Avalable:");
		l3.setBounds(50, 160, 150, 30);
		l3.setFont(new Font("",Font.PLAIN,20));

		add(l3);
		
		JLabel l4 = new JLabel(" Clean Status:");
		l4.setBounds(50, 220, 150, 30);
		l4.setFont(new Font("",Font.PLAIN,20));

		add(l4);
		
		JLabel l5 = new JLabel("Price:");
		l5.setBounds(50, 280, 150, 30);
		l5.setFont(new Font("",Font.PLAIN,20));

		add(l5);
		
		JLabel l6 = new JLabel("Bed Type:");
		l6.setBounds(50, 340, 150, 30);
		l6.setFont(new Font("",Font.PLAIN,20));
		add(l6);
		
		ImageIcon i1 = new ImageIcon("Icons/twelve.jpg");
		Image i3 = i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
		JLabel l7 = new JLabel(i2);
		l7.setBounds(450,50,400,400);
		add(l7);
		
		tf1 = new JTextField();
		tf1.setBounds(200,100,200,30);
		add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(200,280,200,30);
		add(tf2);
		
		b1 = new JButton("Add Room");
		b1.setBounds(50,450,100,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(200,450,100,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		String course[] = {"Available","Occupied"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,160,200,30);
        add(c1);
        
        String course1[] = {"Clean","Not Clean"};
        c2 = new JComboBox(course1);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200,220,200,30);
        add(c2);
        
        String course2[] = {"Single","Double"};
        c3 = new JComboBox(course2);
        c3.setBackground(Color.WHITE);
        c3.setBounds(200,340,200,30);
        add(c3);
	
		
		
		setVisible(true);


		
		
	}
	
	

	public static void main(String[] args) {
		
		new Addrooms();
	}



	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			String Room = tf1.getText();
			String price = tf2.getText();
			String Available = (String) c1.getSelectedItem();
			String bed = (String) c3.getSelectedItem();
			String clean = (String) c2.getSelectedItem();
			
			 for(int i=0 ;i<=(Room.length())-1;i++)
	            {
	            	if(Room.charAt(i)>='0' && Room.charAt(i)<='9')
	            	{
	            		continue;
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null,"Check Room number");
	            		return;
	            	}
	            }
			
			if(Room.equals(""))
			 {
	                JOptionPane.showMessageDialog(null,"enter Room Number");
	                return;
	         }
	            if(price.equals(""))
	            {
	                JOptionPane.showMessageDialog(null,"enter Price");
	                return;
	            }
	            for(int i=0 ;i<=(price.length())-1;i++)
	            {
	            	if(price.charAt(i)>='0' && price.charAt(i)<='9')
	            	{
	            		continue;
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null,"Check Room Price");
	            		return;
	            	}
	            }
			
			try
			{
				String str= "Insert into Addrooms values('"+Room+"','"+bed+"','"+price+"','"+Available+"','"+clean+"')";
				conn c = new conn();
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Room Added");
                setVisible(false);
                new Dashboard();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}

		if(e.getSource()==b2)
		{
			
			setVisible(false);
			new Dashboard();
		}
	}
	
}



