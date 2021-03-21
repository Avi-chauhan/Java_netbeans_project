

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import acc_info;


public class acc_db {
	
public static int save(acc_info bean){
	int status=0;
	try{
		Connection con=database.getCon();
                System.out.println("rutvik");
		PreparedStatement ps=con.prepareStatement("insert into fee_accountant(name,email,password,address,contact) values(?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(acc_info bean){
	int status=0;
	try{
		Connection con=database.getCon();
		PreparedStatement ps=con.prepareStatement("update fee_accountant set name=?,email=?,password=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=database.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_accountant where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<acc_info> getAllRecords(){
	List<acc_info> list=new ArrayList<acc_info>();
	try{
		Connection con=database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			acc_info bean=new acc_info();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static acc_info getRecordById(int id){
	acc_info bean=new acc_info();
	try{
		Connection con=database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_accountant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setAddress(rs.getString(5));
			bean.setContact(rs.getString(6));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean;
}
}
