package java0725;

import java.util.HashMap;

public class KeyEx {

	public static void main(String[] args) {
//		HashMap<Integer, String> hasMap = new HashMap<>();
//		hasMap.put(1, "홍길동");
//		String val = hasMap.get(1);
//		System.out.println(val);
		
		Key key1 = new Key(100);
		Key key2 = new Key(100);
		System.out.println(key1.hashCode());
		System.out.println(key2.hashCode());
		if(key1.equals(key2)) {
			System.out.println("같다");
		}
		
		HashMap<Key, String> hasMap = new HashMap<>();
		hasMap.put(new Key(1), "홍길동");
		String val = hasMap.get(new Key(1));
		System.out.println(val);
	}

}
