package bionicsproInc.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bionicsproInc.db.ifaces.*;
import bionicsproInc.db.jdbc.JDBCManager;


public class Menu {

	private static DBManager dbman = new JDBCManager();
	//private static UserManager userman = new JPAUserManager();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {
		dbman.connect();
		//userman.connect();
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
				//userman.disconnect();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);

	}
	
	private static void engineerMenu() throws Exception {
		do {
			System.out.println("Choose an option:");
			System.out.println("1. View product");
			System.out.println("2. Add new product");
			System.out.println("3. Remove product");
			System.out.println("4. See existing projects");
			System.out.println("5. View bonus");
			System.out.println("0. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
			viewProduct();
				break;
			case 2:
			//addProduct();
				break;
			case 3:
			
				break;
			case 4:
			
				break;
			case 5:
	
				break;

			case 0:
				return;
			default:
				break;
			}
		} while (true);
	}
	private static void customerMenu() throws Exception {
		do {
			System.out.println("Choose an option:");
			System.out.println("1. View product");
			System.out.println("2. Make purchase");
			System.out.println("3. Change product");
			System.out.println("4. See other purchases");
			System.out.println("0. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
			viewProduct();
				break;
			case 2:
				
				break;
			case 3:
			
				break;
			case 4:
			
				break;
			case 0:
				return;
			default:
				break;
			}
		} while (true);
	}
	
	private static void viewProduct() throws Exception {
		System.out.println("Choose a bodypart:");
		dbman.viewBodyparts();
		String name = reader.readLine();
		dbman.searchProductByBody(name);
		System.out.println("Choose a product: ");
		int id = Integer.parseInt(reader.readLine());
		dbman.viewCharacteristicsFromProduct(id);
		dbman.viewMaterialsFromProduct(id);
	}
	/*
	private static void addProduct() throws Exception {
		System.out.println("Input the product information:");
		System.out.print("Name: ");
		String name = reader.readLine();
		System.out.print("Body part: ");
		String bodypart = reader.readLine();
		System.out.print("Price: ");
		float price = Float.parseFloat(reader.readLine());
		System.out.print("Start Creation (yyyy-MM-dd): ");
		LocalDate startDate = LocalDate.parse(reader.readLine(), formatter);
		//photo
		System.out.print("Add the material/s of the product: ");
		while() {
		aqui ir añadiendo materiales, falta funcion viewAllMaterials
		}
		System.out.print("Add the characteristic/s of the product: ");
		while() {
		aqui ir añadiendo caracteristicas, falta funcion viewAllCharacteristics
		}
		
		
		
		
		Product prod = new Product(name, bodypart, price, Date.valueOf(startDate), ...);
		dbman.addProduct(product);*/
	}
	
	

	

	
}
