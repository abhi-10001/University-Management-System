package university.mangement.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentLeave extends JFrame implements ActionListener{

    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    StudentLeave() {
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 220, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 130, 220, 30);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 200, 220, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 230, 220, 30);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 300, 220, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 330, 220, 30);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 450, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(260, 450, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(600, 600);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"');";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new StudentLeave();
    }
}
