
package employee_management._system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField tusername,tpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,80);
        heading.setFont(new Font("serit",Font.PLAIN,50));
        add(heading);
        
        JLabel lusername=new JLabel("USERNAME");
        lusername.setBounds(100,200,100,80);
        add(lusername);
        
        JLabel lpassword=new JLabel("PASSWORD");
        lpassword.setBounds(100,300,100,80);
        add(lpassword);
        
         tusername=new JTextField();
        tusername.setBounds(200,233,100,20);
        add(tusername);
        
          tpassword=new JTextField();
        tpassword.setBounds(200,333,100,20);
        add(tpassword);

        JButton click=new JButton("LOGIN");
        click.setBounds(150,400,200,50);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        add(click);
        click.addActionListener(this);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconse/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 100, 980, 500);
        add(image);


        
        
        
        setVisible(true);
        setSize(1100,700);
        setLocation(200,50);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String username=tusername.getText();
            String password=tpassword.getText();
            
            Conn c=new Conn();
            String query="Select * from Login where username='"+username+"' and password ='"+password+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                new Home();
                setVisible(false);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid login details");
                setVisible(false);
                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
