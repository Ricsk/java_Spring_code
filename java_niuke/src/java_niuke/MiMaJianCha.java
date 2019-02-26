package java_niuke;
import java.util.*;
public class MiMaJianCha {
	 public static void main(String args[]){
	        int n;
	        Scanner scan = new Scanner(System.in);
	        n = scan.nextInt();
	        scan.nextLine();
	        for(int i = 1;i <= n;i++){
	            String ls = new String();
	            ls = scan.nextLine();
	            if(check_1(ls)&&check_2(ls)&&check_3(ls)&&check_4(ls))
	                System.out.println("YES");
	            else
	                System.out.println("NO");
	        }
	    }
	    private static boolean check_1(String ls){
	    	//System.out.println(ls.matches("(.*)[^0-9a-zA-Z](.*)"));
	        return !ls.matches("(.*)[^0-9a-zA-Z](.*)");
	    }
	    private static boolean check_2(String ls){
	        return ls.charAt(0) >= '9'||ls.charAt(0) <= '0';
	    }
	    private static boolean check_3(String ls){
	        int op = 0;
	        //System.out.println(ls);
	        //System.out.println(ls.matches("(.*)[a-z](.*)"));
	        if(ls.matches("(.*)[a-z](.*)"))
	            op++;
	        if(ls.matches("(.*)[A-Z](.*)"))
	            op++;
	        if(ls.matches("(.*)\\d(.*)"))
	            op++;
	       // System.out.println(op);
	        return op >= 2;
	    }
	    private static boolean check_4(String ls){
	        return ls.length() >= 8;
	    }
}
