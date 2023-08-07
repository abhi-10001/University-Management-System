package university.mangement.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Marks extends JFrame implements ActionListener{

    String rollno;
    JButton cancel, getresult;
    JTextField semnum;
    JLabel sub1, sub2, sub3, sub4, sub5, lblsemester, mark1, mark2, mark3, mark4, mark5;
    
    Marks(String rollno) {
        this.rollno = rollno;
        setLayout(null);
        
        JLabel heading = new JLabel("Dr. A.P.J Kalam Technical University, Lucknow");
        heading.setBounds(30,10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(130,50, 500, 25);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number " + rollno);
        lblrollno.setBounds(60,100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        lblsemester = new JLabel("Semester ");
        lblsemester.setBounds(60,130, 200, 25);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        semnum = new JTextField();
        semnum.setBounds(180, 130, 50, 25);
        add(semnum);
        
        sub1 = new JLabel();
        sub1.setBounds(70,200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        
        sub2 = new JLabel();
        sub2.setBounds(70,230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        
        sub3 = new JLabel();
        sub3.setBounds(70,260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        
        sub4 = new JLabel();
        sub4.setBounds(70,290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        
        sub5 = new JLabel();
        sub5.setBounds(70,320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        
        mark1 = new JLabel();
        mark1.setBounds(450,200, 500, 20);
        mark1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(mark1);
        
        mark2 = new JLabel();
        mark2.setBounds(450,230, 500, 20);
        mark2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(mark2);
        
        mark3 = new JLabel();
        mark3.setBounds(450,260, 500, 20);
        mark3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(mark3);
        
        mark4 = new JLabel();
        mark4.setBounds(450,290, 500, 20);
        mark4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(mark4);
        
        mark5 = new JLabel();
        mark5.setBounds(450,320, 500, 20);
        mark5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(mark5);
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        getresult = new JButton("Get Result");
        getresult.setBounds(100, 500, 120, 30);
        getresult.setBackground(Color.BLACK);
        getresult.setForeground(Color.WHITE);
        getresult.setFont(new Font("Tahoma", Font.BOLD, 15));
        getresult.addActionListener(this);
        add(getresult);
        
        setSize(500, 600); 
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == cancel) {
            setVisible(false);
        }else {
            try{
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"' and semester = '"+semnum.getText()+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"' and semester = '"+semnum.getText()+"'");
            while(rs2.next()) {
                mark1.setText(rs2.getString("marks1"));
                mark2.setText(rs2.getString("marks2"));
                mark3.setText(rs2.getString("marks3"));
                mark4.setText(rs2.getString("marks4"));
                mark5.setText(rs2.getString("marks5"));
                lblsemester.setText("Semester " + rs2.getString("semester"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    public static void main(String[] args) {
        new Marks("");
    }
}
