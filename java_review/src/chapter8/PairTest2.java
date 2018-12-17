package chapter8;

import java.time.LocalDate;

public class PairTest2{
	public static void main(String[] args) {
		/*LocalDate[] birthdays = {
				LocalDate.of(1906,  12,  9),
				LocalDate.of(1907,  12,  9),
				LocalDate.of(1908,  12,  9),
				LocalDate.of(1909,  12,  9),
		};
		Pair<LocalDate> mm = ArrayAlg2.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());*/
		/*
		DateInterval x = new DateInterval();
		System.out.println(x.getSecond());*/
		
		
		//Pair<String>[] table = new Pair<String>[10];//error
	}
}

class ArrayAlg2{
	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if(a == null || a.length == 0)
			return null;
		T min = a[0];
		T max = a[0];
		for(int i = 1;i < a.length;i++) {
			if(min.compareTo(a[i]) > 0) {
				min = a[i];
			}
			if(max.compareTo(a[i]) < 0) {
				max = a[i];
			}
		}
		return new Pair<T>(min, max);
	}
}

class DateInterval extends Pair<LocalDate>{
	public LocalDate getSecond() {
		return LocalDate.of(1918,  12,  9);
	}
}