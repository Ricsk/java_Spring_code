package chapter8;

import chapter5.EmployeeBasic;
import chapter5.Manager;

public class PairTest3{
	public static void main(String[] args) {
		Manager ceo = new Manager("Gus Greedy", 800000, 2003,12, 15);
		Manager cfo = new Manager("Sid Sneak", 800000, 2003,12, 15);
		Pair<Manager> buddies = new Pair<>(ceo, cfo);
		
		printBuddies(buddies);
		ceo.setBonus(100000);
		cfo.setBonus(500000);
		Manager[] managers = {ceo, cfo};
		Pair<EmployeeBasic>result = new Pair<>();
		minmaxBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
	}
	
	public static void printBuddies(Pair<? extends EmployeeBasic>p) {
		EmployeeBasic first = p.getFirst();
		EmployeeBasic second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName());
	}
	
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
		if(a.length == 0)
			return;
		Manager min = a[0];
		Manager max = a[0];
		for(int i =  1;i < a.length;i++) {
			if(min.getSalary() > a[i].getSalary())min = a[i];
			if(max.getSalary() < a[i].getSalary())max = a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxminBonus(Manager[] a,  Pair<? super Manager> result) {
		minmaxBonus(a, result);
		PairAlg.swapHelper(result);
	}
}

class PairAlg{
	public static boolean hasNulls(Pair<?> p) {
		return p.getFirst() == null || p.getSecond() == null;
	}
	
	public static void swap(Pair<?> p) {
		swapHelper(p);
	}
	public static <T>void swapHelper(Pair<T> p){
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}
