package java0710;

public class Ex1 {

	public static void main(String[] args) {
		String str1 = 10+"";
		String str2 = String.valueOf(10);
		System.out.println(str1);
		System.out.println(str2);
		
		int s3 = Integer.parseInt("100") + 3;
		System.out.println(s3);
		
		double s4 = 3 + Double.parseDouble("100.25");
		System.out.println(s4);
		
		int x1 = 1;
		int x2 = 3;
		int x3 = x1 / x2; //몫
		System.out.println(x3);
		
		double res3 = (double)x1 / x2;
		System.out.println(res3);
		
		float result = (float)(1.5 + 3.4);
		double result2 = 1.5 + 3.4;
		
		byte a1 = 10;
		byte b2 = 20;
		byte c3 = (byte) (a1 + b2);
		int s1 = a1 + b2;
		System.out.println(s1);
		
		byte b1 = -65;
		char c1 = (char)b1;
		System.out.println(c1);
		
		int x = 200;
		byte y =(byte)x;
		System.out.println(y);
		
		double d1 = 3.14;
		int z = (int)d1;
		System.out.println(z);
	}

}
