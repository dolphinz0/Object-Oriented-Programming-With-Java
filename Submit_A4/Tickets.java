// -------------------------------------------------------
// Assignment 4
// Written by: Michael Nittolo 40203394
// For COMP 248 Section ECD – Fall 2021
// --------------------------------------------------------

//Tickets class that contains constants for the values of the tickets type and variables for the numbers of each ticket type
public class Tickets {
	
	private final double REGULAR = 3.5;
	private final double JUNIOR = 2.5;
	private final double SENIOR = 1;
	private final double DAILY = 10;
	private final double WEEKLY = 40;
	
	private int numRegular;
	private int numJunior;
	private int numSenior;
	private int numDaily;
	private int numWeekly;

	public Tickets() {
		
	}

	public Tickets(int r, int j, int s, int d, int w) {
		numRegular = r;
		numJunior = j;
		numSenior = s;
		numDaily = d;
		numWeekly = w;
	}
	
	public Tickets(Tickets copy) {
		numRegular = copy.numRegular;
		numJunior = copy.numJunior;
		numSenior = copy.numSenior;
		numDaily = copy.numDaily;
		numWeekly = copy.numWeekly;
	}

	public int getNumRegular() {
		return numRegular;
	}
	
	public int getNumJunior() {
		return numJunior;
	}
	
	public int getNumSenior() {
		return numSenior;
	}
	
	public int getNumDaily() {
		return numDaily;
	}
	
	public int getNumWeekly() {
		return numWeekly;
	}
	
	public void setNumRegular(int r) {
		numRegular = r;
	}
	
	public void setNumJunior(int j) {
		numJunior = j;
	}
	
	public void setNumSenior(int s) {
		numSenior = s;
	}
	
	public void setNumDaily(int d) {
		numDaily = d;
	}
	
	public void setNumWeekly(int w) {
		numWeekly = w;
	}
	
	public void addTickets(int r, int j, int s, int d, int w) {
		numRegular += r;
		numJunior += j;
		numSenior += s;
		numDaily += d;
		numWeekly += w;
	}
	
	public double ticketsTotal() {
		return (numRegular * REGULAR 
				+ numJunior * JUNIOR 
				+ numSenior * SENIOR 
				+ numDaily * DAILY 
				+ numWeekly * WEEKLY);
	}
	
	public String toString() {
		return ("The count of tickets is:\n"
				+ "\nRegular:\t" + numRegular 
				+ "\nJunior:\t\t" + numJunior 
				+ "\nSenior:\t\t" + numSenior
				+ "\nDaily:\t\t" + numDaily
				+ "\nWeekly:\t\t" + numWeekly + "\n\n");
	}
	
	public boolean equals(Tickets other) {
		if (numRegular == other.numRegular && 
			numJunior == other.numJunior &&
			numSenior == other.numSenior &&
			numDaily == other.numDaily &&
			numWeekly == other.numWeekly)
			return true;
		else
			return false;
	}
	
}
