package Assignment2;

import java.util.Scanner;

public class numberFormatException {
	public static void main(String[] args) {
		String str = "12345.567";
		System.out.println("Given string for conversion: "+str);
		try {//converting string into integer which has decimal point - throws exception 
		System.out.println("Converting String to Integer:"+Integer.parseInt(str));
		}
		catch(NumberFormatException e) {//converting it to float and displaying
			System.out.println("Exception Occurred: Converting String to Float: "+Float.parseFloat(str));
}

}
}