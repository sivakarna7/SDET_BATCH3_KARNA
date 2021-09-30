package Assignment2;

import java.util.Scanner;

public class passArgumentWhileThrowingException {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to be divided by 3 : ");
        int num1 = scanner.nextInt();
        int result = num1%3;
        if (result!=0){
            throw new ArithmeticException("The input number is not divisible by 3");
        }else{
            System.out.println("The input number is divisible by 3");

}
       
	}
}
