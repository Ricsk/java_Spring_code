package chapter5;

import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.*;
public class ReflectiveTest{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		//the first way to get Class
	/*	Random generator = new Random();
		Class cl = generator.getClass();
		String name = cl.getName();
		System.out.println(name);
		//the second way to get Class
		String className = "java.util.Random";
		Class cl2 = Class.forName(className);
		//the third way to get Class
		Class cl3 = int.class;
		Class cl4 = Random.class;
		System.out.println(cl3.getName());
		System.out.println(Double[].class.getName()); 
		System.out.println(int[].class.getName());*/
		
		//how to manager Class
		/*EmployeeBasic e = new EmployeeBasic();
		System.out.println(e.getClass() == EmployeeBasic.class);
		EmployeeBasic ee = e.getClass().newInstance();
		System.out.println(ee.getName());*/
		/*String s = "chapter5.Manager";
		try {
			double m = ((Manager)Class.forName(s).newInstance()).getSalary();
			System.out.println(m);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//利用reflect分析类
	/*	String name;
		if(args.length > 0)
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g.java.util.Data): ");
			name = in.next();
		}
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print("class " + cl.getName());
			if(supercl != null && supercl != Object.class)
				System.out.print(" extends " + supercl.getName());
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		//在运行时分析对象即是得到数据域的实际内容
		//这里由于我的name是定义在person里的所以和书上相比作了改进
		EmployeeBasic harry = new EmployeeBasic("Harry Hacker", 3500, 1989, 10, 1);
		Class cl = harry.getClass();
		Field f = null;
		int flag = 1;
		while(cl.getName() != Object.class.getName()) {
			try {
				f = cl.getDeclaredField("name");
				flag = 0;
				break;
			}catch(NoSuchFieldException e) {
				cl = cl.getSuperclass();
			}
		}
		f.setAccessible(true);
		if(flag == 0) {
			Object v = f.get(harry);
			System.out.println(v);
		}
		
	}
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getConstructors();
		for(Constructor c: constructors) {
			String name = c.getName();
			System.out.print("\t");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers + " ");
			System.out.print(name+ "(");
			
			Class[] paramTypes = c.getParameterTypes();
			for(int j = 0;j < paramTypes.length;j++) {
				if(j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class cl) {
		Method[] methods = cl.getMethods();
		for(Method m : methods) {
			String name = m.getName();
			Class retType = m.getReturnType();
			
			System.out.print("\t");
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int j = 0;j < paramTypes.length;j++) {
				if(j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(")");
		}
	}
	
	public static void printFields(Class cl) {
		//getFields()
		Field[] fields = cl.getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			Class type = f.getClass();
			System.out.print("\t");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " "+ name + ";");
		}
	}
}