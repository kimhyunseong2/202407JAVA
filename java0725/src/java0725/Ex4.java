package java0725;



public class Ex4 {
	
	public static void method() throws ClassNotFoundException {
		Class.forName("asdh.asds.asd");
	}
	
	public static void main(String[] args) {
		try {
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
