package bionicsproInc.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2448117025953730410L;
	private int id;
	private String name;
	private String bodypart;
	private Float price;
	private Date date_creation;
	private byte[] photo;
	private ArrayList <Material> mats;
	private ArrayList <Characteristic> characteristic;
	private ArrayList <Customer> customers; 
	private ArrayList <Engineer> engineer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBodypart() {
		return bodypart;
	}
	public void setBodypart(String bodypart) {
		this.bodypart = bodypart;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public ArrayList<Material> getMats() {
		return mats;
	}
	public void setMats(ArrayList<Material> mats) {
		this.mats = mats;
	}
	public ArrayList<Characteristic> getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(ArrayList<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Engineer> getEngineer() {
		return engineer;
	}
	public void setEngineer(ArrayList<Engineer> engineer) {
		this.engineer = engineer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodypart == null) ? 0 : bodypart.hashCode());
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((date_creation == null) ? 0 : date_creation.hashCode());
		result = prime * result + ((engineer == null) ? 0 : engineer.hashCode());
		result = prime * result + id;
		result = prime * result + ((mats == null) ? 0 : mats.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (bodypart == null) {
			if (other.bodypart != null)
				return false;
		} else if (!bodypart.equals(other.bodypart))
			return false;
		if (characteristic == null) {
			if (other.characteristic != null)
				return false;
		} else if (!characteristic.equals(other.characteristic))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (date_creation == null) {
			if (other.date_creation != null)
				return false;
		} else if (!date_creation.equals(other.date_creation))
			return false;
		if (engineer == null) {
			if (other.engineer != null)
				return false;
		} else if (!engineer.equals(other.engineer))
			return false;
		if (id != other.id)
			return false;
		if (mats == null) {
			if (other.mats != null)
				return false;
		} else if (!mats.equals(other.mats))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	public Product(int id, String name, String bodypart, Float price, Date date_creation, byte[] photo,
			ArrayList<Material> mats, ArrayList<Characteristic> characteristic, ArrayList<Customer> customers,
			ArrayList<Engineer> engineer) {
		super();
		this.id = id;
		this.name = name;
		this.bodypart = bodypart;
		this.price = price;
		this.date_creation = date_creation;
		this.photo = photo;
		this.mats = mats;
		this.characteristic = characteristic;
		this.customers = customers;
		this.engineer = engineer;
	}
	
	
	
	
}
