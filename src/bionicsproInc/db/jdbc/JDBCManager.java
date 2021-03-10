package bionicsproInc.db.jdbc;
import java.sql.*;
 public class JDBCManager {
	 
	private void createTables(){
		Statement stmt1;
		try {
			stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE products "
						   + "(id INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " name TEXT NOT NULL, "
						   + " bodypart  TEXT UNIQUE NOT NULL,"
						   + "price FLOAT NOT NULL,"
						   + "date_creation DATE NOT NULL,"
						   + "photo BLOB,"
						   + "percentagefb FLOAT NOT NULL )";
				stmt1.executeUpdate(sql1);
				sql1 = "CREATE TABLE material "
						   + "(id       INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " name     TEXT     NOT NULL UNIQUE, "
						   + "price FLOAT NOT NULL,"
						   +"product_id INTEGER REFERENCE products(id),"
						   + " amount   INTEGER	 NOT NULL)";
				stmt1.executeUpdate(sql1);
				sql1= "CREATE TABLE customer "
						   + "(person_id INTEGER  PRIMARY KEY AUTOINCREMENT,"
						   + " first_name     TEXT     NOT NULL, "
						   + " last_name   TEXT  	NOT NULL, "
						   + " age INTEGER NOT NULL,"
						   + "gender VARCHAR(10) check (gender in ('Male','Female'))"
						   + "phone INTEGER NOT NULL"
						   + "email TEXT NOT NULL"
						   + "street TEXT NOT NULL"
						   + "city TEXT NOT NULL"
						   + "postal_code INTEGER NOT NULL"
						   + "order_id INTEGER)";
				stmt1.executeUpdate(sql1);
				stmt1.close();
		}catch(SQLException e) {
			if(!e.getMessage().contains("alredy exists")) {
				e.printStackTrace();
			}
		}
	}
}
