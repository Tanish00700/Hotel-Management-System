package hotel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {
PreparedStatement pst = null;
	 JPanel contentPane;
	 JTextField txt_ID;
	 JTextField txt_Ava;
	 JTextField txt_Status;
	 JTextField txt_Room;
     Choice c1;

	public static void main(String[] args) {
		new UpdateRoom();
		
	}
	
	

	
	UpdateRoom(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(530, 200, 1000, 450);
                
                ImageIcon i1  = new ImageIcon(("Icons/seventh.jpg"));
                Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,80,600,250);
                add(l1);
		
		JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		add(lblUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customers");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		add(c1);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		add(lblCleanStatus);
		
		
		txt_Ava = new JTextField();
		txt_Ava.setBounds(160, 184, 140, 20);
		add(txt_Ava);
		txt_Ava.setColumns(10);
		
		txt_Status = new JTextField();
		txt_Status.setBounds(160, 237, 140, 20);
		add(txt_Status);
		txt_Status.setColumns(10);
                
                txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		add(txt_Room);
		txt_Room.setColumns(10);
                
                JButton b1 = new JButton("Check");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                                String s1 = c1.getSelectedItem();
				conn c = new conn();
                                ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);
                                
                                while(rs1.next()){
                                    txt_Room.setText(rs1.getString("room_number"));    
                                }
                            }catch(Exception ee){}
                            try{
                                conn c  = new conn();
                                ResultSet rs2 = c.s.executeQuery("select * from Addrooms where Number = "+txt_Room.getText());
                                while(rs2.next()){
                                    txt_Ava.setText(rs2.getString("availability")); 
                                    txt_Status.setText(rs2.getString("clean_status"));
                                }
                            }catch(Exception ee){}
                        }
		});
		b1.setBounds(120, 315, 89, 23);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		add(b1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				
				try{
                                    conn c = new conn();
                                    String str = "update Addrooms set clean = '"+txt_Status.getText()+"' where Number = "+txt_Room.getText();
                                    c.s.executeUpdate(str);
                                    JOptionPane.showMessageDialog(null, "Update Sucessful");
                                    
                                    new Reception().setVisible(true);
                                    setVisible(false);
				}catch (Exception ee){
					ee.printStackTrace();
				}
				
			
			}
		});
		btnUpdate.setBounds(60, 355, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		add(btnUpdate);
		
		JButton Exit = new JButton("Back");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		Exit.setBounds(180, 355, 89, 23);
        Exit.setBackground(Color.BLACK);
        Exit.setForeground(Color.WHITE);
		add(Exit);
		
		JLabel lblRoomId = new JLabel("Room Number:");
		lblRoomId.setBounds(27, 133, 100, 14);
		add(lblRoomId);
		
		setVisible(true);
		setBackground(Color.WHITE);
	}

}