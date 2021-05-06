package bionicsproInc.db.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bionicsproInc.db.ifaces.DBManager;
import bionicsproInc.db.pojos.*;

public class JDBCManager implements DBManager {
	private Connection c;

	public void connect() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/bionicsproInc.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			this.createTables();
		} catch (SQLException sqlE) {
			System.out.println("There was a database exception.");
			sqlE.printStackTrace();
		} catch (Exception e) {
			System.out.println("There was a general exception.");
			e.printStackTrace();
		}
	}

	private void createTables() {

		try {
			Statement stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE products " + "(id INTEGER  PRIMARY KEY AUTOINCREMENT," + " name TEXT NOT NULL, "
					+ " bodypart  TEXT UNIQUE NOT NULL," + " price REAL NOT NULL," + " date_creation DATE NOT NULL,"
					+ " photo BLOB )";
			stmt1.executeUpdate(sql1);
			stmt1.close();

			Statement stmt2 = c.createStatement();
			String sql2 = "CREATE TABLE material " + "(id INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name     TEXT     NOT NULL UNIQUE, " + " price REAL NOT NULL," + " amount   INTEGER	 NOT NULL)";
			stmt2.executeUpdate(sql2);
			stmt2.close();

			Statement stmt3 = c.createStatement();
			String sql3 = "CREATE TABLE customer " + "(id INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " first_name     TEXT     NOT NULL, " + " last_name   TEXT  	NOT NULL, "
					+ " age INTEGER NOT NULL," + " gender TEXT NOT NULL,"
					+ " phone INTEGER NOT NULL," + " email TEXT NOT NULL," + " street TEXT NOT NULL,"
					+ " city TEXT NOT NULL," + " postal_code INTEGER NOT NULL)";
			stmt3.executeUpdate(sql3);
			stmt3.close();

			Statement stmt4 = c.createStatement();
			String sql4 = "CREATE TABLE engineer " + "(id INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name_surname     TEXT     NOT NULL UNIQUE, " + " contract_starting_date DATE NOT NULL UNIQUE,"
					+ " contract_ending_date DATE NOT NULL," + " current_service TEXT NOT NULL,"
					+ " salary REAL NOT NULL," + " bonus REAL NOT NULL," + " project_achieved INTEGER NOT NULL,"
					+ " experience_in_years INTEGER NOT NULL," + " date_of_birth DATE NOT NULL,"
					+ " product_id INETEGR NOT NULL REFERENCES products(id))";
			stmt4.executeUpdate(sql4);
			stmt4.close();

			Statement stmt5 = c.createStatement();
			String sql5 = "CREATE TABLE characteristics " + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " length REAL NOT NULL," + " width REAL NOT NULL," + " weight REAL NOT NULL,"
					+ " joint_numb INTEGER NOT NULL," + " flexibility_scale INTEGER NOT NULL)";
			stmt5.executeUpdate(sql5);
			stmt5.close();

			//TODO Repasar las tablas bien
			/*Statement stmt6 = c.createStatement();
			String sql6 = "CREATE TABLE order " + "(order_id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " product_id INTEGER  REFERENCES products(id))";
			stmt6.executeUpdate(sql6);
			stmt6.close();*/

			// now we create the table that references the N-N relationships

			Statement stmt7 = c.createStatement();
			String sql7 = "CREATE TABLE products_materials " + "(product_id  INTEGER REFERENCES products(id),"
					+ " material_id INTEGER REFERENCES material(id))";
			stmt7.executeUpdate(sql7);
			stmt7.close();

			Statement stmt8 = c.createStatement();
			String sql8 = "CREATE TABLE products_customers " + "(product_id INTEGER REFERENCES products(id),"
					+ " customer_id INTEGER REFERENCES customer(id))";
			stmt8.executeUpdate(sql8);
			stmt8.close();

			Statement stmt9 = c.createStatement();
			String sql9 = "CREATE TABLE engineers_products " + "(engineer_id INTEGER REFERENCES engineer(id),"
					+ " product_id INTEGER REFERENCES products(id))";
			stmt9.executeUpdate(sql9);
			stmt9.close();

			Statement stmt10 = c.createStatement();
			String sql10 = "CREATE TABLE characteristics_product"
					+ "(characteristics_id INTEGER REFERENCES products(id),"
					+ " products_id INTEGER REFERENCES products(id))";

			stmt10.execute(sql10);
			stmt10.close();

			/*TODO REVISAR
			 * Statement stmt11 = c.createStatement();
			 
			String sql11 = " CREATE TABLE customer_order " + "(customer_id INTEGER REFERENCES customer(id), "
					+ " order_id INTEGER REFERENCES order(order_id))";
			stmt11.executeUpdate(sql11);
			stmt11.close();*/

		} catch (SQLException e) {
			if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			}
		}
	}

	public void disconnect() {
		try {
			// Close database connection
			c.close();
		} catch (SQLException e) {
			System.out.println("There was a problem while closing the database connection.");
			e.printStackTrace();
		}
	}

	public void addProduct(Product p) {
		try {
			Statement st1 = c.createStatement();
			String sql = "INSERT INTO products (name,bodypart,price,date_creation) " + " VALUES('" + p.getName()
					+ "','" + p.getBodypart() + "','" + p.getPrice() + "','" + p.getDate_creation() + "','"
					+  "')'";
			st1.executeUpdate(sql);
			st1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMaterial(Material m) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO material (name,price,amount) " + " VALUES ('" + m.getName() + "','" + m.getPrice()
					+ "','" + m.getAmount() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addMatIntoProd(Material m) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO products_materials (material_id) " + " VALUES ('" + m.getId() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProdIntoMat(Product p) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO products_materials (product_id) " + " VALUES ('" + p.getId() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCustIntoProd(Customer cust) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO products_customers (customer_id) " + " VALUES ('" + cust.getId() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProdIntoCust(Product p) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO products_customers (product_id) " + " VALUES ('" + p.getId() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCustomer(Customer cust) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO customer (first_name, last_name, age, gender, phone, email, street, city, postal_code) "
					+ " VALUES ('" + cust.getFirst_name() + "', '" + cust.getLast_name() + "','" + cust.getAge() + "','"
					+ cust.getGender() + "','" + cust.getPhone() + "', " + "'" + cust.getEmail() + "','"
					+ cust.getStreet() + "','" + cust.getCity() + "','" + cust.getPostal_code() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEngineer(Engineer eng) {
		try {

			Statement stmt = c.createStatement();
			String sql = " INSERT INTO people (name_surname,contract_strating_date,contract_ending_date,current_service,salary,bonus,project_achieved,"
					+ " experience_in_years,date_of_birth,products)" + ") VALUES ('" + eng.getName_surname() + "','"
					+ eng.getContract_strating_date() + "','" + eng.getContract_ending_date() + "','"
					+ eng.getCurrent_service() + "','" + eng.getSalary() + "','" + eng.getProject_achieved() + "','"
					+ eng.getExperience_in_years() + "','" + eng.getDate_of_birth() + "','" + eng.getProducts() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void addOrder(Order o) {
		try {
			Statement stmt=c.createStatement();
			String sql= " INSERT INTO customer_order (order_id) VALUES ('"+ o.getOrder_id()+ "')";
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Engineer getEngineer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCharacteristic(Characteristic c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Characteristic getCharacteristic(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewBodyparts() {
		List<String> bodyPart = new ArrayList<String>();
		try {
			String sql = " SELECT DISTINCT bodypart FROM products ";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String part = rs.getString("bodypart");
				bodyPart.add(part);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bodyPart;
	}

	@Override
	public List<Product> searchProductByBody(String bodypart) {
		List<Product> products = new ArrayList<Product>();
		try {
			String sql = "SELECT name FROM products WHERE bodypart LIKE ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, "%" + bodypart + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String productname = rs.getString("name");
				Product p = new Product(id, productname);
				products.add(p);
			}
			rs.close();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void removeProd(int prodId) {
		try {
			String sql = "DELETE FROM products WHERE id = ? ";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, prodId);
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Engineer viewBonus(int engId) {
		try {
			String sql = "SELECT id,bonus FROM Engineer WHERE id= ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, engId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Engineer(engId, rs.getFloat("bonus"));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// LIKE ADDTOCART- THE SAME FUNCTION
	public void addToOrder(Product product, Order order) {

		try {
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO order (order_id,product_id) " + " VALUES ('" + order.getOrder_id() + "','"
					+ product.getId() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		order.addProduct(product);

	}


	public List<String> viewCart(Order o) {
		List<String> p_names = new ArrayList<String>();
		try {
			String sql = " SELECT p.name FROM products AS p JOIN order AS or ON or.product_id=p.id WHERE or.order_id= ? ";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, o.getOrder_id());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String productName = rs.getString("name");
				p_names.add(productName);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p_names;
	}

	@Override
	public List<Integer> viewOtherOrders(int id) {
		List<Integer> Ids = new ArrayList<Integer>();
		try {
			String sql = " SELECT c.order_id FROM costumer_order AS c WHERE c.costumer_id= ? ";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int ids = rs.getInt(id);
				Ids.add(ids);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Ids;
	}

	public List<String> viewProjectAchieved(int engId) {
		List<String> prodname = new ArrayList<String>();
		try {
			String sql = "SELECT e.id, p.name FROM Engineer as e JOIN product as p ON p.id=e.product_id WHERE id= ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, engId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String pname = rs.getString("name");
				prodname.add(pname);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prodname;
	}

	public void deleteProdFromCart(String name, Order o) {
		try {
			String sql = "SELECT id FROM products WHERE name = ? ";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("product_id");
				o.removeProduct(id);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Characteristic> viewCharacteristicsFromProduct(int prodId) {
		ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
		try {
			String sql = "SELECT c.*, p.id FROM characteristics_product as cp JOIN characteristics as c "
					+ "ON cp.characteristic_id = c.id JOIN products as p ON cp.products_id = p.id WHERE p.id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, prodId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				float length = rs.getFloat("length");
				float width = rs.getFloat("width");
				float weight = rs.getFloat("weight");
				float height = rs.getFloat("height");
				int joints_numb = rs.getInt("joints_numb");
				int flexibilty_scale = rs.getInt("flexibilty_scale");
				Characteristic c = new Characteristic(id, length, width, weight, height, joints_numb, flexibilty_scale);
				characteristics.add(c);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return characteristics;
	}

	public ArrayList<Material> viewMaterialsFromProduct(int prodId) {
		ArrayList<Material> materials = new ArrayList<Material>();
		try {
			String sql = "SELECT m.*, p.id FROM products_materials as pm JOIN materials as m "
					+ "ON pm.material_id = m.id JOIN products as p ON pm.products_id = p.id WHERE p.id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, prodId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int amount = rs.getInt("amount");
				Material m = new Material(id, name, price, amount);

				materials.add(m);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materials;
	}
	// METHOD USED BY CUSTOMER TO VIEW PRODUCTS OF OTHER ORDERS ALREADY MADE
	public List<Product> viewProductsFromOrder(int orderId) {
		List<Product> products = new ArrayList<Product>();
		try {
			String sql = "SELECT p.*, o.order_id, p.product_id FROM order as o JOIN product as p ON o.product_id=p.id WHERE o.order_id = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, orderId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String productname = rs.getString("name");
				Product p = new Product(id, productname);
				products.add(p);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;

	}
	
	

}