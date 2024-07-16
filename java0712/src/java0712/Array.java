package java0712;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Array {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
				
				
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
				
		int size = list.size();
		System.out.println("총 객체 수:" + size);
		System.out.println();
				
		String skil = list.get(2);
		System.out.println("2: " + skil);
		System.out.println();
				
		for(int i = 0; i <list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
				
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
				
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
	}
	
}
