package java0711;

import java.util.Scanner;

public class probex7 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n,w; 
		
		do {
			System.out.print("no값: ");
			n = std.nextInt();
			
		} while (n<10 || n>99);
		System.out.printf("no값은: %d",n);
		

	}

}
