package level2;

import java.util.Arrays;

public class MaximumAndMinimum {

	
	/**
	 * level 2
	 * ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª
	 * https://programmers.co.kr/learn/courses/30/lessons/12939
	 */
	public String solution(String n) {
		String[] strArr = n.split(" ");
		int[] numberArr= Arrays.stream(strArr).mapToInt(Integer::parseInt).sorted().toArray();
		
		return numberArr[0] + " " + numberArr[numberArr.length - 1];
	}

	public static void main(String[] args) {
	}

}
