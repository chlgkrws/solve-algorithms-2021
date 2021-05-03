package level1;

import java.util.stream.IntStream;

public class InnerProduct {
	
	/**
	 * level 1
	 * ³»Àû
	 * https://programmers.co.kr/learn/courses/30/lessons/70128
	 */
	public int solution(int[] a, int[] b) {
//		int result = 0;
//		for(int i = 0; i < a.length; i++) {
//			result += a[i] * b[i];
//		}
//		return result;
		
		return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
	}
}
