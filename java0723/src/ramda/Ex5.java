package ramda;

public class Ex5 {

	public static void main(String[] args) {
		MyInterf4 myInterf4 = (a,b)->{
			return a + b;
		};
		int x = myInterf4.method(100, 700);
		System.out.println(x);
	}

}
