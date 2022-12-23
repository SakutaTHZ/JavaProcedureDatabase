package databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadOneData {
	public static List<EmployeeBean> readonedata(int id) {
		Connection con = DataConnection.myconnection();

		List<EmployeeBean> lstEmp=new ArrayList<EmployeeBean>();

		try {

		CallableStatement cst=con.prepareCall("call databasetesting.GetOneEmployee(?)");
		cst.setInt(1, id);
		ResultSet rs=cst.executeQuery();
		while(rs.next()) {
			EmployeeBean emp = new EmployeeBean();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setAge(rs.getInt(3));
			emp.setAddress(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			lstEmp.add(emp);
		}

		cst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lstEmp;
	}
	
	public static List<EmployeeBean> readonedata(String name) {
		Connection con = DataConnection.myconnection();

		List<EmployeeBean> lstEmp=new ArrayList<EmployeeBean>();

		try {

		CallableStatement cst=con.prepareCall("call databasetesting.GetOneEmployeeName(?)");
		cst.setString(1, name);
		ResultSet rs=cst.executeQuery();
		while(rs.next()) {
			EmployeeBean emp = new EmployeeBean();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setAge(rs.getInt(3));
			emp.setAddress(rs.getString(4));
			emp.setSalary(rs.getDouble(5));
			lstEmp.add(emp);
		}

		cst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lstEmp;
	}
	
}
