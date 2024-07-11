package java0711;

import java.util.Scanner;

public class probex4 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n;
		do {
			System.out.print("n값: ");
			n = std.nextInt();
		} while (n<=0);
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if(i < n) {
				System.out.print(i + "+");
			}else {
				System.out.print(i + "=");
			}
			sum += i;
		}
		System.out.println(sum);
		
	}

}
