package java0725;

import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {
		int[] array = {1,1,4,5,7,8,11,12,17,21,24}; // 정렬이 된 상태에서 가능
//		int[] array = {3,5,1,6,2,9,4,12,13,16,24};
		int found = Arrays.binarySearch(array, 5);
		System.out.println(found);

	}

}
