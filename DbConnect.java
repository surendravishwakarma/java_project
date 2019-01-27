
package db;

import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement checkAdmin,addUser,getUserLike,updateUser,deleteUser;
    static{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","surendra","surendra");
st=c.createStatement();
checkAdmin=c.prepareStatement("select * from admin_login where user_id=? and password=?");
getUserLike=c.prepareStatement("select * from candidates_info where name like ?");
addUser=c.prepareStatement(
 "insert into candidates_info (name,gen,dob,country,skills,adr) values(?,?,?,?,?,?)");
updateUser=c.prepareStatement(
 "update candidates_info set name=?,gen=?,dob=?,country=?,skills=?,adr=? "
         + "where cid=?");
deleteUser=c.prepareStatement(
 "delete from candidates_info where cid=?");
}catch(Exception ex){
	ex.printStackTrace();
}
    }
}
