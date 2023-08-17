package employee_management._system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class Viewemployee extends JFrame  implements ActionListener {
     JTable table;
    Choice cemployeeId;
    JButton esearch, print, update, back;
    
    Viewemployee(){
        JLabel search=new JLabel("search by employee ID");
        search.setBounds(5,95,140,30);
        add(search);
        
        cemployeeId=new Choice();
        cemployeeId.setBounds(150,100,180,30);
        add(cemployeeId);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(70,10,900,40);
        heading.setFont(new Font("serit",Font.PLAIN,50));
        add(heading);
        
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee1");
            while(rs.next())
            {
                cemployeeId.add(rs.getString("empID"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee1");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,150,1100,600);
        add(jsp);
        
        esearch = new JButton("Search");
        esearch.setBounds(20, 70, 80, 20);
        esearch.addActionListener(this);
        add(esearch);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
       back.addActionListener(this);
        add(back);
        
        
                        
       
        
        setVisible(true);
        setSize(1100,700);
        setLocation(200,50);
         }
         public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == esearch) {
            String query = "select * from employee1 where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new Updateemployee(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

        public static void main(String a[])
        {
            new Viewemployee();
        }
}