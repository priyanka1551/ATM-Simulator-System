import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        //mySQL is an external entity ,so there are chances of error at runtime,hence to catch these errors we will use tryCatch
        try{
            //it will automatically register the driver
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","personal_password"); 
            //paste the name of ur database after 3 slash
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e); //we are simply printing whatever the error is coming
        }
    }
}
 //conn stands for connectivity
    //there are 5 steps involved in jdbc connectivity
    //1.Register the driver
    //2.Create Connecction
    //3.Create Statement
    //4.Execute Query
    //5.Close Connection
