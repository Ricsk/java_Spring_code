package chapter5;

import java.util.ArrayList;

import org.omg.CORBA.IntHolder;


public class GenericClassTest{
	public static void main(String[] args) {
		
		//how to init a ArrayList
		//ArrayList<EmployeeBasic> staff = new ArrayList<EmployeeBasic>();
		ArrayList<EmployeeBasic> staff = new ArrayList<>();//ok after SE7
		//ArrayList<EmployeeBasic> staff = new ArrayList<>(1);
		staff.ensureCapacity(1);
		staff.add(new EmployeeBasic("Harry Hacker"));
		System.out.println(staff.size());
		staff.add(new EmployeeBasic("Tony Tester"));
		System.out.println(staff.size());
		staff.trimToSize();
		staff.add(new EmployeeBasic());
		System.out.println(staff.size());
		EmployeeBasic e = staff.get(2);
		System.out.println(e);
		//how to use the element in it
/*		EmployeeBasic X[] = new EmployeeBasic[staff.size()];
		staff.toArray(X);
		
		int n = 0;
		staff.add(n, new EmployeeBasic());
		
		e = staff.remove(1);
		System.out.println(e);*/
		
		//how to get every elements in ArrayList
		/*for(EmployeeBasic ee: staff) {
			System.out.println(ee);
		}
		for(int i = 0;i < staff.size();i++) {
			//EmployeeBasic e = staff.get(i);//error 局部变量部分层级，不能重名
			EmployeeBasic ee = staff.get(i);
			System.out.println(ee);
		}*/
		
		//wrapper and autoboxing
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(Integer.valueOf(3));
		System.out.println(list);
		int n = list.get(0);
		System.out.println(n);
		n = list.get(0).intValue();
		Integer n2 = 3;
		n2++;
		System.out.println(n2);
		
		Integer n3 = 1;
		Double x = 2.0;
		System.out.println(true?n3:x);
		//一个来改变参数数值的方法,鸡肋
		IntHolder n4 = new IntHolder(4);
		triple(n4);
		System.out.println(n4.value);
		
		System.out.println(max(1.0, 2, 3, 4.0));
	}
	
	public static void triple(IntHolder x) {
		x.value = 3*x.value;
	}
	//可变参数方法
	public static double max(double... values) {
		double largest = Double.NEGATIVE_INFINITY;
		for(double v:values) largest = v>largest ? v:largest;
		return largest;
	}
}