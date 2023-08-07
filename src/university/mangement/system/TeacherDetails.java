package university.mangement.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempId;
    JTable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cempId = new Choice();
        cempId.setBounds(180, 20, 150, 20);
        add(cempId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cempId.add(rs.getString("empId"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1200, 600);
        add(jsp);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(1200, 700);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search) {
            String query = "select * from teacher where empId = '"+cempId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print) {
            try{
                table.print();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else if( ae.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        }else if(ae.getSource() == update) {
            setVisible(false);
//            new UpdateTeacher();
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String [] args) {
        new TeacherDetails();
    }
}
