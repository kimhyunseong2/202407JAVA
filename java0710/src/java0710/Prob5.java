package java0710;

import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {
		int in = 90;
		String score = (in >= 90) ? "A":
							(in >= 80) ? "B":
								(in >= 70) ? "C":
									(in >= 60) ? "D":"F";
		System.out.println(score);

	}

}
