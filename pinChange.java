import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class pinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    pinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon( ClassLoader.getSystemResource("background2.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText=new JLabel("New PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repinText=new JLabel("Re-Enter New PIN: ");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("Raleway",Font.BOLD,16));
        repinText.setBounds(165,360,180,25);
        image.add(repinText);

        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin=pin.getText();
                String rpin=repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                conn c=new conn();
                //we have to change pin in all tables
                String query1="update bank set pin = '"+npin+"'  where pin='"+pinnumber+"' ";
                String query2="update login set pinnumber = '"+npin+"' where pinnumber='"+pinnumber+"' ";
                String query3="update signup3 set pinnumber = '"+npin+"' where pinnumber='"+pinnumber+"' ";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new transaction(npin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new pinChange("").setVisible(true);
    }
}
