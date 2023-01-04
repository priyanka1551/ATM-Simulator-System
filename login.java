import javax.swing.*;        //* means that it will import all packages of swing
import java.awt.*;
import java.awt.event.*;     //ActionListener interface is present in event package of awt
import java.sql.*;          //ResultSet is present in sql package

//to implement actions ,we have to use ActionListener interface
//if user clicked on a button,then we will get too know using ActionListener
public class login extends JFrame implements ActionListener{                 
     //when login object is created ,it will go under this class

     //to access the buttons in another function as well, we have t define it globally
     JButton login,signup,clear;
     JTextField cardTextField;
     //if we want that no one can see the pin what i am typing
     JPasswordField pinTextField;

    login(){                        //login constructor is created here
        // it is used to set the title of frame . use double quotes
        setTitle("Automated Teller Machine");  
        //setBound will apply the layouts to the image 
        setLayout(null);
        //image icon class is used to set image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("background.png"));
        //now we can manage the size of this image.for that we have to make image class object
        //Image class is found in Awt package so import that
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //to pass Image also in JLabel, we will convert this to imageIcon
        ImageIcon i3=new ImageIcon(i2);
        //we cannot directly put icon on the frame
        //we can only pass ImageIcon in JLabel
        JLabel label=new JLabel(i3);
        //to change the location of image on the frame (x-from left, y-from top)
        label.setBounds(70,10,100,100);
        add(label);       //to add anything on the frame, we have to pass its object

        //JLabel is used to put content on the frame
        JLabel text=new JLabel("Welcome to ATM");
        //to change font
        text.setFont(new Font("Osward",Font.BOLD,38));
        //to tell where to place text
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raieway",Font.BOLD,28));
        cardno.setBounds(120,150,400,40);
        add(cardno);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);

        //textfield is used to take input from user
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //we have JButton class to make buttons
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);  //to set background color
        login.setForeground(Color.WHITE);  //to set the font color
        login.addActionListener(this);   //this will tell that the button is being clicked 
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);   
        add(clear);

        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);   
        add(signup);

        //getContentPane is used to pick container or frame 
        getContentPane().setBackground(Color.WHITE);
        //to set the size of frame
        setSize(800,480);  
        //to make it visible because by deafult it(i.e frame) is invisible                    
        setVisible(true);     
        // by deafult the frame will start from top left but we can change it accordingly
        setLocation(350,200);
    }
    //if we are implementing an interface ,then we have to overwrite all the methods of that interface
    public void actionPerformed(ActionEvent ae){
        //when the button has been clicked then what we will do after that is written inside this function
        //ActionEvent will tell us action is performed on which components
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            conn c=new conn();
            String cardnum=cardTextField.getText();
            String pinnum=pinTextField.getText();
            //to extract from mySQl
            String query="select * from login where cardnumber='"+cardnum+"'and pinnumber='"+pinnum+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinnum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);                 //make current frame unvisible
            new signupOne().setVisible(true); //created a signup objected and make it visible when signup button is clicked
        }

    }

    public static void main(String[] args){
        new login();        // we will create a login object
    }
}