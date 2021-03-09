package level1;

import java.util.Arrays;

public class KNumber {
	
	/**
	 * ���α׷��ӽ� level 1 
	 * K��° ��
	 * https://programmers.co.kr/learn/courses/30/lessons/42748 
	 */
	public int[] solution(int[] array, int[][]commands) {
		int[] result = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int ci = commands[i][0] - 1; 						//�ε��� ����
			int cj = commands[i][1] - 1;
			int k  = commands[i][2];						
			int[] temp = new int[cj - ci + 1];					//������ �迭 ũ��
			
			System.arraycopy(array, ci, temp, 0, cj - ci + 1);	//�迭 ����
			Arrays.sort(temp);									//�迭 ����
			result[i] = temp[k - 1];							//K��° �� ã��
		}
		
		return result;
	}
}
