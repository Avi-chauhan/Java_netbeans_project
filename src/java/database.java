
import java.sql.*;
public class database {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");  
con=DriverManager.getConnection( "jdbc:mysql://localhost/school_fee","root",""); 
	}catch(ClassNotFoundException | SQLException ex){System.out.println(ex);}
	return con;
}
}
