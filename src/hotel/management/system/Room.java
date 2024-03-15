package hotel.management.system;
import java.awt.*; 
import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
public class Room extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRoomNumber;
	private JLabel lblId;

	public static void main(String[] args) {
		new Room();
	}

        
	Room(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1100, 600);
		
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon("Icons/eight.jpg");
                Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,0,600,600);
                add(l1);
                
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
					String displayCustomersql = "select * from Addrooms";
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 470, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnNewButton.setBounds(290, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		add(btnNewButton);
		
		lblAvailability = new JLabel("Bed Type");
		lblAvailability.setBounds(119, 15, 69, 14);
		add(lblAvailability);
		
		lblCleanStatus = new JLabel("Price");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Available");
		lblNewLabel.setBounds(300, 15, 100, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Clean Status");
		lblNewLabel_1.setBounds(417, 15, 76, 14);
		add(lblNewLabel_1);

		
		lblId = new JLabel("Room Number");
		lblId.setBounds(12, 15, 90, 14);
		add(lblId);
                
		setBounds(100,100,1100,600);
		setVisible(true);
        setBackground(Color.WHITE);
	}

}