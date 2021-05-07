package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import bionicsproInc.db.jdbc.JDBCManager;
import bionicsproInc.db.pojos.Engineer;
import bionicsproInc.db.pojos.Product;

public class Main {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException, IOException {
		JDBCManager j = new JDBCManager();
		j.connect();

	/*	System.out.println("Introduce contract start : ");
		LocalDate startDate = LocalDate.parse(reader.readLine(), formatter);
		System.out.println("Introduce contract end : ");
		LocalDate endDate = LocalDate.parse(reader.readLine(), formatter);
		System.out.println("Introduce birthdate : ");
		LocalDate birthtDate = LocalDate.parse(reader.readLine(), formatter);
		
		
		Engineer e = new Engineer(4,"Mamadu Bongo",Date.valueOf(startDate),Date.valueOf(endDate),"Developpement service",5000.00f,2000.00f,2,4,Date.valueOf(birthtDate));
		j.addEngineer(e); */
		
		j.disconnect();
	}

}
