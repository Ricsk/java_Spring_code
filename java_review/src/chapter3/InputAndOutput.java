package chapter3;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.*;
public class InputAndOutput{
	/**
	 * @param args
	 * @throws UnsupportedEncodingException, IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		//基本Scanner操作
		/*Scanner in = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = in.nextLine();
		System.out.println("How old are you?");
		int age = in.nextInt();
		System.out.println("Hello, " + name + " . Next year, you'll be " + (age + 1));*/
		
		//Console的读入
		/*Console cons = System.console();
		String userName = cons.readLine("User name: ");
		char [] passwd = cons.readPassword("Password: ");
		System.out.println(userName + " " + new String(passwd));*/
		
		//格式化输出
		/*double x = 10000/3.0;
		System.out.println(x);
		System.out.printf("%8.2f\n", x);
		System.out.printf("Hello, %s. Next year, you'll be %d\n", "Mr.S", 24);
		System.out.printf("%,.2f", x);
		String message = String.format("Hello, %s.", "name");*/
		
		//遗留代码中可能出现的格式化日期代码
		/*System.out.printf("%tc\n", new Date());
		System.out.printf("%s %tB %<10te, %<tY\n", "DUE date", new Date());*/
		
		//文件输入与输出
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		PrintWriter out = new PrintWriter(dir + "/myfile.txt", "UTF-8");
		out.println("yyy\n");
		out.flush();
		Scanner in = new Scanner(Paths.get(dir+"/myfile.txt"), "UTF-8");
		System.out.println(in.nextLine());
	}
}