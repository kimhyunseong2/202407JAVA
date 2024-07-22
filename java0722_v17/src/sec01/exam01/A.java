package sec01.exam01;

public class A {
	A(){ // 생성자
		System.out.println("A 객체 생성");
	}
	class B { // 인스턴스 멤버 클래스
		B() {
			System.out.println("B 객체 생성");
		}
		int field1;
//		static int field2;
		void method1() {}
//		static void method2(){}
	}
	static class C{ // 정적 멤버 클래스
		C() {
			System.out.println("C 객체가 생성");
		}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	void method() {
		class D{  //로컬 클래스
			D() {
				System.out.println("D 객체가 생성");
			}
			int field1;
			// static int field2;
			void method1() {}
			// static void method2(){}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
	
}
