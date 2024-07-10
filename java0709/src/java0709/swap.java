package java0709;

public class swap {
	
	
	/**
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		 int temp = a;
		 a = b;
		 b = temp;
		 System.out.printf("a=%d, b=%d\n", a, b);
	}
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		System.out.printf("x=%d, y=%d\n", x, y);
		swap(x, y);
	   
	}

}
