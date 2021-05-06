package main;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bionicsproInc.db.jdbc.JDBCManager;
import bionicsproInc.db.pojos.Engineer;
import bionicsproInc.db.pojos.Product;

public class Main {

	public static void main(String[] args) throws ParseException {
		JDBCManager j = new JDBCManager();
		j.connect();

		Date d1  = new Date(2009,10,10);
		Date d2 = new Date(2022,10,10);
		Date d3 = new Date(1983,02,04);
		
		Engineer e = new Engineer(1,"Jack Browne",d1,d2,"production control",4000.00f,3000.00f,3,8,d3);
		j.addEngineer(e);
		
		j.disconnect();
	}

}
