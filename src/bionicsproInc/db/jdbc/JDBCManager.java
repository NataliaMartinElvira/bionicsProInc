package bionicsproInc.db.jdbc;

import java.sql.*;

public class JDBCManager {
	 
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
	
	private void createTables(){
		Statement stmt1;
		try {
			stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE products "
						   + "(id INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " name TEXT NOT NULL, "
						   + " bodypart  TEXT UNIQUE NOT NULL,"
						   + " price REAL NOT NULL,"
						   + " date_creation DATE NOT NULL,"
						   + " photo BLOB,"
						   + " percentagefb REAL NOT NULL )";
				stmt1.executeUpdate(sql1);
				sql1 = "CREATE TABLE material "
						   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " name     TEXT     NOT NULL UNIQUE, "
						   + " price REAL NOT NULL,"
						   + " product_id INTEGER REFERENCE products(id),"
						   + " amount   INTEGER	 NOT NULL)";
				stmt1.executeUpdate(sql1);
				sql1= "CREATE TABLE customer "
						   + "(person_id INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " first_name     TEXT     NOT NULL, "
						   + " last_name   TEXT  	NOT NULL, "
						   + " age INTEGER NOT NULL,"
<<<<<<< HEAD
						   + " gender VARCHAR(10) check (gender in ('Male','Female'))"
						   + " phone INTEGER NOT NULL"
						   + " email TEXT NOT NULL"
						   + " street TEXT NOT NULL"
						   + " city TEXT NOT NULL"
						   + " postal_code INTEGER NOT NULL"
						   + " order_id INTEGER)";
=======
						   + "gender TEXT CHECK (gender = 'Male' OR gender = 'Female')"
						   + "phone INTEGER NOT NULL"
						   + "email TEXT NOT NULL"
						   + "street TEXT NOT NULL"
						   + "city TEXT NOT NULL"
						   + "postal_code INTEGER NOT NULL"
						   + "order_id INTEGER)";
>>>>>>> branch 'master' of https://github.com/NataliaMartinElvira/bionicsProInc.git
				stmt1.executeUpdate(sql1);
				stmt1.close();
		}catch(SQLException e) {
			if(!e.getMessage().contains("alredy exists")) {
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
	
}

