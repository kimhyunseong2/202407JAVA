package java0712;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoEx {

	public static void main(String[] args) {
		Random rand = new Random();
		Set<Integer> lottoSet = new HashSet<>(); // 중복을 허용하지 않는 Set 사용
		while (lottoSet.size()<6) {
			int number = rand.nextInt(45) + 1;
			lottoSet.add(number);
		}
		
		/*lottoSet.add(14);
		lottoSet.add(14);
		lottoSet.add(7);
		System.out.println(lottoSet.size());*/
		System.out.println(lottoSet);
		
	}

}
