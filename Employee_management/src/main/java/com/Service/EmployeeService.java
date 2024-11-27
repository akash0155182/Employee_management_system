package com.Service;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Details;

public class EmployeeService {

	static String url="jdbc:mysql://localhost:3306/emp";
	static String uname="root";
	static String pwd="1234";
	static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pwd);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addEmployee(Details d) {
		
		int rowUpdate=0;
		String sql="insert into employe_details values(?,?,?,?,?)";
		
		try {
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setInt(1,d.getId());
			smt.setString(2,d.getName());
			smt.setInt(3,d.getAge());
			smt.setString(4,d.getEmail());
			smt.setDouble(5,d.getSalary());
			rowUpdate=smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
	}

	public List<Details> display() {
		
		List<Details> l1=new ArrayList();
		
		String sql="SELECT * from employe_details";
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				double salary=rs.getDouble(5);
				
				l1.add(new Details(id,name,age,email,salary));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l1;
	}
	
	public int Update(Details d,int id) {
		
		int rowUpdate=0;
		String sql="update employe_details set id=?,name=?,age=?,email=?,salary=? where id=?;";
		
		try {
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1,d.getId());
			stm.setString(2,d.getName());
			stm.setInt(3,d.getAge());
			stm.setString(4,d.getEmail());
			stm.setDouble(5,d.getSalary());
			stm.setInt(6,id);
			rowUpdate=stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
	}
	public int Delete(int id)
	{
		int rowUpdate=0;
		String sql="delete from employe_details where id=?;";
		
		try {
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setInt(1,id);
			rowUpdate=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
	}
}
