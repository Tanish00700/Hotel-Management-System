package hotel.management.system;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;

public class CustomerInfo extends JFrame {
	Connection conn = null;
	 JLabel lblId;
	 JLabel lblNewLabel;
	 JLabel lblGender;
	 JTable table;
	 JLabel lblCountry;
	 JLabel lblRoom;
	 JLabel lblStatus;
	 JLabel lblNewLabel_1;
	 JLabel Number;

	
	public static void main(String[] args) 
	{
		new CustomerInfo();
	}
	
	CustomerInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		setLayout(null);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    conn c  = new conn();
                                    
				String displayCustomersql = "select * from Customers";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		add(lblId);
                
        JLabel l1 = new JLabel("Number");
		l1.setBounds(100, 11, 46, 14);
		add(l1);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(200, 11, 65, 14);
		add(lblNewLabel);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(300, 11, 46, 14);
		add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		add(table);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(400, 11, 46, 14);
		add(lblCountry);
		
		lblRoom = new JLabel("Room");
		lblRoom.setBounds(500, 11, 46, 14);
		add(lblRoom);
		
		lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(600, 11, 100, 14);
		add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(700, 11, 100, 14);
		add(lblNewLabel_1);
		
		Number = new JLabel("Number");
		Number.setBounds(800, 11, 100, 14);
		add(Number);
                
        setBackground(Color.WHITE);
        setVisible(true);
	}
}