package university.mangement.system;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{

    JTextField tfusername;
    JPasswordField tfpassword;
    
    JButton login, cancel;
    
    Login() {
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 65, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 120, 100, 20);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 115, 150, 30);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 190, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 190, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 30, 200, 200);
        add(image);
        
        
        setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); 
        setLocationRelativeTo(null);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username = '" +username+ "' and password ='"+password+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    tfusername.setText("");
                    tfpassword.setText("");
                }
                c.s.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == cancel) {
            System.exit(0);
        }
    }
    
    public static void main(String [] args) {
        new Login();
    }
}
