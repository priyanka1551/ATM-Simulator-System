import javax.swing.*;    //Jframe is in Swing
import java.awt.*;      //color class is present in awt class
import java.awt.event.*;
public class signupTwo extends JFrame implements ActionListener {
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton senioryes,seniorno,accountno,accountyes;
    JComboBox religionBox,categoryBox,educationBox,incomeBox,occupationBox;
    String formno;

    signupTwo(String formno){
        this.formno=formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");

        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionalDetails.setBounds(250,80,400,35);
        add(additionalDetails);

        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,150,100,30);
        add(religion);
        //dropdown comes from combo class
        String[] valReligion={"Hindu","Muslim","Sikh","Christian","Other"};
        religionBox=new JComboBox(valReligion);
        religionBox.setBounds(300,150,400,30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,200,200,30);
        add(category);

        String[] valcategory={"General","OBC","SC","ST","Other"};
        categoryBox=new JComboBox(valcategory);
        categoryBox.setBounds(300,200,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,250,200,30);
        add(income);

        String[] incomecategory={"NULL","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeBox=new JComboBox(incomecategory);
        incomeBox.setBounds(300,250,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel education=new JLabel("Educational ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,300,200,30);
        add(education);
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,320,200,30);
        add(qualification);

        String[] educationValues={"Non-Graduation","Graduate","Post-Graduation","Doctorate","Other"};
        educationBox=new JComboBox(educationValues);
        educationBox.setBounds(300,315,400,30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,400,200,30);
        add(occupation);

        String[] occupationValues={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationBox=new JComboBox(occupationValues);
        occupationBox.setBounds(300,400,400,30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,450,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,450,400,30);
        add(panTextField);


        JLabel  aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,500,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,500,400,30);
        add(aadharTextField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,550,200,30);
        add(senior);

        senioryes=new JRadioButton("Yes");
        senioryes.setBounds(300,550,100,30);
        senioryes.setBackground(Color.WHITE);
        add(senioryes);

        seniorno=new JRadioButton("No");
        seniorno.setBounds(400,550,100,30);
        seniorno.setBackground(Color.WHITE);
        add(seniorno);

        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(senioryes);
        seniorgroup.add(seniorno);
       

        JLabel existsaccount=new JLabel("Existing Account:");
        existsaccount.setFont(new Font("Raleway",Font.BOLD,20));
        existsaccount.setBounds(100,600,200,30);
        add(existsaccount);

        
        accountyes=new JRadioButton("Yes");
        accountyes.setBounds(300,600,100,30);
        accountyes.setBackground(Color.WHITE);
        add(accountyes);

        accountno=new JRadioButton("No");
        accountno.setBounds(400,600,100,30);
        accountno.setBackground(Color.WHITE);
        add(accountno);

        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(accountyes);
        accountgroup.add(accountno);

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
        
        String strreligion=(String) religionBox.getSelectedItem();  //getSelectedItem() is used to extract the value from dropdown box
        String strcategory=(String) categoryBox.getSelectedItem();  //it returns an object ,so we will typecast this
        String strincome=(String) categoryBox.getSelectedItem();
        String streducation=(String) educationBox.getSelectedItem();
        String stroccupation=(String) occupationBox.getSelectedItem();
        String strsenior=null;
        if(senioryes.isSelected()){
            strsenior="Yes";
        }
        else if(seniorno.isSelected()){
            strsenior="No";
        }
        String straccount=null;
        if(accountyes.isSelected()){
            straccount="Yes";
        }
        else if(accountno.isSelected()){
            straccount="No";
        }
        String strpan=panTextField.getText();
        String straadhar=aadharTextField.getText();
        

        //database is an external entity
        try{
            
                conn c=new conn();
                //DML -to manipulate(insert int MySQL)
                String query="insert into signup2 values('"+formno+"','"+strreligion+"','"+strcategory+"','"+strincome+"','"+streducation+"','"+stroccupation+"','"+strsenior+"','"+straccount+"','"+strpan+"','"+straadhar+"')";
                c.s.executeUpdate(query);   //we can execute query using statement (s) that we created in conn file

                setVisible(false);
                new signupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    //"String"+'"+variable+"'+"String"      this variable is treated like a string
    public static void main(String[] args){
        new signupTwo("");
    }
}
