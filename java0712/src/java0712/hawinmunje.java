package java0712;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class hawinmunje {
	public static void main(String[] args) {
		while(true) {
			int num1 = (int)(Math.random()*6+1);
			int num2 = (int)(Math.random()*6+1);
			System.out.print("(" + num1 +","+num2 +")");
			if(num1+num2 == 5) {
				break;
			}
		}
	}
}
	

