package employees;

import java.util.*;
import java.sql.*;
public class CrudOperation {
	
//------------------Connection Established--------------------------
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/javaemployee";
		String username = "root";
		String password = "";
		
		con = DriverManager.getConnection(url,username,password);
		
		//System.out.println("Connection Established");
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return con;
	}
	
//---------------------------Create Database------------------------
	public void createDatabase() {
		
		try {
			Connection con = getConnection();
			String database = "create database javaemployee";
			Statement stm = con.createStatement();
			int status = stm.executeUpdate(database);
			
			if(status > 0) {
				System.out.println("Database Created ");
			}else {
				System.out.println("failed to create database");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//-------------------------create table-----------------------------
	public void createTable() {
		
		try {
			Connection con = getConnection();
			
			String table = "create table employee(id varchar(10)unique primary key,"
					+ "name varchar(100),gender varchar(10), dob varchar(50),"
					+ "address varchar(100),email varchar(50),jobtype varchar(100),"
					+ "joindate varchar(50),salary int,contact varchar(10))";
			
			Statement stm = con.createStatement();
			int status = stm.executeUpdate(table);
			if(status > 0) {
				System.out.println("Table Created ");
			}else {
				System.out.println("failed to create Table");
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
//--------------------------insert data-----------------------------------
	public static int insertData(GetSet gs) {
		
		int status = 0;
		try {
			
			Connection con = getConnection();
			String insert = "insert into employee(id,name,gender,dob,address,email,"
					+ "jobtype,joindate,salary,contact)values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insert);
			
			pst.setString(1, gs.getId());
			pst.setString(2, gs.getName());
			pst.setString(3, gs.getGender());
			pst.setString(4, gs.getDob());
			pst.setString(5, gs.getAddress());
			pst.setString(6, gs.getEmail());
			pst.setString(7, gs.getJobType());
			pst.setString(8, gs.getJoinDate());
			pst.setInt(9, gs.getSalary());
			pst.setString(10, gs.getContact());
			
			status = pst.executeUpdate();
			
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

//-----------------------Read data----------------------------------------

	public List<GetSet> readData() {
		
		List<GetSet> lst = new ArrayList<GetSet>();
		
		try {
			Connection con = getConnection();
			String read = "select * from employee";
			PreparedStatement pst = con.prepareStatement(read);
			
			ResultSet data = pst.executeQuery();
			
			while(data.next()) {
				
				GetSet gs = new GetSet();
				
				gs.setId(data.getString(1));
				gs.setName(data.getString(2));
				gs.setGender(data.getString(3));
				gs.setDob(data.getString(4));
				gs.setAddress(data.getString(5));
				gs.setEmail(data.getString(6));
				gs.setJobType(data.getString(7));
				gs.setJoinDate(data.getString(8));
				gs.setSalary(data.getInt(9));
				gs.setContact(data.getString(10));
				
				lst.add(gs);
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return lst;
	}
	
//------------------------get-Update---------------------------------------
	public static GetSet getData(String id) {
		GetSet gs = new GetSet();
		try {
			
			Connection con = getConnection();
			String update = "select * from employee where id=?";
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, id);
			
			ResultSet data = pst.executeQuery();
			
			while(data.next()) {
				
				gs.setId(data.getString(1));
				gs.setName(data.getString(2));
				gs.setGender(data.getString(3));
				gs.setDob(data.getString(4));
				gs.setAddress(data.getString(5));
				gs.setEmail(data.getString(6));
				gs.setJobType(data.getString(7));
				gs.setJoinDate(data.getString(8));
				gs.setSalary(data.getInt(9));
				gs.setContact(data.getString(10));
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return gs;
	}

//------------------------Update Data------------------------------------
	public static int updateData(GetSet gs) {
		int status = 0;
		try {
			Connection con = getConnection();
			String update = "update employee set name=?,gender=?,dob=?,address=?,"
					+ "email=?,jobtype=?,joindate=?,salary=?,contact=? where id=?";
			
			PreparedStatement stm = con.prepareStatement(update);
			stm.setString(1, gs.getName());
			stm.setString(2, gs.getGender());
			stm.setString(3, gs.getDob());
			stm.setString(4, gs.getAddress());
			stm.setString(5, gs.getEmail());
			stm.setString(6, gs.getJobType());
			stm.setString(7, gs.getJoinDate());
			stm.setInt(8, gs.getSalary());
			stm.setString(9, gs.getContact());
			stm.setString(10, gs.getId());
			
			status = stm.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

//-----------------------Delete data------------------------------
	public static int delete(GetSet gs) {
		int status = 0;
		try {
			Connection con = getConnection();
			
			String delete = "delete from employee where id = ?";
			PreparedStatement pst = con.prepareStatement(delete);
			
			pst.setString(1, gs.getId());
			
			status = pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return status;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CrudOperation co = new CrudOperation();
		//int x = co.getConnection();
		//getConnection();
		//co.createDatabase();
		//co.createTable();
	}

}
