package hotel.management.system;

import java.awt.*;                      
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener { 

    
		JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;
        JButton b1,b2;
        JRadioButton Male,Female;

        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("NAME *");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
            
            b1 = new JButton("SAVE");
            b1.setBounds(80, 420, 100, 30);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            add(b1);
            
            b2 = new JButton("Cancel");
            b2.setBounds(250, 420, 100, 30);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.addActionListener(this);
            add(b2);
			
            JLabel Pnrno = new JLabel("AGE *");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("GENDER *");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
            Male = new JRadioButton("MALE");
            Male.setBackground(Color.WHITE);
            Male.setBounds(200, 120, 70, 27);
            add(Male);
	
            Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 120, 70, 27);
            add(Female);
            
            
            JLabel Address = new JLabel("JOB *");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("SALARY *");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("PHONE *");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Phno = new JLabel("AADHAR *");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 320, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
	
            
            JLabel email = new JLabel("EMAIL *");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 370, 150, 27);
            add(textField_6);
            
            ButtonGroup bg = new ButtonGroup();
            bg.add(Male);
            bg.add(Female);            
	

			
     
            ImageIcon i1 = new ImageIcon(("Icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(400,50,480,410);
            add(image);
            
            setBounds(200,200,900,550);
            setVisible(true);
            
			
	}
        
    public static void main(String[] args){
        new AddEmployee();
    }

	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b2)
		{
			setVisible(false);
			new Dashboard();
		}
		if(e.getSource()==b1)
		{
			String String1=" ";
			String name = textField.getText();
            String age = textField_1.getText();
            String salary = textField_3.getText();
            String phone = textField_4.getText();
            String aadhar = textField_5.getText();
            String email = textField_6.getText();
           
            String gender = null;
            
            if(!email.contains("@"))
            {
                JOptionPane.showMessageDialog(null,"enter Valid Email");
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
            
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"enter Name");
                return;
            }
            
            if(age.equals("")){
                JOptionPane.showMessageDialog(null,"enter Age");
                return;
            }
            if(salary.equals("")){
                JOptionPane.showMessageDialog(null,"enter Salary");
                return;
            }
            if(phone.equals("")){
                JOptionPane.showMessageDialog(null,"enter Phone number");
                return;
            }
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"enter Aadhar Number");
                return;
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"enter Email");
                return;
            }
            if(phone.length() != 10) {
        		JOptionPane.showMessageDialog(null,"enter 10 digit number");
        		return;
            }
            for(int i=0 ;i<=phone.length()-1;i++)
            {
            	if(phone.charAt(i)>='0' && phone.charAt(i)<='9')
            	{
            		continue;
            	}
            	else {
            		JOptionPane.showMessageDialog(null,"enter Valid number");
            		return;
            	}
            }
            if(aadhar.length() != 12) {
        		JOptionPane.showMessageDialog(null,"Enter 12 Digit Aadhar Number");
        		return;
            }
            for(int i=0 ;i<=(aadhar.length())-1;i++)
            {
            	if(aadhar.charAt(i)>='0' && aadhar.charAt(i)<='9')
            	{
            		continue;
            	}
            	else {
            		JOptionPane.showMessageDialog(null,"enter Valid Aadhar number");
            		return;
            	}
            }
            for(int i=0 ;i<=(salary.length())-1;i++)
            {
            	if(salary.charAt(i)>='0' && salary.charAt(i)<='9')
            	{
            		continue;
            	}
            	else {
            		JOptionPane.showMessageDialog(null,"Enter Valid Salary");
            		return;
            	}
            }
            for(int i=0 ;i<=(age.length())-1;i++)
            {
            	if(age.charAt(i)>='0' && age.charAt(i)<='9')
            	{
            		continue;
            	}
            	else {
            		JOptionPane.showMessageDialog(null,"Enter Valid age");
            		return;
            	}
            }
            
          
           
            if(Male.isSelected()){
                gender = "male";
            
            }
            else if(Female.isSelected()){
                gender = "female";
            }
            String s6 = (String)c1.getSelectedItem();
            
            try 
            {
                conn c = new conn();
                String str = "INSERT INTO AddEmployee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Employee Added");
                setVisible(false);
                new Dashboard();
            }  
            catch (Exception e1) 
            {
                e1.printStackTrace();
            }
		}
	}
}
            
		
	   
