package Assignment3;

import java.util.*;

public class P4_ConvertKeysofMapToList {
	
	public static void main(String[] args) {
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(1, "Java");
		myMap.put(2, "JavaFX");
		myMap.put(3, "Script");
		myMap.put(4, "TypeScript");

		ArrayList<Integer> keyList = new ArrayList<Integer>(myMap.keySet());
		ArrayList<String> valueList = new ArrayList<String>(myMap.values());

		System.out.println("contents of the list holding keys of the map ::" + keyList);
		System.out.println("contents of the list holding values of the map ::" + valueList);

}
	
}
