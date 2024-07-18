package sec02.exam03;

public class Tire {
	//필드
	public int maxRotation; //최대 회전수(타이어 수명)
	public int accumulatedRotation; //누적 회전수
	public String location; //타이어 위치
	
	
	//생성자
	public Tire(String location, int maxRotation) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	
	//메소드
	public boolean roll() {
		++accumulatedRotation; //누적 회전수 1 증가
 		if(accumulatedRotation<maxRotation) {  //정상회전(누적<최대)일경우 실행
			System.out.println(location + " Tire 수명: " + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {                               //펑크(누적=최대)일경우 실행
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
}
