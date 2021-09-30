package Assignment3;

import java.util.*;

public class P7_SortArrayList {
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Siva");
		al.add("Prasad");
		al.add("Karna");
		
		System.out.println(al);
		Collections.sort(al,String.CASE_INSENSITIVE_ORDER);
		System.out.println(al);

}
}