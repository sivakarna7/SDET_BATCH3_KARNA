package Assignment;

import java.util.Scanner;

public class Reversearray {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
         int i,n;
 
 System.out.println("Enter the number of elements:") ;
 n = sc.nextInt();
 int[] a = new int[n];
 int[] reverse = new int[n];
 
     System.out.println("Enter the elements") ;
     for(i=0;i<n;i++)
     { 
         a[i] = sc.nextInt();
     }
 
 for(i=0;i<n;i++)
     {
 reverse[i] = a[n-i-1];
     }
     System.out.println("Elements in reverse order are");
     for(i=0;i<n;i++)
     {
         System.out.print(reverse[i]+" ") ;
	}
	}
}
