package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class DividedArray {
	/**
	 * ���α׷��ӽ� level 1
	 * ������ �������� ���� �迭
	 * https://programmers.co.kr/learn/courses/30/lessons/12910 
	 */
	public int[] solution(int[] arr, int divisor) {
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) al.add(arr[i]);
		}
		
		if(al.size() == 0) return new int[] {-1};
		
		int[] ret = al.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(ret);
		
		return ret;
	}
}
