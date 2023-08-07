package university.mangement.system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UpdateStudent extends JFrame implements ActionListener{

    JTextField tfcourse, tfaddress, tfphone, tfemail,tfbranch;
    JLabel labelrollno;
    JButton update, cancel;
    Choice crollno;
    
        
    UpdateStudent() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(310, 20, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 150, 30);
        lblrollnumber.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(210, 100, 150, 30);
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
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 200, 30);
        labelname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelname); 
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(460, 150, 180, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname); 
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(640, 150, 200, 30);
        labelfname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelfname); 
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 230, 150, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(220, 230, 150, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(460, 230, 150, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(640, 230, 200, 30);
        labeldob.setFont(new Font("serif", Font.BOLD, 20));
        add(labeldob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 300, 150, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 300, 200, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(460, 300, 180, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(640, 300, 200, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 370, 150, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 370, 200, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(460, 370, 180, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        JLabel labelx = new JLabel();
        labelx.setBounds(640, 370, 200, 30);
        labeldob.setFont(new Font("serif", Font.BOLD, 20));
        add(labelx);
        
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(460, 440, 180, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(640, 440, 200, 30);
        labelxii.setFont(new Font("serif", Font.BOLD, 20));
        add(labelxii); 
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(50, 440, 150, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(200, 440, 200, 30);
        labelaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(labelaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 510, 150, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(200, 510, 200, 30);
        add(tfcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(460, 510, 150, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(640, 510, 200, 30);
        add(tfbranch);
        
        try{
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        update = new JButton("Update");
        update.setBounds(250, 600, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 600, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700); 
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();            
            String branch = tfbranch.getText();
            
            try{
                String query = "update student set address = '"+address+"', phone = '"+phone+"', email = '"+email+"', course = '"+course+"', branch = '"+branch+"' where rollno = '"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully!!!");
                setVisible(false);
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String [] args) {
        new UpdateStudent();
    }
}
