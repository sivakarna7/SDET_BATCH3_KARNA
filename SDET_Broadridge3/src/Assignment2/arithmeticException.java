package Assignment2;

import java.util.Scanner;

public class arithmeticException {
	
	public static void main( String[] arg) {
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your age : ");
		//throws Exception as if the input string is of illegal format for parsing as it as null or alphanumeric.
		age = Integer.parseInt(sc.next());
		System.out.println("Your age is : " +age);

	}
}

