package chapter3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class BigNumberTest{
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many numbers you need to draw?");
		BigInteger n = in.nextBigInteger();
		System.out.println("What's the highest number you can draw?");
		BigInteger m = in.nextBigInteger();
		System.out.println("done");
		BigInteger i = BigInteger.valueOf(1);
		BigDecimal lotterOdds = BigDecimal.valueOf(1.0);
		for(;i.subtract(m).compareTo(BigInteger.valueOf(0)) != 0;i.add(BigInteger.valueOf(1))) {
			lotterOdds = lotterOdds.multiply(
					new BigDecimal(n.subtract(i).add(BigInteger.valueOf(1)))
					).divide(new BigDecimal(i));
		}
		System.out.println(lotterOdds);
	}
}