package chapter3;
import java.util.Scanner;

public class BasicAndString{
	
	enum Size{ SMALL, MEDIUM, LARGE, EXTRA_LARGE};
	public static void main(String args[]) {
		//<<,>>,>>>运算符测试
		/*Scanner reader = new Scanner(System.in);
		int sum = 0;
		while(reader.hasNextInt()) {
			int m = reader.nextInt();
			m >>>= 2;
			System.out.println("m = " + m + ".");
		}*/
		
		//枚举类型测试
		/*Size s = Size.SMALL;
		System.out.println(s);*/
/*		String greeting = "Hello";
		System.out.println(greeting.substring(0,3));*/
		
		//join类型测试
		/*String all = String.join("/", "S", "M", "A", "L","L");
		System.out.println(all);*/
		
		//char数组测试
		/*char [] ss = {'s', 'q'};
		System.out.println(ss);*/
		
		String greeting = "Hello";
		
		//String的==和equals，存储池和堆的理解
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
		
		//关于Unicode码点的学习
		/*int cpCount = greeting.codePointCount(0, greeting.length());
		System.out.println(cpCount);
		System.out.println(greeting.charAt(4));
		int index = greeting.offsetByCodePoints(0, 2);
		System.out.println(greeting.codePointAt(index));
		int [] codePoints = greeting.codePoints().toArray();
		for(int x:codePoints) {
			System.out.println(x);
		}
		System.out.println(new String(codePoints, 0, codePoints.length));*/
		
		//StringBuilder的学习测试
/*		StringBuilder builder = new StringBuilder();
		char ch = 'x';
		String str = "是你吗";
		builder.append(ch);
		builder.append(str);
		System.out.println(builder.length());
		String completedString = builder.toString();
		System.out.println(completedString);*/
		
		
	}
}