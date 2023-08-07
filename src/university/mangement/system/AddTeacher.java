package university.mangement.system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AddTeacher extends JFrame implements ActionListener{

    JTextField tfname ,tffname, tfaddress, tfphone, tfx, tfemail, tfxii, tfaadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    
    AddTeacher() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 200, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(460, 150, 180, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(640, 150, 200, 30);
        add(tffname);
        
        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 230, 150, 30);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblempId);
        
        labelempid = new JLabel("101"+first4);
        labelempid.setBounds(220, 230, 150, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempid);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(460, 230, 150, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(640, 230, 200, 30);
        add(dcdob);
        
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
        
        tfx = new JTextField();
        tfx.setBounds(640, 370, 200, 30);
        add(tfx);
        
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(460, 440, 180, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(640, 440, 200, 30);
        add(tfxii);
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(50, 440, 150, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 440, 200, 30);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 510, 150, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"B.Tech","M.Tech", "BBA", "BCA", "B.Sc", "M.Sc", "MBA", "MCA", "M.Com", "MA", "BA", "Others"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 510, 200, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(460, 510, 150, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"Computer Science and Engineering", "Electronics Engineering", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering", "Chemical Engineering", "Plastic Engineering", "Textile Engineering", "Others"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(640, 510, 200, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 600, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
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
        if(ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelempid.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String)cbcourse.getSelectedItem();            
            String branch = (String)cbbranch.getSelectedItem();
            
            try{
                String query = "insert into teacher values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully!!!");
                setVisible(false);
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String [] args) {
        new AddTeacher();
    }
}
