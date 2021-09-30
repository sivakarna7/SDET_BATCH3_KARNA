package Assignment2;

public class NestedTry {

	public static void main(String[] args) {
		int a =0;
		System.out.println("Testing Nested try Blocks");
		try {
			System.out.println("First try Block");
			try {
				System.out.println("Second try block");
				 a = 10/0;
			} catch (ArithmeticException e) {
				System.out.println(a+" Inside Nested Catch block" + e);
			}
		} catch (NumberFormatException e) {
			System.out.println("Outside Catch block" + e);
		 
             }
	
}
}
