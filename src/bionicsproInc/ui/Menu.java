package bionicsproInc.ui;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import bionicsproInc.db.ifaces.*;
import bionicsproInc.db.jdbc.JDBCManager;
import bionicsproInc.db.pojos.Order;
import bionicsproInc.db.pojos.Product;

public class Menu {

	private static DBManager dbman = new JDBCManager();
	// private static UserManager userman = new JPAUserManager();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static Order temporaryOrder = new Order();
	
	private static Product localprod = new Product();

	private static JDBCManager JDBCmethod = new  JDBCManager();
	
	public static void main(String[] args) throws Exception {
		dbman.connect();
		// userman.connect();
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
				// userman.disconnect();
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
				 addprod();
				break;
			case 3:
				removeProduct();
				break;
			case 4:
				seeProject();
				break;
			case 5:
				viewBonus();

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
				makePurchase();
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
		// TODO ADD PRODUCT TO CART IF USER WANTS TO
	}
	/*
	 * private static void addProduct() throws Exception {
	 * System.out.println("Input the product information:");
	 * System.out.print("Name: "); String name = reader.readLine();
	 * System.out.print("Body part: "); String bodypart = reader.readLine();
	 * System.out.print("Price: "); float price =
	 * Float.parseFloat(reader.readLine());
	 * System.out.print("Start Creation (yyyy-MM-dd): "); LocalDate startDate =
	 * LocalDate.parse(reader.readLine(), formatter); //photo
	 * System.out.print("Add the material/s of the product: "); while() { aqui ir
	 * añadiendo materiales, falta funcion viewAllMaterials }
	 * System.out.print("Add the characteristic/s of the product: "); while() { aqui
	 * ir añadiendo caracteristicas, falta funcion viewAllCharacteristics }
	 * 
	 * 
	 * 
	 * 
	 * Product prod = new Product(name, bodypart, price, Date.valueOf(startDate),
	 * ...); dbman.addProduct(product); }
	 */

	private static void removeProduct() throws Exception {
		System.out.println("Id from product to delete");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Are you sure?" + "1->YES 0->NO");
		int option = Integer.parseInt(reader.readLine());
		if (option == 1) {
			dbman.removeProd(id);
			;
		} else {
			return;
		}
	}

	private static void viewBonus() throws Exception {
		System.out.println("Introduce your id");
		int id = Integer.parseInt(reader.readLine());
		dbman.viewBonus(id);
	}
	//CUSTOMER OPTION 2
	private static void makePurchase() throws Exception{
		System.out.println("These are the products: \n");
		dbman.viewCart(temporaryOrder);
		System.out.println("Are you sure?" + "1->YES 0->NO");
		int option=Integer.parseInt(reader.readLine());
		if(option==1) {
			dbman.addOrder(temporaryOrder);
		}
		else{
			return;
		}
	}
	

	// CUSTOMER OPTION 3
	private static void changeProduct() throws Exception {
		try {
			System.out.println("Choose the product you want to remove from cart");
			dbman.viewCart(temporaryOrder);
			String pName = reader.readLine();
			System.out.println("Are you sure you want to delete that product? 1->YES 0->NO");
			int option = Integer.parseInt(reader.readLine());
			if (option == 1) {
				dbman.deleteProdFromCart(pName, temporaryOrder);
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Engineer OPTION 5
	private static void seeProject() throws Exception {
		try {
			System.out.println("Introduce your ID : ");	
			int id = Integer.parseInt(reader.readLine());
			dbman.viewProjectAchieved(id);
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	// Engineer OPTION 4
	// NEED TO SPEAK ABOUT HOW TO ADD PHOTO ATTRIBUTE FROM A STRING ... 
	private static void addprod() throws Exception {
		try {
			
			 int y, m, d; 
			System.out.println("Introduce prothesis id : ");
			int id = Integer.parseInt(reader.readLine());
			localprod.setId(id);
			System.out.println("Introduce prothesis name : ");
			String name = reader.readLine();
			localprod.setName(name);
			System.out.println("Introduce prothesis bodypart : ");
			String bodypart = reader.readLine();
			localprod.setBodypart(bodypart);
			System.out.println("Introduce prothesis price : ");
			Float price = Float.parseFloat(reader.readLine());
			localprod.setPrice(price);
			System.out.println("Introduce prothesis creation's year : ");
			y = Integer.parseInt(reader.readLine());
			System.out.println("Introduce prothesis creation's month : ");
			m = Integer.parseInt(reader.readLine());
			System.out.println("Introduce prothesis creation's day : ");
			d = Integer.parseInt(reader.readLine());
			LocalDate ld =  LocalDate.of(y,m,d);
			ZoneId systemTimeZone = ZoneId.systemDefault();
			ZonedDateTime zonedDateTime = ld.atStartOfDay(systemTimeZone);
			Date date = (Date) Date.from(zonedDateTime.toInstant());
			localprod.setDate_creation(date);
			localprod.setCharacteristic(JDBCmethod.viewCharacteristicsFromProduct(id));
			localprod.setMats(JDBCmethod.viewMaterialsFromProduct(id));
			dbman.addProduct(localprod);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

