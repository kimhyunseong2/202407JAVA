package java0711;

import java.util.Scanner;

public class probex2 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n;
		do {
			System.out.print("n값: ");
			n = std.nextInt();
		} while (n<=0);
		 
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("1부터" + n + "까지의 합은"+ sum+ "이다");
	}

}
