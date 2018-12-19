package chapter9;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GetMaxElementTest{
	public static <T extends Comparable> T max(Collection<T>c) {
		if(c.isEmpty()) 
			throw new NoSuchElementException() ;
			Iterator<T> iter = c.iterator();
			T largest = iter.next();
			while(iter.hasNext()) {
				T next = iter.next();
				if(next.compareTo(largest) > 0)
					largest = next;
			}
		return largest;
	}
	
	public static void main(String[] args) {
		//String[] a = new String[] {"aaa","bbb", "ccc"};
	//	int ans = max(a);//error
	}
}