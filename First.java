package employee_management._system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class First extends JFrame implements ActionListener{
    First(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,80);
        heading.setFont(new Font("serit",Font.PLAIN,50));
        add(heading);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconse/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 980, 500);
        add(image);
        
        JButton click=new JButton("click here to continue");
        click.setBounds(400,400,200,50);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        image.add(click);
        click.addActionListener(this);

        
        setVisible(true);
        setSize(1100,700);
        setLocation(200,50);
        while(true)
        {
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
                heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
      
        }
       
    }
      public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
        }
        
    public static void main(String args[])
    {
        new First();
    }
    
}
