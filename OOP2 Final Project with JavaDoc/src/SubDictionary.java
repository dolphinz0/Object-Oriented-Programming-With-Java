import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//-----------------------------------------------------
//Assignment 4
//Question: SubDictionary
//Written by: Michael Nittolo 40203394
//-----------------------------------------------------
/**
 * SubDictionary class that has inFile and outFile
 * @author Gamer
 *
 */
public class SubDictionary {

	public static void main(String[] args) {
		Scanner inFile = null;
		PrintWriter outFile = null;
		try {
			inFile = new Scanner(new FileInputStream("PersonOfTheCentury.txt"));
		} catch (FileNotFoundException e) {System.out.println("Exception");System.exit(0);}
		try {
			outFile = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		} catch (FileNotFoundException e) {System.out.println("Exception");}
		ArrayList<String> subDict = new ArrayList<String>();
		while (inFile.hasNext()) {
			String str = inFile.next();
			subDict.add(str);
		}
		ArrayList<String> subDict2 = new ArrayList<String>();
		for (String str : subDict) {
			if (containsDigit(str)) {
				str += "-9999";
			} 
			else if ((str.equals("=") || str.length() == 1) && !(str.toUpperCase().equals("A") || str.toUpperCase().equals("I"))) {
				str+="-9999";
			}
			else {
				for (String c : str.split("")) {
					if (c.equals(",") || c.equals(".") || c.equals(";") || c.equals(":") || c.equals("?") || c.equals("!")) {
					str.join("");
					str = str.substring(0, str.length() - 1);
					}
					else if (c.equals("’")) {
						str.join("");
						str = str.substring(0, str.length() - 2);
					}
				}
			}
			if (!tagged(str))
				subDict2.add(str.toUpperCase());
		}
		Collections.sort(subDict2);
		subDict2 = removeDuplicates(subDict2);
		System.out.println(subDict2);
		String newLetter = "";
		outFile.println("The document produced this sub-dictionary, which includes " + subDict2.size() + " entries.");
		for (String str : subDict2) {
			if (!newLetter.equals(str.substring(0, 1))) {
				newLetter = str.substring(0, 1);
				outFile.println("\n" + newLetter +"\n==");
			}
			outFile.println(str);
		}
		inFile.close();
		outFile.close();
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean containsDigit(String str) {
		String[] arr = str.split("");
		for (String c : arr) {
			if (c.equals("0")||c.equals("1")||c.equals("2")||c.equals("3")||c.equals("4")||c.equals("5")||
					c.equals("6")||c.equals("7")||c.equals("8")||c.equals("9"))
				return true;
		}
		return false;
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean tagged(String str) {
		if (str.length() >= 6)
			str = str.substring(str.length()-5);
		if (str.equals("-9999"))
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param <T>
	 * @param arr
	 * @return
	 */
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> arr) {
		ArrayList<T> newArr = new ArrayList<T>();
		for (T o : arr) {
			if (!newArr.contains(o)) {
				newArr.add(o);
			}
		}
		return newArr;
	}

}
