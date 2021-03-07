package bionicsproInc.ui;
import java.*;
import java.sql.Date;
import java.util.ArrayList; 


public class Engineer {
   private int id; 
   private String Name_surname; 
   private Date contract_strating_date; 
   private Date contract_ending_date; 
   private String current_service; 
   private float salary; 
   private float bonus; 
   private int project_achieved ; 
   private int experience_in_years; 
   private Date date_of_birth; 
   private ArrayList<Product> products; 
   
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName_surname() {
	return Name_surname;
}
public void setName_surname(String name_surname) {
	Name_surname = name_surname;
}
public Date getContract_strating_date() {
	return contract_strating_date;
}
public void setContract_strating_date(Date contract_strating_date) {
	this.contract_strating_date = contract_strating_date;
}
public Date getContract_ending_date() {
	return contract_ending_date;
}
public void setContract_ending_date(Date contract_ending_date) {
	this.contract_ending_date = contract_ending_date;
}
public String getCurrent_service() {
	return current_service;
}
public void setCurrent_service(String current_service) {
	this.current_service = current_service;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public float getBonus() {
	return bonus;
}
public void setBonus(float bonus) {
	this.bonus = bonus;
}
public int getProject_achieved() {
	return project_achieved;
}
public void setProject_achieved(int project_achieved) {
	this.project_achieved = project_achieved;
}
public int getExperience_in_years() {
	return experience_in_years;
}
public void setExperience_in_years(int experience_in_years) {
	this.experience_in_years = experience_in_years;
}
public Date getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(Date date_of_birth) {
	this.date_of_birth = date_of_birth;
}
public ArrayList<Product> getProducts() {
	return products;
}
public void setProducts(ArrayList<Product> products) {
	this.products = products; 
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Name_surname == null) ? 0 : Name_surname.hashCode());
	result = prime * result + Float.floatToIntBits(bonus);
	result = prime * result + ((contract_ending_date == null) ? 0 : contract_ending_date.hashCode());
	result = prime * result + ((contract_strating_date == null) ? 0 : contract_strating_date.hashCode());
	result = prime * result + ((current_service == null) ? 0 : current_service.hashCode());
	result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
	result = prime * result + experience_in_years;
	result = prime * result + id;
	result = prime * result + ((products == null) ? 0 : products.hashCode());
	result = prime * result + project_achieved;
	result = prime * result + Float.floatToIntBits(salary);
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
	Engineer other = (Engineer) obj;
	if (Name_surname == null) {
		if (other.Name_surname != null)
			return false;
	} else if (!Name_surname.equals(other.Name_surname))
		return false;
	if (Float.floatToIntBits(bonus) != Float.floatToIntBits(other.bonus))
		return false;
	if (contract_ending_date == null) {
		if (other.contract_ending_date != null)
			return false;
	} else if (!contract_ending_date.equals(other.contract_ending_date))
		return false;
	if (contract_strating_date == null) {
		if (other.contract_strating_date != null)
			return false;
	} else if (!contract_strating_date.equals(other.contract_strating_date))
		return false;
	if (current_service == null) {
		if (other.current_service != null)
			return false;
	} else if (!current_service.equals(other.current_service))
		return false;
	if (date_of_birth == null) {
		if (other.date_of_birth != null)
			return false;
	} else if (!date_of_birth.equals(other.date_of_birth))
		return false;
	if (experience_in_years != other.experience_in_years)
		return false;
	if (id != other.id)
		return false;
	if (products == null) {
		if (other.products != null)
			return false;
	} else if (!products.equals(other.products))
		return false;
	if (project_achieved != other.project_achieved)
		return false;
	if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
		return false;
	return true;
}


}
