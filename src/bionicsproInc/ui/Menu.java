package bionicsproInc.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bionicsproInc.db.ifaces.DBManager;
import bionicsproInc.db.jdbc.JDBCManager;

public class Menu {

	private static DBManager dbman = new JDBCManager();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		dbman.connect();
		do {
			System.out.println("Choose an option:");
			System.out.println("1. TODO");
			System.out.println("2. TODO");
			System.out.println("0. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:

				break;
			case 2:

				break;
			case 0:
				dbman.disconnect();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);

	}
}

/*
 * private static void addCustomer() throws Exception {
 * 
 * System.out.println("Please, input the customer info:"); BufferedReader reader
 * = new BufferedReader(new InputStreamReader(System.in));
 * System.out.print("First name: "); String first_name = reader.readLine();
 * System.out.print("Last name: "); String last_name = reader.readLine();
 * System.out.print("Age: "); String age = reader.readLine();
 * System.out.print("Gender (MALE/FEMALE): "); String gender =
 * reader.readLine(); System.out.print("Phone: "); String phone =
 * reader.readLine(); System.out.print("Email: "); String email =
 * reader.readLine(); System.out.print("Street: "); String street =
 * reader.readLine(); System.out.print("City: "); String city =
 * reader.readLine(); System.out.print("Postal code: "); String postal_code =
 * reader.readLine(); System.out.print("Order id: "); String order_id =
 * reader.readLine(); dbman.addCustomer(first_name, last_name, age, gender,
 * phone, email, street, city, postal_code, order_id);
 * 
 * System.out.println("Customer info processed.");
 * System.out.println("Records inserted.");
 * 
 * }
 */
