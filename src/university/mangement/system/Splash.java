package university.mangement.system;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable{

    Thread t;
    Splash() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        for(int i = 2, x = 1; i<= 600; i+=4, x+=1) {
            setLocation(600 -((i + x)/2), 350 - (i/2));
            setSize(i + 3*x,i + x/2);
            
            try {
                Thread.sleep(10);
            }catch (Exception e) {
                
            }
        }
        
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public void run() {
        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login().setVisible(true);
        }catch (Exception e) {
            
        }
    }
    
    public static void main(String [] args) {
        new Splash();
    }
}