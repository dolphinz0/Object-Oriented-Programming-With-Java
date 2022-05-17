// -------------------------------------------------------
// Assignment 4
// Written by: Michael Nittolo 40203394
// For COMP 248 Section ECD – Fall 2021
// --------------------------------------------------------

import java.util.Scanner;
//This is the Driver to test the classes
public class Driver {

	public static void main(String[] args) {
		//Open Program
		Scanner kb = new Scanner(System.in);
		//Declare and initialize five new Tickets that will go in Ticketbooths
		Tickets tickets = new Tickets(1,2,3,4,5);
		Tickets tickets2 = new Tickets(0,1,9,0,6);
		Tickets tickets3 = new Tickets(1,2,3,4,5);
		Tickets tickets4 = new Tickets(40, 10, 5, 30, 4);
		Tickets tickets1 = new Tickets(40, 10, 5, 30, 4);
		//Declare and initialize the OPUSCards and place the OPUSCards in OPUSCard Arrays
		OPUSCard card = new OPUSCard("STM", "Donatello", 9, 2022);
		OPUSCard card1 = new OPUSCard("STM", "Raphael", 9, 2024);
		OPUSCard card2 = new OPUSCard("STM", "Michelangelo", 9, 2024);
		OPUSCard card3 = new OPUSCard("STM", "Leonardo", 12, 2021);
		OPUSCard[] cards = {card, card1, card2, card3};
		OPUSCard card4 = new OPUSCard("REM", "John Constantine", 10, 2022);
		OPUSCard card5 = new OPUSCard("RTL", "John Wick", 11, 2022);
		OPUSCard card6 = new OPUSCard("STL", "Neo", 10, 2023);
		OPUSCard card7 = new OPUSCard("STM", "Johnny Silverhand", 12, 2021);
		OPUSCard[] cards2 = {card4, card5, card6, card7};
		OPUSCard card8 = new OPUSCard("STM", "Franklin", 5, 2022);
		OPUSCard card9 = new OPUSCard("STM", "Michael", 1, 2022);
		OPUSCard card10 = new OPUSCard("STL", "Trevor", 4, 2023);
		OPUSCard[] cards3 = {card8, card9, card10};
		//Declare and initialize five new Ticketbooths and assign to them a Tickets and OPUSCard Array
		Ticketbooth booth = new Ticketbooth(tickets, cards);
		Ticketbooth booth1 = new Ticketbooth(tickets3, cards2);
		Ticketbooth booth2 = new Ticketbooth(tickets2, cards3);
		Ticketbooth booth3 = new Ticketbooth(tickets4, null);
		Ticketbooth booth4 = new Ticketbooth(tickets1, null);
		//Declare and initialize and Array that will hold all the Ticketbooths used for performing tasks
		Ticketbooth[] grandBooth = {booth, booth1, booth2, booth3, booth4};
		//Declare and initialize variables that will be used to perform tasks on the Ticketbooths
		int choice=0;
		int initialChoice;
		boolean[][] compArr;
		String typeOpus = "";
		String nameOpus = "";
		OPUSCard newOPUS;
		int choiceOPUS = 0;
		int month, year;
		int reg,jun,sen,dai,wee;
		boolean proceed = true;
		//Main logic while loop that holds 9 different tasks to perform on the Ticketbooths and allows user to exit program
		while (proceed)
		{
			//Display possible options to user
			System.out.println("\nWhat would you like to do?"
					+ "\n\t1.  See the content of all Ticketbooths"
					+ "\n\t2.  See the content of one Ticketbooth"
					+ "\n\t3.  List Ticketbooths with same amount of tickets' values"
					+ "\n\t4.  List Ticketbooths with same Tickets amount"
					+ "\n\t5.  List Ticketbooths with same amount of tickets values and same number of OPUS cards"
					+ "\n\t6.  Add a OPUS card to an existing Ticketbooth"
					+ "\n\t7.  Remove an existing OPUS card from a Ticketbooth"
					+ "\n\t8.  Update the expiry date of an existing OPUS card"
					+ "\n\t9.  Add Tickets to a Ticketbooth"
					+ "\n\t0.  To quit "
					+ "\n\nPlease enter your choice and press <Enter>:");
			initialChoice = kb.nextInt();
		//Switch statement that handles initial user input
		switch(initialChoice) {
		//See the content of all Ticketbooths by looping through Array containing all Ticketbooths
		case 1:
			for (int i = 0; i < grandBooth.length; i++) {
				System.out.println("-----Ticketbooth #" + i + "-----\n\n" + grandBooth[i]);
			}
			break;
			//See the content of one Ticketbooth	
		case 2:
			//While loops checks for valid user input
			do {
				if(choice>4)
					System.out.println("Sorry, that Ticketbooth does not exist, please try again.");
				System.out.println("\nWhich Ticketbooth would you like to see?(Enter 0 to 4): ");
				choice = kb.nextInt();
			} while(choice>4);
			for (int i = 0; i < grandBooth.length; i++) {
				if (choice == i)
				{
					System.out.println("\n-----Ticketbooth " + choice + "-----\n");
					System.out.println(grandBooth[i]);
				}
			}
			break;
			//See which Ticketbooths have the same value
		case 3:
			System.out.println("\nThe following Ticketbooths have the same tickets' value:\n");
			//This Array is used to store which Ticketbooths were already checked to avoid repetition
			compArr = new boolean[grandBooth.length][grandBooth.length];
			//Nested Array; Each Ticketbooth is checked to see if it matches another Ticketbooth and also if it was already matched with that Ticketbooth
			for (int i = 0; i < compArr.length; i++) {
				for (int j = 0; j < compArr.length; j++) {
					if (i != j && grandBooth[i].ticketsValue() == grandBooth[j].ticketsValue() && compArr[i][j] != true) {
							System.out.println("Ticketbooth #" + i + " and Ticketbooth #" + j + 
									": $" + grandBooth[i].ticketsValue() + "\n");
							compArr[i][j] = true;
							compArr[j][i] = true;
						
					}
				}
			}
			break;
			//See which Ticketbooths have the same Tickets
		case 4:
			System.out.println("\nThe following Ticketbooths have the same tickets' distribution:\n");
			//This Array is used to store which Ticketbooths were already checked to avoid repetition
			compArr = new boolean[grandBooth.length][grandBooth.length];
			//Nested Array; Each Ticketbooth is checked to see if it matches another Ticketbooth and also if it was already matched with that Ticketbooth
			for (int i = 0; i < compArr.length; i++) {
				for (int j = 0; j < compArr.length; j++) {
					if (i != j && grandBooth[i].ticketsString().equals(grandBooth[j].ticketsString()) && compArr[i][j] != true) {
							System.out.println("-----Ticketbooth #" + i + " and Ticketbooth #" + j + 
									"-----\n\n" + grandBooth[i].ticketsString());
							compArr[i][j] = true;
							compArr[j][i] = true;
						
					}
				}
			}
			break;
			//See which Ticketbooths have the same Tickets and number of OPUSCards
		case 5:
			System.out.println("\nThe following Ticketbooths have the same tickets' distribution and same number of OPUS cards:\n");
			//This Array is used to store which Ticketbooths were already checked to avoid repetition
			compArr = new boolean[grandBooth.length][grandBooth.length];
			//Nested Array; Each Ticketbooth is checked to see if it matches another Ticketbooth and also if it was already matched with that Ticketbooth
			for (int i = 0; i < compArr.length; i++) {
				for (int j = 0; j < compArr.length; j++) {
					if (i != j && grandBooth[i].equals(grandBooth[j]) && compArr[i][j] != true) {
							System.out.println("-----Ticketbooth #" + i + " and Ticketbooth #" + j + 
									"-----\n\n" + grandBooth[i].ticketsString() + "Number of OPUS cards: " + grandBooth[i].numOpus() + "\n\n");
							compArr[i][j] = true;
							compArr[j][i] = true;
						
					}
				}
			}
			break;
			//Add an OPUSCard to a Ticketbooth
		case 6:
			do {
				if(choice>4)
					System.out.println("Sorry, that Ticketbooth does not exist, please try again.");
				System.out.println("\nWhich Ticketbooth would you like to add an OPUS Card to?(Enter 0 to 4): ");
				choice = kb.nextInt();
			} while(choice>4);
			System.out.println("Type of OPUS(ex: STM, STL, RTM, etc...): ");
			typeOpus = kb.nextLine();
			typeOpus = kb.nextLine();
			System.out.println("Name of cardholder: ");
			nameOpus = kb.nextLine();
			System.out.println("Expiration month and expiration year separated by a space: ");
			month = kb.nextInt();
			year = kb.nextInt();
			newOPUS = new OPUSCard(typeOpus, nameOpus, month, year);
			grandBooth[choice].addOpus(newOPUS);
			System.out.println("Here is your new OPUS card:\n\n" + newOPUS + "\nOPUS successfully added to Ticketbooth #" + choice + ".\n");
			break;
			//Remove an OPUSCard from a Ticketbooth
		case 7:
			do {
				if(choice>4)
					System.out.println("Sorry, that Ticketbooth does not exist, please try again.");
				System.out.println("\nWhich Ticketbooth would you like to see?(Enter 0 to 4): ");
				choice = kb.nextInt();
			} while(choice>4);
			if (grandBooth[choice].numOpus() == 0)
				System.out.println("There are no OPUS cards in that Ticketbooth.");
			else
			{
				do {
					if(choiceOPUS>grandBooth[choice].numOpus() - 1)
						System.out.println("Sorry, that OPUS card does not exist, please try again.");
					System.out.println("\nWhich OPUS card would you like to remove? (Enter an integer between 0 and " + (grandBooth[choice].numOpus() - 1) + ")");
					choiceOPUS = kb.nextInt();
				} while(choiceOPUS>grandBooth[choice].numOpus() - 1);
				if (grandBooth[choice].delOpus(choiceOPUS))
					System.out.println("OPUS card successfully deleted");
				else
					System.out.println("OPUS card not deleted");
			}
			break;
			//Update expiration date of an OPUSCard
		case 8:
			do {
				if(choice>4)
					System.out.println("Sorry, that Ticketbooth does not exist, please try again.");
				System.out.println("\nWhich Ticketbooth would you like to update the OPUS Card?(Enter 0 to 4): ");
				choice = kb.nextInt();
			} while(choice>4);
			
			if (grandBooth[choice].numOpus() == 0)
				System.out.println("There are no OPUS cards in that Ticketbooth.");
			else
			{
				do {
					if(choiceOPUS>grandBooth[choice].numOpus() - 1)
						System.out.println("Sorry, that OPUS card does not exist, please try again.");
					System.out.println("\nWhich OPUS card would you like to update? (Enter an integer between 0 and " + (grandBooth[choice].numOpus() - 1) + ")");
					choiceOPUS = kb.nextInt();
				} while(choiceOPUS>grandBooth[choice].numOpus() - 1);
			System.out.println("\"Expiration month and expiration year separated by a space: ");
			month = kb.nextInt();
			year = kb.nextInt();
			grandBooth[choice].updateExpiry(choice, month, year);
			System.out.println("Card successfully updated.");
			}
			break;
			//Update Tickets of a Ticketbooth
		case 9:
			do {
				if(choice>4)
					System.out.println("Sorry, that Ticketbooth does not exist, please try again.");
				System.out.println("\nWhich Ticketbooth would you like to see?(Enter 0 to 4): ");
				choice = kb.nextInt();
			} while(choice>4);
			System.out.println("How many regular, junior, senior, daily and weekly do you want to add?\n(Enter 5 numbers separated by a space): ");
			reg = kb.nextInt();
			jun = kb.nextInt();
			sen = kb.nextInt();
			dai = kb.nextInt();
			wee = kb.nextInt();
			grandBooth[choice].addTickets(reg, jun, sen, dai, wee);
			System.out.println("You now have: $" + grandBooth[choice].ticketsValue());
			break;
			//Ends while loop
		case 0:
			proceed = false;
			break;
		default:
			System.out.println("Sorry, that is not a valid choice. Try again.");
			break;
		}
		}
		System.out.println("Thank you for using this program!");
		//Close Program
		kb.close();
	}

}
