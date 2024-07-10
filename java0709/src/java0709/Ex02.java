package java0709;

import java.util.Scanner;

public class Ex02 {
	
	
	
	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요:");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
		
		if(num>0) {
			System.out.print(num);
		}else if(num<0) {
			System.out.print(-num);
		}
			
			
		
		
		
	/*	float f1 = 3.14f;
		double d1 = 314e-2;
		System.out.println(d1);
		
		int sum;
		int score1 = 0;
		int score2;
//		sum = score1 + score2;
		
		int x1 = 100;
		if (true) {
			int x2 = 300;
		}
		
//		System.out.println(x2);*/
	}

}
