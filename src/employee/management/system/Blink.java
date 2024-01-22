
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blink extends JFrame implements ActionListener {
    
    Blink(){
           
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\ML\\OneDrive\\Documents\\NetBeansProjects\\Employee Management System\\src\\employee\\management\\system\\images\\front.jpg");
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 270, 50);
        clickhere.setBackground(Color.WHITE);
        clickhere.setForeground(Color.BLACK);
        clickhere.setFont(new Font("serif", Font.PLAIN, 16));
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    
    public static void main(String args[]){
        new Blink();
    }
}
