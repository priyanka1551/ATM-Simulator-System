import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class fastCash extends JFrame implements ActionListener{
    JButton amount1, amount2,amount3,amount4,amount5,amount6,exit;
    String pinnumber;
    fastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("background2.jpg"));
        //image is present in awt package
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        // add(text); //it will add above the frame not above image
        image.add(text);

        amount1=new JButton("Rs 100");
        amount1.setBounds(170,415,150,30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2=new JButton("Rs 500");
        amount2.setBounds(355,415,150,30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3=new JButton("Rs 1000");
        amount3.setBounds(170,450,150,30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4=new JButton("Rs 2000");
        amount4.setBounds(355,450,150,30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5=new JButton("Rs 5000");
        amount5.setBounds(170,485,150,30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6=new JButton("Rs 10000");
        amount6.setBounds(355,485,150,30);
        amount6.addActionListener(this);
        image.add(amount6);

        exit=new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==exit){
            System.exit(0);
        }
        else{
            String amount=((JButton) ae.getSource()).getText().substring(3);
            conn c=new conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin= '"+pinnumber+"' ");
                int balance=0;
                while(rs.next()){           //it is used to loop each row
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient  Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" debited successfully");
                setVisible(false);
                new transaction(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args){
        new fastCash("");
    }
}

