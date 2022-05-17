// -------------------------------------------------------
// Assignment 4
// Written by: Michael Nittolo 40203394
// For COMP 248 Section ECD – Fall 2021
// --------------------------------------------------------

//Ticketbooth Class, contains an Array of OPUSCards, and a Tickets class
public class Ticketbooth {
	private Tickets tickets;
	private OPUSCard[] opusCards;
	
	//Default constructor sets opusCards to null and makes a new default Tickets
	public Ticketbooth() {
		tickets = new Tickets();
		opusCards = null;
	}
	
	//Ticketbooth constructor with arguments
	public Ticketbooth(Tickets tics, OPUSCard[] cards) {
		tickets = tics;
		opusCards = cards;
	}
	
	//Check another Ticketbooth for equal Tickets value
	public boolean equalTicketValue(Ticketbooth other) {
		if (ticketsValue() == other.ticketsValue())
			return true;
		else
			return false;
	}

	//Check another Ticektbooth for equal Tickets' distribution
	public boolean equalTicketNum(Ticketbooth other) {
		if (tickets.equals(other.tickets))
			return true;
		else
			return false;
	}
	
	//returns value of Tickets in  assigned to Ticketbooth
	public double ticketsValue() {
		return tickets.ticketsTotal();
	}
	
	//If opusCards is null, returns 0, otherwise return length of opusCards Array
	public int numOpus() {
		return opusCards == null ? 0 : opusCards.length;
	}
	
	//Adds a new OPUSCard to opusCards by creating a new Array and assigning it
	public int addOpus(OPUSCard newCard) {
		OPUSCard[] newCards = new OPUSCard[numOpus() + 1];
		for (int i = 0; i < numOpus(); i++) {
			newCards[i] = opusCards[i];
		}
		newCards[numOpus()] = newCard;
		opusCards = newCards;
		return numOpus();
	}
	
	//Removes an OPUSCard from opusCards by creating a smaller array and not adding the index of that OPUSCard to the new Array 
	public boolean delOpus(int deleting) {
		boolean deleted = false;
		if (deleting >= numOpus())
			deleted = false;
		else
		{
			OPUSCard[] newCards = new OPUSCard[numOpus() - 1];
			int count = 0;
			for (int i = 0; i < numOpus(); i++) {
				if (!(i==deleting)) {
					newCards[count] = opusCards[i];
					count++;
			
			}
			deleted = true;
		}
			opusCards = newCards;
		}
		return deleted;
	}
	
	//Update the expiration of an OPUSCard in opusCards by using methods of the OPUSCard class
	public void updateExpiry(int updating, int month, int year) {
		boolean updated = false;
		for (int i = 0; i < numOpus() && !updated; i++) {
			if (opusCards[i].equals(opusCards[updating])) {
				opusCards[updating].setExpiryMonth(month);
				opusCards[updating].setExpiryYear(year);
			}
		}
	}
	
	//Add Tickets to the tickets variable by using methods from the Tickets class
	public double addTickets(int r, int j, int s, int d, int w) {
		tickets.setNumRegular(tickets.getNumRegular()+r);
		tickets.setNumJunior(tickets.getNumJunior()+j);
		tickets.setNumSenior(tickets.getNumSenior()+s);
		tickets.setNumDaily(tickets.getNumDaily()+d);
		tickets.setNumWeekly(tickets.getNumWeekly()+w);
		return ticketsValue();
	}
	
	//Checks if another Ticketbooth is equal to this one
 	public boolean equals(Ticketbooth other) {
		if (equalTicketValue(other))
			if (opusCards == null && other.opusCards == null)
				return true;
			else if (opusCards == null || other.opusCards == null)
				return false;
			else
				if (opusCards.length == other.opusCards.length)
					return true;
		return false;
	}
	
 	//toString method
 	public String toString() {
 		String result = tickets.toString();
 		if(opusCards == null)
 			result += "No OPUS cards\n\n";
 		else
 		{
 		for (int i = 0; i < numOpus(); i++) {
 			result+=opusCards[i].toString();
 			result+="\n";
 		}
 		}
 		return result;
 	}
 	
 	//String method for only seeing the Tickets
 	public String ticketsString() {
 		return tickets.toString();
 	}
 	
}
