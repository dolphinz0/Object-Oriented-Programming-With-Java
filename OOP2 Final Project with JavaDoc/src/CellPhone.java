import java.util.Scanner;
//-----------------------------------------------------
//Assignment 4
//Question: CellPhone
//Written by: Michael Nittolo 40203394
//-----------------------------------------------------
/**
 * CellPhone class that has serialNum, brand, year, price
 * @author Gamer
 *
 */
public class CellPhone {
	long serialNum;
	String brand;
	int year;
	double price;
	public CellPhone(CellPhone o, long ser) {
		super();
		this.serialNum = ser;
		this.brand = o.brand;
		this.year = o.year;
		this.price = o.price;
	}
	public CellPhone(long serialNum, String brand, int year, double price) {
		super();
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a serial number for the new CellPhone: ");
		long serial = kb.nextLong();
		kb.close();
		return new CellPhone(serial, this.brand, this.year, this.price);
	}
	public String toString() {
		return "[" + serialNum + ": " + brand + " $" + price + " " + year + "]";
	}
	public boolean equals(CellPhone o) {
		if (this.brand.equals(o.brand) && this.price == o.price && this.year == o.year)
			return true;
		else
			return false;
	}
}
