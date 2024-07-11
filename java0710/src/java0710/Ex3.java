package java0710;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z = 10;
		
		System.out.println("-----------------");
		x++;
		++x;
		System.out.println("x="+ x);
		System.out.println("-----------------");
		
		y--;
		--y;
		System.out.println("y=" + y);
		System.out.println("-----------------");
		
		z = x++;
		System.out.println("z="+ z);
		System.out.println("x="+ x);
		System.out.println("-----------------");
		
		z = ++x;
		System.out.println("z="+ z);
		System.out.println("x="+ x);
		System.out.println("-----------------");
		}
		
	}

