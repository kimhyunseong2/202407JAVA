package p319;

public class A {
	//필드
	A a1 = new A(true);    //(o)
	A a2 = new A(1);       //(o)
	A a3 = new A("문자열");  //(o)
	
	public A(boolean b) {} //public 접근제한
	A(int b){}             //default 접근제한
	private A(String s) {} //private 접근제한
	
}
