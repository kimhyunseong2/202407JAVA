package java0711;

import java.util.Scanner;

public class probex6 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int w = 0;
		int n = 0;
		do {
			System.out.print("n값: ");
			n = std.nextInt();
			
		} while (n<=0);
		
		do {
			System.out.print("w값: ");
			w = std.nextInt();
			
		} while (w<=0 || w>n);
		
		
		for (int i = 0; i < n; i++) {
			System.out.print("*");
			if(i % w == w-1) {
				System.out.println();
			}
			
			
		}
		
	

	}

}
