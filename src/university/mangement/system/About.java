package university.mangement.system;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {

    About() {
        setLayout(null);
        
        JLabel heading = new JLabel("University Management System");
        heading.setBounds(100, 10, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Name: Abhinendra");
        name.setBounds(100, 100, 500, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(name);
        
        JLabel contact = new JLabel("Contact: abhicse10001@gmail.com");
        contact.setBounds(100, 140, 500, 25);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
        
        setSize(700, 500); 
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    
    public static void main(String[] args) {
        new About();
    }
}
