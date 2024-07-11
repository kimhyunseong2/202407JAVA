package java0711;

import java.util.Scanner;

public class probex1 {
	public static int cnm(int a, int b, int c ) {
		if ((b >= a && c <= a) || (b <= a && c>= a)) {
			return a;
		} else if ((a > b && c < b) || (a < b && c > b)) {
			return b;
		} else {
			return c;
		}
		
		
		/*if(a>=b) {
			if(b>=c) {
				return b;
			}else if(a<=c) {
				return a;
			}else {
				return c;
			}
		} else if(a>c) {
			return c;
		}else if(b > c) {
			return a;
		}else {
			return b;
		}
		
		
	}*/
	}
	public static void main(String[] args) {
		Scanner std = new Scanner(System.in);
		
		System.out.println("세 정수의 중앙값을 구합니다.");
		System.out.print("a값 : ");
		int a = std.nextInt();
		System.out.print("b값 : ");
		int b = std.nextInt();
		System.out.print("c값 : ");
		int c = std.nextInt();
		System.out.printf("세 정수의 중앙값은 " + cnm(a,b,c));
		
		
		
		
		

	}

}
