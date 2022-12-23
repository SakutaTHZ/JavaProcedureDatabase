package databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	@SuppressWarnings("resource")
	public static void deleteData() {
		Connection con = DataConnection.myconnection();
		
		System.out.println("Delete Data\n__________");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Id to delete - ");
		int id = Integer.parseInt(scan.nextLine());
		
		if(ReadOneData.readonedata(id).size() == 0) {
			System.out.println("no data found\n");
			deleteData();
			return;
		}else {
			System.out.println("Employee data \n__________\n"+ReadOneData.readonedata(id));
		}
		
		try {
			CallableStatement cst=con.prepareCall("call databasetesting.DeleteEmployee(?)");
			cst.setInt(1,id);

			System.out.println("\nAre u sure u want to delete Employee "+id+"? (y/n)");
			String yn = scan.nextLine();
				if(yn.toLowerCase().equals("y")) {
					int result=cst.executeUpdate();
					if(result>0) {
						System.out.println("\nSuccessfully Deleted");
					}
					cst.close();
				}else {
					deleteData();
					return;
				}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
	
	public static void main(String[] args) {
		deleteData();
	}
}
