package bionicsproInc.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5234210426301713165L;
	private int id;
	private ArrayList<Product> products;

	public int getOrder_id() {
		return id;
	}

	public void setOrder_id(int order_id) {
		this.id = order_id;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(int id) {
		for (int i = 1; i <= this.products.size() - 1; i++) {
			int pId = this.products.get(i).getId();
			if (pId == id) {
				this.products.remove(i);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

}
