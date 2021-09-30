package Assignment3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class P3_KeyInHashTable {
	
	public static void main(String[] args) {
		Map<String, String> mp = new HashMap<String, String>();
		mp = new Hashtable<String, String>();
		mp.put("name", "Test");
		mp.put("Class", "3");
		mp.put("Address", "Hyd");
	
		System.out.println(mp);
		System.out.println(mp.get("Class"));
		
		if(mp.containsKey("Class")) {
			System.out.println(true);
		}
		else
			System.out.println(false);
		
		for(String key:mp.keySet()) {
			System.out.println();
			System.out.println(key+"=="+mp.get(key));

}
		
}
}
