package java0710;

import java.util.Scanner;

public class Prob4 {

	public static int maxNum(int x, int y, int z) {
		int max = x;
		if(y > max) {
			max = y;
		}
		if(z > max) {
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("3개의 수를 입력");
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		
		System.out.println(maxNum(x,y,z));
	}

}
