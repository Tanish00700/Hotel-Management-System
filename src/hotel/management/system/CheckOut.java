package hotel.management.system;
import java.awt.*;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;

public class CheckOut extends JFrame{
	
	 
     Choice c1,t1;

	public static void main(String[] args) {
		new CheckOut();
	}
	
	public CheckOut() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon(("Icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel L1 = new JLabel("Check Out ");
		L1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		L1.setBounds(70, 11, 140, 35);
		add(L1);
		
		JLabel L2 = new JLabel("Number :");
		L2.setBounds(20, 85, 80, 14);
		add(L2);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customers");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		add(c1);
                
                ImageIcon i4 = new ImageIcon(("Icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                l2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                        try{
                            
                            conn c = new conn();
                            String number = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from customers where number = '"+number+"'");
                            
                            if(rs.next()){
                           	t1.add(rs.getString("room"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		JLabel L3 = new JLabel("Room Number:");
		L3.setBounds(20, 132, 86, 20);
		add(L3);
		
		t1 = new Choice();
        t1.setBounds(130, 132, 150, 20);
		add(t1);
               
		JButton B1 = new JButton("Check Out");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = c1.getSelectedItem();
                String s1 = t1.getSelectedItem();
				String deleteSQL = "Delete from customers where number = '"+id+"';";
                String q2 = "update Addrooms set Available = 'Available' where Number = "+s1+";";
	    		try{
	    			
	    			conn c = new conn();
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		B1.setBounds(50, 200, 100, 25);
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
		add(B1);		
		JButton B2 = new JButton("Back");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		B2.setBounds(160, 200, 100, 25);
        B2.setBackground(Color.BLACK);
        B2.setForeground(Color.WHITE);
		add(B2);
                
                
        setBackground(Color.WHITE);
        setVisible(true);
	}

}