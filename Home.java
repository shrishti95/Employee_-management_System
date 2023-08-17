package employee_management._system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,update,remove,view;
    Home(){
        getContentPane().setBackground(Color.black);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconse/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 100, 780, 500);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(150,50,1100,70);
        heading.setFont(new Font("TAHOMA",Font.BOLD,50));
        image.add(heading);
        
        add=new JButton("ADD  EMPLOYEE");
        add.setBounds(200,200,200,50);
        image.add(add);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(this);
        
         view=new JButton("VIEW  EMPLOYEE");
        view.setBounds(500,200,200,50);
        image.add(view);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(this);
        
          update=new JButton("UPDATE  EMPLOYEE");
        update.setBounds(200,300,200,50);
        image.add(update);
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.addActionListener(this);
        
          remove=new JButton("REMOVE  EMPLOYEE");
        remove.setBounds(500,300,200,50);
        image.add(remove);
        remove.setForeground(Color.white);
        remove.setBackground(Color.black);
        remove.addActionListener(this);

        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true );
        
        
    }
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new Addemployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new Viewemployee();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new Viewemployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
       public static void main(String[] args)
     {
        new Home();
    }
    
}
