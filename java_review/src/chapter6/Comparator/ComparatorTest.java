package chapter6.Comparator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest{
	public static void main(String[] args) {
		Comparator<String> comp = new LengthComparator();
		String[] friends =  {"Peter", "Paul"};
		Arrays.sort(friends, comp);
		System.out.println(friends[0]);
	}
}

class LengthComparator implements Comparator<String>{
	public int compare(String first, String second) {
		return first.length() - second.length();
	}
}