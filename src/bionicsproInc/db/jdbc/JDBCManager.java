package bionicsproInc.db.jdbc;

import java.sql.*;
import bionicsproInc.db.ifaces.DBManager;
import bionicsproInc.db.pojos.*;

;

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
		Statement stmt1;
		try {
			stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE products " + "(id INTEGER  PRIMARY KEY AUTOINCREMENT," + " name TEXT NOT NULL, "
					+ " bodypart  TEXT UNIQUE NOT NULL," + " price REAL NOT NULL," + " date_creation DATE NOT NULL,"
					+ " photo BLOB )";
			stmt1.executeUpdate(sql1);
			sql1 = "CREATE TABLE material " + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name     TEXT     NOT NULL UNIQUE, " + " price REAL NOT NULL,"
					+ " product_id INTEGER REFERENCE products(id)," + " amount   INTEGER	 NOT NULL)";
			stmt1.executeUpdate(sql1);
			sql1 = "CREATE TABLE customer " + "(person_id INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " first_name     TEXT     NOT NULL, " + " last_name   TEXT  	NOT NULL, "
					+ " age INTEGER NOT NULL," + " gender TEXT CHECK(gender = 'Male' OR gender = 'Female')"
					+ " phone INTEGER NOT NULL" + " email TEXT NOT NULL" + " street TEXT NOT NULL"
					+ " city TEXT NOT NULL" + " postal_code INTEGER NOT NULL" + " order_id INTEGER)";
			stmt1.executeUpdate(sql1);
			sql1 = "CREATE TABLE engineer " + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " Name_surname     TEXT     NOT NULL UNIQUE, " + " contract_starting_date DATE NOT NULL UNIQUE,"
					+ " contract_ending_date DATE NOT NULL," + " current_service TEXT NOT NULL,"
					+ " salary REAL NOT NULL," + " bonus REAL NOT NULL," + " project_achieved INTEGER NOT NULL,"
					+ " experience_in_years INTEGER NOT NULL," + " date_of_birth DATE NOT NULL,"
					+ " id_eng_prod INTEGER REFERENCE products(id)";
			stmt1.executeUpdate(sql1);
			sql1 = "CREATE TABLE chatacteristics " + " length REAL NOT NULL," + " width REAL NOT NULL,"
					+ " weight REAL NOT NULL," + " joint_numb INTEGER NOT NULL,"
					+ " flexibility_scale INTEGER NOT NULL," + " id_char_prod INTEGER REFERENCE products(id)";
			stmt1.executeUpdate(sql1);
			sql1 = "CREATE TABLE order" + "order_id INTEGET PRIMARY KEY NOT NULL,"
					+ "product_id INTEGER NOT NULL REFERENCE products(id)";
			stmt1.executeUpdate(sql1);

			stmt1.close();
		} catch (SQLException e) {
			if (!e.getMessage().contains("alredy exists")) {
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
			String sql = "INSERT INTO product (name,bodypart,price,date_creation,photo) " + " VALUES('" + p.getName()
					+ "','" + p.getBodypart() + "','" + p.getPrice() + "','" + p.getDate_creation() + "','"
					+ p.getPhoto() + "')'";
			st1.executeUpdate(sql);
			st1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMaterial(Material m) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO material (name,price,product,amount) " + " VALUES ('" + m.getName() + "','"
					+ m.getPrice() + "','" + m.getProducts() + "','" + m.getAmount() + "')'";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCustomer(Customer cust) {
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO customer (first_name, last_name, age, gender, phone, email, street, city, postal_code, order_id) "
					+ " VALUES ('" + cust.getFirst_name() + "', '" + cust.getLast_name() + "','" + cust.getAge() + "','"
					+ cust.getGender() + "','" + cust.getPhone() + "', " + "'" + cust.getEmail() + "','"
					+ cust.getStreet() + "','" + cust.getCity() + "','" + cust.getPostal_code() + "','"
					+ cust.getOrder_id() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addEngineer(Engineer eng) {
		try {

			Statement stmt = c.createStatement();
			String sql = " INSERT INTO people (Name_surname,contract_strating_date,contract_ending_date,current_service,salary,bonus,project_achieved,"
<<<<<<< HEAD
					   + " experience_in_years,date_of_birth,products)"
					   + ") VALUES ('" + eng.getName_surname() + "','" 
					   + eng.getContract_strating_date() + "','" + eng.getContract_ending_date() 
					   
					   + "','" + eng.getCurrent_service() + "','" 
					   + eng.getSalary() + "','" + eng.getProject_achieved() + "','" 
					   + eng.getExperience_in_years() + "','" + eng.getDate_of_birth() + "','" 
					   + eng.getProducts() + "')";
=======
					+ " experience_in_years,date_of_birth,products)" + ") VALUES ('" + eng.getName_surname() + "','"
					+ eng.getContract_strating_date() + "','" + eng.getContract_ending_date() + "','"
					+ eng.getCurrent_service() + "','" + eng.getSalary() + "','" + eng.getProject_achieved() + "','"
					+ eng.getExperience_in_years() + "','" + eng.getDate_of_birth() + "','" + eng.getProducts() + "')";
>>>>>>> branch 'master' of https://github.com/NataliaMartinElvira/bionicsProInc
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
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

}
