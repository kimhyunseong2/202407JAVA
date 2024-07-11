package java0711;

import java.util.Scanner;

public class probex4_2 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n;
		do {
			System.out.print("n값: ");
			n = std.nextInt();
		} while (n<=0);
		
		int sum = 0;
		for (int i = 1; i < n; i++) {
			System.out.print(i + "+");
			sum += i;
		}
		System.out.print(n + "=");
		sum +=n;
		System.out.println(sum);
		
	}

}
