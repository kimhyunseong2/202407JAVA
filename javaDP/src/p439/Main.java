package p439;

public class Main {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new MsgListener());
		btn.touch();
		
		btn.setOnClickListener(new CallListener());
		btn.touch();

	}

}
