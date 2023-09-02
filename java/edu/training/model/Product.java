package edu.training.model;

public class Product {
private int pid;
private String pname;
private String pdesc;
private double price;
private int quantity;
public Product(){
}

public Product(int pid, String pname, String pdesc, double price, int quantity) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pdesc = pdesc;
	this.price = price;
	this.quantity = quantity;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPdesc() {
	return pdesc;
}

public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", price=" + price + ", quantity="
			+ quantity + "]";
}


}
