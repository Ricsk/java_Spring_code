package chapter5;
import java.lang.Object;
import java.util.Arrays;
public class ObjectTest{
	public static void main(String[] args) {
		
	/*	Object obj = new EmployeeBasic();
		EmployeeBasic[] staff = new EmployeeBasic[10];
		obj = staff;
		obj = new int[10];*/
		
		//hashcode
		/*String s = "OK";
		StringBuilder sb = new StringBuilder(s);
		String ss = "OK";
		
		System.out.println(s.hashCode() + " " + ss.hashCode() + " " + sb.hashCode());
		
		String t = new String("OK");
		String t2 = new String("OK");
		StringBuilder tb = new StringBuilder(t);
		System.out.println(t.hashCode() + " " + t2.hashCode() + " " + tb.hashCode());*/
		
		//to_String
		Manager m = new Manager();
		System.out.println(m.toString());
		System.out.println(""+m);
		System.out.println(1);
		System.out.println(m);
		System.out.println(System.out);
		int[] luckyNumbers = {2, 3, 5, 7, 11, 13 };
		String s1 = ""+luckyNumbers;
		System.out.println(s1);
		String s2 = Arrays.toString(luckyNumbers);
		System.out.println(s2);
		int[][] luckyNumbersNumbers = {{1, 2}, {3, 4}};
		System.out.println(Arrays.deepToString(luckyNumbersNumbers));
	}
}