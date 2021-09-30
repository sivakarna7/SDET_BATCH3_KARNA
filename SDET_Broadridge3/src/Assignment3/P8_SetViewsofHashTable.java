package Assignment3;

import java.util.*;

public class P8_SetViewsofHashTable {
	
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Name", "ABC");
		ht.put("Class", "3rd");
		ht.put("Rank", "2");
		Set<String> st = ht.keySet();
		
		System.out.print("Keys from HashTable: ");
		System.out.println(st);
		
}
}