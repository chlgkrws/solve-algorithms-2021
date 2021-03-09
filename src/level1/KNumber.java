package level1;

import java.util.Arrays;

public class KNumber {
	
	/**
	 * 프로그래머스 level 1 
	 * K번째 수
	 * https://programmers.co.kr/learn/courses/30/lessons/42748 
	 */
	public int[] solution(int[] array, int[][]commands) {
		int[] result = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int ci = commands[i][0] - 1; 						//인덱스 조정
			int cj = commands[i][1] - 1;
			int k  = commands[i][2];						
			int[] temp = new int[cj - ci + 1];					//복사할 배열 크기
			
			System.arraycopy(array, ci, temp, 0, cj - ci + 1);	//배열 복사
			Arrays.sort(temp);									//배열 정렬
			result[i] = temp[k - 1];							//K번째 수 찾기
		}
		
		return result;
	}
}
