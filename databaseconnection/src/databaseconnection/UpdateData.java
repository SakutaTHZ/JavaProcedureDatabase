package databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {
	@SuppressWarnings("resource")
	public static void updateData() {
		Connection con = DataConnection.myconnection();
		
		System.out.println("Update Data\n__________");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Id to change - ");
		int id = Integer.parseInt(scan.nextLine());
		
		if(ReadOneData.readonedata(id).size() == 0) {
			System.out.println("no data found\n");
			updateData();
			return;
		}else {
			System.out.println("Original data \n__________\n"+ReadOneData.readonedata(id));
		}
		
		System.out.println("\nNew data \n__________\n");
		System.out.print("Name - ");
		String name = scan.nextLine();
		
		System.out.print("Age - ");
		int age = Integer.parseInt(scan.nextLine());
		
		System.out.print("Address - ");
		String add = scan.nextLine();
		
		System.out.print("Salary - ");
		double salary = Integer.parseInt(scan.nextLine());
		
		try {
			CallableStatement cst=con.prepareCall("call databasetesting.UpdateEmployee(?,?,?,?,?)");
			cst.setInt(1,id);
			cst.setString(2,name);
			cst.setString(3,add);
			cst.setInt(4,age);
			cst.setDouble(5, salary);

			int result=cst.executeUpdate();
			if(result>0) {
				System.out.println("\nSuccessfully Updated\n"+ReadOneData.readonedata(id));
			}else {
				System.out.println("No Employee with id - " + id);
			}
			cst.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		updateData();
	}
}

