package chapter9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest{
	public static void main(String[] args) {
		List<String> staff = new LinkedList<>();
		staff.add("Amy");
		staff.add("Bob");
		staff.add("Carl");
/*		Iterator iter = staff.iterator();
		String first = (String) iter.next();
		System.out.println(first);
		String second = (String) iter.next();
		System.out.println(second);
		iter.remove();
		for(String e : staff) {
			System.out.println(e);
		}*/
	/*	ListIterator<String> iter = staff.listIterator();
		while(iter.hasNext()) {
			iter.add("a");
			iter.next();
		}
		while(iter.hasPrevious()) {
			String ls = iter.previous();
			if(!ls.equals("a"))
				iter.set("little");
		}
		for(String e : staff) {
			System.out.println(e);
		}*/
		/*ListIterator<String> iter1 = staff.listIterator();
		ListIterator<String> iter2 = staff.listIterator();
		iter1.next();
		//iter1.remove();
		//iter1.add("aa");
		//iter1.set("a");
		System.out.println(iter2.next());//error/but ok if set method has done
*/		
		
	}
}