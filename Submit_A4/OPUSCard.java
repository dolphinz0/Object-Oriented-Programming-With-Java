// -------------------------------------------------------
// Assignment 4
// Written by: Michael Nittolo 40203394
// For COMP 248 Section ECD – Fall 2021
// --------------------------------------------------------

//OPUSCard class, contains type, name, expiration date of OPUSCard
public class OPUSCard {

	private String OPUSType;
	private String cardholder;
	private int expiryMonth;
	private int expiryYear;
	
	public OPUSCard() {
		OPUSType = "STM";
		expiryMonth = 12;
		expiryYear = 2022;
	}
	
	public OPUSCard(String type, String name, int month, int year) {
		OPUSType = type;
		cardholder = name;
		expiryMonth = month;
		expiryYear = year;
	}
	
	public OPUSCard(OPUSCard opus) {
		OPUSType = opus.OPUSType;
		cardholder = opus.cardholder;
		expiryMonth = opus.expiryMonth;
		expiryYear = opus.expiryYear;
	}
	
	public String getOPUSType() {
		return this.OPUSType;
	}
	
	public String getCardholder() {
		return this.cardholder;
	}
	
	public int getExpiryMonth() {
		return this.expiryMonth;
	}
	
	public int getExpiryYear() {
		return this.expiryYear;
	}
	
	public void setExpiryMonth(int month) {
		if (month <= 12 && month > 0)
			this.expiryMonth = month;
		else
			this.expiryMonth = 0;
	}
	
	public void setExpiryYear(int year) {
		this.expiryYear = year;
	}
	
	public String toString() {
		String expString = this.expiryMonth + "/" + this.expiryYear;
		if (this.expiryMonth < 10)
			expString = "0" + expString;
		return ("Type of OPUS card:\t" + this.OPUSType +
				"\nName of Cardholder:\t" + this.cardholder +
				"\nExpiration Date:\t" + expString + "\n");
	}
	
	public boolean equals(OPUSCard other) {
		if (this.OPUSType == other.OPUSType && 
			this.cardholder == other.cardholder &&
			this.expiryMonth == other.expiryMonth &&
			this.expiryYear == other.expiryYear)
			return true;
		else
			return false;
	}
	
}
