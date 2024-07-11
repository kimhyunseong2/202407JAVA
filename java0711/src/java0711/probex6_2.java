package java0711;

import java.util.Scanner;

public class probex6_2 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n,w; 
		
		do {
			System.out.print("n값: ");
			n = std.nextInt();
			
		} while (n<=0);
		
		do {
			System.out.print("w값: ");
			w = std.nextInt();
			
		} while (w<=0 || w>n);
		
		
		for (int i = 0; i < n / w; i++) 
			System.out.print("*".repeat(w));
			
		
		System.out.println("완료!!");
			
	

	}

}
