package bionicsproInc.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

abstract class Product {
	private int id;
	private String name;
	private String bodypart;
	private Float price;
	private Date date_creation;
	private byte[] photo;
	private ArrayList <Material> mats;
	private Float percentageFb;
	private ArrayList <Characteristic> christ;
	private ArrayList <Customer> customers;
	

	public Product(int id, String name, String bodypart, Float price, Date date_creation, byte[] photo,
			ArrayList<Material> mats, Float percentageFb) {
		super();
		this.id = id;
		this.name = name;
		this.bodypart = bodypart;
		this.price = price;
		this.date_creation = date_creation;
		this.photo = photo;
		this.mats = mats;
		this.percentageFb = percentageFb;
	}
	
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
	public Float getPercentageFb() {
		return percentageFb;
	}
	public void setPercentageFb(Float percentageFb) {
		this.percentageFb = percentageFb;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodypart == null) ? 0 : bodypart.hashCode());
		result = prime * result + ((christ == null) ? 0 : christ.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((date_creation == null) ? 0 : date_creation.hashCode());
		result = prime * result + id;
		result = prime * result + ((mats == null) ? 0 : mats.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percentageFb == null) ? 0 : percentageFb.hashCode());
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
		if (christ == null) {
			if (other.christ != null)
				return false;
		} else if (!christ.equals(other.christ))
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
		if (percentageFb == null) {
			if (other.percentageFb != null)
				return false;
		} else if (!percentageFb.equals(other.percentageFb))
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
	
	
	
}
