package university.mangement.system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{

    FeeStructure() {
        
        setLayout(null);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JTable table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);
        
        setSize(1000, 700); 
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
