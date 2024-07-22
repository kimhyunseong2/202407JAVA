package sec01.exam02;

public class A {
	B field1 = new B();
	C field2 = new C();
//	static B field3 = new B(); 불가
	static C field5 = new C();
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	static void method2() {
//		B var1 = new B(); 불가
		C var2 = new C();
	}
	
	class B{}
	static class C{}
	
}
