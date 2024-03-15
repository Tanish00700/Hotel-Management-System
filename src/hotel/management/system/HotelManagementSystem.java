package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

        
        
        public HotelManagementSystem() {
		
                          
                setLayout(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);
                setBounds(100,100,1366,430);

               
                 JButton b1 = new JButton("Next");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                
                
                ImageIcon i1  = new ImageIcon("icons/first.jpg");
                //Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
                //ImageIcon i2 = new ImageIcon(i3);
                JLabel l2 = new JLabel(i1);
                add(l2);
                
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(30,300,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,50));
                lid.setForeground(Color.red);
                l2.add(lid);
                
                b1.setBounds(1170,325,150,50);
                l2.setBounds(00,00, 1366, 430);
                
                l2.add(b1);
                
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                
                setVisible(false);
                new Login();
                
        }
        
        public static void main(String[] args) {
                new HotelManagementSystem();
               			
	}
}