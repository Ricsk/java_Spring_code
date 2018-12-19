package chapter9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import chapter5.EmployeeBasic;

public class MapTest{
	public static void main(String[] agrs) {
		Map<String, EmployeeBasic> staff = new HashMap<>();
		staff.put("144-25-5664", new EmployeeBasic("Amy Lee"));
		staff.put("567-24-2546", new EmployeeBasic("Harray Hacker"));
		staff.put("157-62-7935", new EmployeeBasic("Gary Cooper"));
		staff.put("456-62-5527", new EmployeeBasic("Francesca Cruz"));
		
	//	System.out.println(staff);
		
	/*	staff.remove("567-24-2546");
		
		staff.put("456-62-5527", new EmployeeBasic("Francesca Miller"));
		
		System.out.println(staff.get("157-62-7935"));
		System.out.println(staff.getOrDefault("157-62-7933", new EmployeeBasic()));
		staff.forEach((k, v) ->
			System.out.println("key=" + k + ", value="+  v));*/
		
		Set<String> phones = staff.keySet();
		Iterator iter = phones.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		for(Map.Entry<String,EmployeeBasic> entry : staff.entrySet()) {
			System.out.println("phones = " + entry.getKey() + ", name = " + entry.getValue());
		}
	}
	
}