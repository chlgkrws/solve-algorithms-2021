package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class DividedArray {
	/**
	 * 프로그래머스 level 1
	 * 나누어 떨어지는 숫자 배열
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
