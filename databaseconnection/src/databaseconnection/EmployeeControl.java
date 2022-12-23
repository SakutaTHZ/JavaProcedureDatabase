package databaseconnection;

import java.util.Scanner;

public class EmployeeControl {
	public static void actions() {
		try (Scanner scan1 = new Scanner(System.in)) {
			System.out.println("1) Show All Employee\n2) Search Employee\n3) Insert Employee\n4) Update Employee\n5) Delete Employee\n6) Salary Search\n__________\nChoose action - ");
			String num = scan1.nextLine();
			if(num.equals("1")){
				ReadData.readdata();
			}else if(num.equals("2")){
				System.out.print("1) Search with id\n2) Search with name\nChoose searching method - ");
				String cnum = scan1.nextLine();
				if(cnum.equals("1")) {
					System.out.print("Choose id - ");
					int search = scan1.nextInt();
					ReadOneData.readonedata(search);
				}else if(cnum.equals("2")) {
					System.out.print("Choose name - ");
					String search = scan1.nextLine();
					ReadOneData.readonedata(search);
				}else {
					System.out.println("Chose none");
				}
			}else if(num.equals("3")){
				insertdata.insertData();
			}else if(num.equals("4")){
				UpdateData.updateData();
			}else if(num.equals("5")){
				DeleteData.deleteData();
			}else if(num.equals("6")){
				SalaryCursor.salarycursor();
				return;
			}else {
				System.out.println("Can't do nothing");
				actions();
			}
			System.out.print("\nContinue? (y/n) - ");
			String yn = scan1.nextLine();
			if(yn.toLowerCase().equals("y")) {
				actions();
			}else {
				System.out.println("Exited Program");
			}
		}
	}
	
	public static void main(String[] args) {
		actions();
	}
}
