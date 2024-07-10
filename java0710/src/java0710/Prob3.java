package java0710;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를입력:");
		String input = scan.nextLine();
		int num1 = Integer.parseInt(input);
		
		System.out.print("숫자를입력:");
		input = scan.nextLine();
		int num2 = Integer.parseInt(input);
		
		
		
		if(num1>num2) {
			System.out.print(num1);
		}
		else if(num1<num2) {
			System.out.print(num2);
		}
		else if(num1==num2) {
			System.out.print(0);
		}

	}

}
