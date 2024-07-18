package p299;

public class ClassName {
	//인스턴스 필드와 메소드
	int field1;
	void method1() {
		ClassName.field2 = 200;
		this.field1 = 300;
	}
	
	//정적 필드와 메소드
	static int field2;
	static void method2() {
		field2 = 100;
	}
	
	public static void main(String[] ar) {
//		method1();
		ClassName.method2(); // = method2()
		System.out.println(ClassName.field2);
		ClassName c1 = new ClassName();
		c1.method1();
		System.out.println(c1.field1);
	}
}
