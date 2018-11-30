package chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class Array{
	public static void main(String[] args) {
/*		int [] a;
		a = new int[100];
		System.out.println(a.length);
		for(int x:a) {
			System.out.print(x);
		}
		System.out.println();
		System.out.println(a.toString());
		System.out.println(Arrays.toString(a));
		//数组初始化及复制
		int [] a1 = new int[] {1, 2};
		int [] a2 = {1, 2};
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(a1.equals(a2));
		a1 = a2;
		System.out.println(a1.equals(a2));
		int [] a3 = Arrays.copyOf(a2, a2.length*2);
		System.out.println(Arrays.toString(a3));
		*/
		//排序
/*		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int m = in.nextInt();
		System.out.println("What's the highest number you can draw?");
		int n = in.nextInt();
		
		int[] numbers = new int[n];
		for(int i = 0;i < n;i++) {
			numbers[i] = i+1;
		}
		int [] result = new int[m];
		for(int i = 0;i < m;i++) {
			int r = (int)(Math.random()*n);
			result[i] = numbers[r];
			numbers[r] = numbers[n - 1];
			n -= 1;
		}
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));*/
		
		//多维数组
		/*final double STARTRATE = 10;
		final int NRATE = 6;
		final int NYEARS = 10;
		
		double[] interesRate = new double[NRATE];
		for(int i = 0;i < NRATE;i++) {
			interesRate[i] = (STARTRATE + i) / 100.0;
		}
		double[][] balance = new double[NYEARS][NRATE];
		for(int i = 0;i < balance[0].length;i++) {
			balance[0][i] = 10000;
		}
		for(int i = 1;i < balance.length;i++) {
			for(int j = 0;j < balance[i].length;j++) {
				balance[i][j] = balance[i-1][j] * interesRate[j] + balance[i-1][j];
			}
		}
		for(int i = 0;i < interesRate.length;i++) {
			System.out.printf("%9.0f%%", 100*interesRate[i]);
		}
		System.out.println();
		for(double[] x:balance) {
			for(double y:x) {
				System.out.printf("%10.2f", y);
			}
			System.out.println();
		}
		
		System.out.println(Arrays.deepToString(balance));*/
		//三角
		final int MAX = 10;
		double[][] trii = new double[MAX+1][];
		for(int i = 0;i < trii.length;i++) {
			trii[i] = new double[i+1]; 
		}
		for(int i = 0;i < trii.length;i++) {
			for(int j = 0;j < i + 1;j++) {
				double lotteryOdds = 1;
				for(int k = 1;k <= j;k++) {
					lotteryOdds = lotteryOdds * (i - k + 1)/k;
				}
				trii[i][j] = lotteryOdds;
			}
		}
		for(double[] x:trii) {
			for(double y:x) {
				System.out.printf("%4f",y);
			}
			System.out.println();
		}
		int x;
			
	}
	

}