package Assignment3;

import java.util.*;

public class P6_TreeSetHighestLowest {
	
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();	
		set.add(10);
		set.add(15);
		set.add(55);
		
		System.out.println("Sorted data: "+set); 

		System.out.println("");
		System.out.println("Lowest Value is: "+set.first());
		System.out.println("Highest Value is: "+set.last());

}
}
