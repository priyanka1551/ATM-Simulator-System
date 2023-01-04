import javax.swing.*;    //Jframe is in Swing
import java.awt.*;      //color class is present in awt class
import java.util.*;    //random class is presnt in util package
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;

    signupOne(){

        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong() %9000L)+1000L);
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        personalDetails.setBounds(250,80,400,35);
        add(personalDetails);

        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,150,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,150,400,30);
        add(nameTextField);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,200,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,200,400,30);
        add(fnameTextField);

        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,250,200,30);
        add(dob);
        //we have to choose the dob from calender 
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,250,400,30);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,14));
        dateChooser.setForeground(Color.BLACK);   // we can also use new Color(105,105,105)
        add(dateChooser);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,300,200,30);
        add(gender);
        //to make radio buttons
        male=new JRadioButton("MALE");
        male.setBounds(300,300,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("FEMALE");
        female.setBounds(450,300,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        //after this both male and female are getting selected ,we want only one to select at a time
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,350,200,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,350,400,30);
        add(emailTextField);


        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,400,200,30);
        add(marital);
        married=new JRadioButton("MARRIED");
        married.setBounds(300,400,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,400,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other=new JRadioButton("OTHER");
        other.setBounds(630,400,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,450,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,450,400,30);
        add(addressTextField);


        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,500,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,500,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,550,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,550,400,30);
        add(stateTextField);

        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,600,200,30);
        add(pincode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,600,400,30);
        add(pinTextField);

        next=new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        //as there is only one button ,we do not need to check if else condition to see which button is clicked
        String formno="" + random; //random is a long value ,to convert that to string ,we will concatanate
        String name=nameTextField.getText();  //getText() is used to extract the value of textfield
        String fname=fnameTextField.getText(); 
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); 
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else{
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        //database is an external entity
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
                conn c=new conn();
                //DML -to manipulate(insert int MySQL)
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);   //we can execute query using statement (s) that we created in conn file

                //if data successfully comes here
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //"String"+'"+variable+"'+"String"      this variable is treated like a string
    public static void main(String[] args){
        new signupOne();
    }
}
