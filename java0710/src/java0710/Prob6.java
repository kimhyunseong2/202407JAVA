package java0710;

import java.util.Scanner;

public class Prob6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요:");
		
		int num = scan.nextInt();
		
		if(num<0) {
			num = -num;
		}
		System.out.println(num);

	}

}
