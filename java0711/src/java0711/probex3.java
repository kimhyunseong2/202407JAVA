package java0711;

import java.util.Scanner;

public class probex3 {
	public static int sumOf(int a, int b) {
		int min;
		int max;
		
		if(a<b) {
			min = a; max = b;
		} else {
			min = b; max = a;
		}
		int sum = 0;
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		return sum;
		
		
	}

	public static void main(String[] args) {
		
		Scanner std = new Scanner(System.in);
		
		System.out.print("a값 : ");
		int a = std.nextInt();
		System.out.print("b값 : ");
		int b = std.nextInt();
		System.out.println("a,b사이의 값은" + sumOf(a,b)+"입니다");
		
		
		

	}

}
