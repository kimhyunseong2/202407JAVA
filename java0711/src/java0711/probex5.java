package java0711;

import java.util.Scanner;

public class probex5 {

	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		int n;
		do {
			System.out.print("n값: ");
			n = std.nextInt();
		} while (n<=0);
		
		for (int i = 0; i < n ; i++) {
			if(i % 2 == 0) {
				System.out.print("-");
			}else {
			System.out.print("+");
			}
		}
				
	}
	

}
