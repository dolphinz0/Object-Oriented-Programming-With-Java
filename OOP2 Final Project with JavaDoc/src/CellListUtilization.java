import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//-----------------------------------------------------
//Assignment 4
//Question: CellListUtilization
//Written by: Michael Nittolo 40203394
//-----------------------------------------------------

/**
 * This program is the main Driver class that uses the CellList and CellNode classes
 * @author Gamer
 *
 */
public class CellListUtilization {

	public static void main(String[] args) {
		CellList myCells1 = new CellList();
		CellList myCells2 = new CellList();
		Scanner inFile = null;
		try {
			inFile = new Scanner(new FileInputStream("Cell_Info.txt"));
		} catch (FileNotFoundException e) {System.out.println("File Not Found. Exiting Program...");System.exit(0);}
		int i = 0;
		while (inFile.hasNextLine()) {
			int serialNum = Integer.parseInt(inFile.next());
			String brand = inFile.next();
			double price = Double.parseDouble(inFile.next());
			int year = Integer.parseInt(inFile.next());
			CellPhone cell = new CellPhone(serialNum, brand, year, price);
			if (!myCells1.contains(serialNum))
				myCells1.addToStart(cell);
			if (!myCells2.contains(serialNum)) {
				myCells2.insertAtIndex(cell, i);
				i++;
			}
					
		}
		myCells1.showContents();
		System.out.println("\n");
		myCells2.showContents();
		System.out.println("\n");
		CellPhone cell = new CellPhone(1234567, "The PhOne", 2302, 99999.99);
		myCells2.insertAtIndex(cell , 10);
		myCells2.deleteFromStart();
		myCells2.deleteFromEnd();
		myCells1 = new CellList(myCells2);
		myCells2.showContents();
		System.out.println("\n");
		myCells1.deleteFromEnd();
		myCells1.deleteFromStart();
		System.out.println("CellList 1");
		myCells1.showContents();
		System.out.println("\n");
		myCells2.showContents();
		myCells1.find(4900088);
		myCells1.contains(89076);
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a few serial number to find the phoen in the linked list: ");
		long serialNum = kb.nextLong();
		long serialNum2 = kb.nextLong();
		long serialNum3 = kb.nextLong();
		System.out.println("The corresponding phones are: ");
		System.out.println(myCells1.find(serialNum) == null ? "no cell found with that serial number" : myCells1.find(serialNum).getCell());
		System.out.println(myCells1.find(serialNum2) == null ? "no cell found with that serial number" : myCells1.find(serialNum2).getCell());
		System.out.println(myCells1.find(serialNum3) == null ? "no cell found with that serial number" : myCells1.find(serialNum3).getCell());
		kb.close();
		
	}

}
