package bionicsproInc.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class Characteristic implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8095684428083579778L;
	private int id; 
	private float length; 
	private float width; 
	private float weight; 
	private float height; 
	private int joints_numb; 
	private int flexibilty_scale; 
	private ArrayList<Product> products; 
	public int getId() {
		return id;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	} 
	public void setId(int id) {
		this.id = id;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getJoints_numb() {
		return joints_numb;
	}
	public void setJoints_numb(int joints_numb) {
		this.joints_numb = joints_numb;
	}
	public int getFlexibilty_scale() {
		return flexibilty_scale;
	}
	public void setFlexibilty_scale(int flexibilty_scale) {
		this.flexibilty_scale = flexibilty_scale;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flexibilty_scale;
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + id;
		result = prime * result + joints_numb;
		result = prime * result + Float.floatToIntBits(length);
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
		result = prime * result + Float.floatToIntBits(width);
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
		Characteristic other = (Characteristic) obj;
		if (flexibilty_scale != other.flexibilty_scale)
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (id != other.id)
			return false;
		if (joints_numb != other.joints_numb)
			return false;
		if (Float.floatToIntBits(length) != Float.floatToIntBits(other.length))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}
	

}
