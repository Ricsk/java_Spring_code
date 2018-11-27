import java.util.Scanner;

public class scanner{
	
	enum Size{ SMALL, MEDIUM, LARGE, EXTRA_LARGE};
	public static void main(String args[]) {
		/*Scanner reader = new Scanner(System.in);
		int sum = 0;
		while(reader.hasNextInt()) {
			int m = reader.nextInt();
			m >>>= 2;
			System.out.println("m = " + m + ".");
		}*/
		/*Size s = Size.SMALL;
		System.out.println(s);*/
/*		String greeting = "Hello";
		System.out.println(greeting.substring(0,3));*/
		
		/*String all = String.join("/", "S", "M", "A", "L","L");
		System.out.println(all);*/
		
		/*char [] ss = {'s', 'q'};
		System.out.println(ss);*/
		
		String greeting = "Hello";
/*		String greeting2 = "Hello";
		if(greeting == greeting2)
			System.out.println(1);
		else
			System.out.println(0);
		if(greeting.equals("Hello"))
			System.out.println(1);
		else
			System.out.println(0);
		if(greeting.substring(0,3) == greeting2.substring(0,3))
			System.out.println(1);*/
		
		int cpCount = greeting.codePointCount(0, greeting.length());
		System.out.println(cpCount);
		System.out.println(greeting.charAt(4));
		int index = greeting.offsetByCodePoints(0, 2);
		System.out.println(greeting.codePointAt(index));
		int [] codePoints = greeting.codePoints().toArray();
		for(int x:codePoints) {
			System.out.println(x);
		}
		System.out.println(new String(codePoints, 0, codePoints.length));
	}
}