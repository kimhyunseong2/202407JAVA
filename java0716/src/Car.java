

public class Car {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpead;
	
	Car(){ //1.생성자
	}
	
	Car(String model){
		this.model = model; //2.생성자
	}
	
	Car(String model, String color){ //3.생성자
		this.model = model;
		this.color = color;
	}
	
	Car(String model, String color, int maxSpead){ //4.생성자
		this.model = model;
		this.color = color;
		this.maxSpead = maxSpead;
	}
}
