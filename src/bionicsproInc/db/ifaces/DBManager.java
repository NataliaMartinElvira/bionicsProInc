package bionicsproInc.db.ifaces;

//import java.util.List;

import bionicsproInc.db.pojos.*;

public interface DBManager {
	public void connect();

	public void disconnect();

	public void addProduct(Product p);

	public void addCustomer(Customer cust);

	// Add new engineer
	// public void hireEngineer(Engineer eng);
	public void addEngineer(Engineer eng);

	// getting an existed engineer
	public Engineer getEngineer(int id);

	public void addCharacteristic(Characteristic c);

	public Characteristic getCharacteristic(int id);

	public void addMaterial(Material m);
	
	public void addProdIntoMat(Product p);
	
	public void addMatIntoProd(Material m);
}
