package bionicsproInc.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

enum Gender {
	MALE, FEMALE;
}

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8505884502597501683L;
	private int id;
	private String first_name;
	private String last_name;
	private int age;
	private Gender gender;
	private int phone;
	private String email;
	private String street;
	private String city;
	private int postal_code;
	private ArrayList<Order> orders;
	private int order_id;

	public Customer(int id, String first_name, String last_name, int age, String gender, int phone, String email,
			String street, String city, int postal_code, ArrayList<Order> orders) {

		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = Gender.valueOf(gender);
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.postal_code = postal_code;
		this.orders = orders;
	}
	
	public Customer(int id, String first_name, String last_name, int age, String gender, int phone, String email,
			String street, String city, int postal_code, int order_id) {

		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = Gender.valueOf(gender);
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.postal_code = postal_code;
		this.order_id = order_id;
	}

	public Customer(int id, ArrayList<Order> orders) {
		super();
		this.id = id;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = Gender.valueOf(gender);
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + phone;
		result = prime * result + postal_code;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Customer other = (Customer) obj;
		if (gender != other.gender)
			return false;
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (phone != other.phone)
			return false;
		if (postal_code != other.postal_code)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
