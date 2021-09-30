package Assignment3;

import java.util.*;

public class P5_CopyHashSetToObjArray {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("ABC");
		set.add("ABC0");
		set.add("ABC1");
		set.add("ABC"); //duplicate is not allowed
		set.add(null);
		System.out.println("Elements in set = " + set);
		System.out.println("Copying all elements...");
		Object[] obArr = set.toArray();
		for (Object ob : obArr)
			System.out.println(ob);

}
}
