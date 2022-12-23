package databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class insertdata {
	public static void insertData(){
		System.out.println("Insert Data\n__________");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Name - ");
		String name = scan.nextLine();
		
		System.out.print("Age - ");
		int age = Integer.parseInt(scan.nextLine());
		
		System.out.print("Address - ");
		String add = scan.nextLine();
		
		System.out.print("Salary - ");
		double salary = Integer.parseInt(scan.nextLine());
		
		Connection con = DataConnection.myconnection();
		try {
			CallableStatement cst=con.prepareCall("call databasetesting.InsertEmployee(?, ?, ?, ?)");
			cst.setString(1, name);
			cst.setInt(2, age);
			cst.setString(3,add);
			cst.setDouble(4, salary);
			int result=cst.executeUpdate();
			if(result>0) {
				System.out.println("Successfully Inserted "+ name);
			}
			cst.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		insertData();
	}
}
	
