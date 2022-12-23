package databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner; 

public class SalaryCursor {
	public static void salarycursor() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter amount to search - ");
			double salary = scan.nextDouble(); 
			try {
				Connection con = DataConnection.myconnection();
				CallableStatement cst=con.prepareCall("call databasetesting.CursorSalary(?,?)");
				cst.setDouble(1, salary);

				cst.registerOutParameter(2, Types.VARCHAR);

				cst.setString(2,"");

				cst.executeUpdate();

				String result = cst.getString(2);
				StringBuffer sb= new StringBuffer(result); 
				System.out.println("Employee Salary > "+salary+" : "+sb.deleteCharAt(sb.length()-1)+"\n");
				
				String[] array = result.split(",");
				for (String string : array) {
					System.out.println(ReadOneData.readonedata(string)+"\n");
				}

				cst.close();

				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
	} 
	public static void main(String[] args) {
		salarycursor();
	}
}
