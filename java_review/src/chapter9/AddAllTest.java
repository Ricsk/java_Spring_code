package chapter9;

import java.util.Collection;
import java.util.HashSet;

public class AddAllTest{
	public static void main(String[] args) {
		Collection<String> ls = new HashSet<>();
		ls.add("aa");
		ls.add("bb");
		System.out.println(ls.add("aa"));
		Collection<String> ls2 = new HashSet<>();
		ls2.add("aa");
		ls2.add("cc");
		System.out.println(ls.addAll(ls2));
	}
}