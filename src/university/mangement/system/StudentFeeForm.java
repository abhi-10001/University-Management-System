package university.mangement.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StudentFeeForm extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JButton pay, update, back;
    JLabel labeltotal;
    
    StudentFeeForm() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Student Fee Form");
        heading.setBounds(210, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel labelrollno = new JLabel("Select Roll no");
        labelrollno.setBounds(100, 100, 200, 30);
        labelrollno.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelrollno);
        
        crollno = new Choice();
        crollno.setBounds(300, 100, 150, 30);
        crollno.setBackground(Color.WHITE);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 140, 200, 30);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(100, 180, 200, 30);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblfname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(300, 140, 300, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(300, 180, 300, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labelfname);
        
        JLabel lablecourse = new JLabel("Course");
        lablecourse.setBounds(100, 220, 200, 30);
        lablecourse.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lablecourse);
        
        String course[] = {"B.Tech","M.Tech", "BBA", "BCA", "B.Sc", "M.Sc", "MBA", "MCA", "M.Com", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(300, 220, 300, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel labelbranch = new JLabel("Branch");
        labelbranch.setBounds(100, 260, 200, 30);
        labelbranch.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelbranch);
        
        String branch[] = {"Computer Science and Engineering", "Electronics Engineering", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering", "Chemical Engineering", "Plastic Engineering", "Textile Engineering"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(300, 260, 300, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel labelsem = new JLabel("Semester");
        labelsem.setBounds(100, 300, 200, 30);
        labelsem.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelsem);
        
        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(300, 300, 300, 30);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel labelpay = new JLabel("Total Payable");
        labelpay.setBounds(100, 340, 200, 30);
        labelpay.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelpay);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(300, 340, 200, 30);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(labeltotal);
        
        try{
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname")); 
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        update = new JButton("Update");
        update.setBounds(150, 420, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        update.addActionListener(this);
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(300, 420, 100, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(450, 420, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
        
        setSize(700, 500);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update) {
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"' ");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == pay) {
            String rollno = crollno.getSelectedItem();
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"');";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
