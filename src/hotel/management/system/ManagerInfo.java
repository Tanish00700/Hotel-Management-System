package hotel.management.system;

import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
public class ManagerInfo extends JFrame {
	 JTable table;
	 JLabel lblNewLabel;
	 JLabel lblJob;
	 JLabel lblName;
	 JLabel lblDepartment;

	public static void main(String[] args) {
		new ManagerInfo();
	}
	
	public ManagerInfo()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		add(table);
		
		JButton B1 = new JButton("Load Data");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
				String displayCustomersql = "select * from Addemployee where Designation = 'Manager'";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		B1.setBounds(350, 500, 120, 30);
        B1.setBackground(Color.BLACK);
        B1.setForeground(Color.WHITE);
		add(B1);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 11, 46, 14);
		add(lblNewLabel);
		
		lblJob = new JLabel("Age");
		lblJob.setBounds(159, 11, 46, 14);
		add(lblJob);
		
		lblName = new JLabel("Gender");
		lblName.setBounds(273, 11, 46, 14);
		add(lblName);
		
		lblDepartment = new JLabel("Job");
		lblDepartment.setBounds(416, 11, 86, 14);
		add(lblDepartment);
                
        JLabel l1 = new JLabel("Salary");
		l1.setBounds(536, 11, 86, 14);
		add(l1);
                
        JLabel l2 = new JLabel("Phone");
		l2.setBounds(656, 11, 86, 14);
		add(l2);
                
        JLabel l3 = new JLabel("Aadhar");
		l3.setBounds(786, 11, 86, 14);
		add(l3);
                
        JLabel l4 = new JLabel("Gmail");
		l4.setBounds(896, 11, 86, 14);
		add(l4);
                
       setVisible(true);
		setBackground(Color.WHITE);
	}
}