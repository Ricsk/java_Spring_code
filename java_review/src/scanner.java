import java.util.Scanner;

public class scanner{
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		double sum = 0;
		while(reader.hasNextDouble()) {
			double m = reader.nextDouble();
			sum += m;
		}
		System.out.println("sum = " + sum + ".");
	}
}