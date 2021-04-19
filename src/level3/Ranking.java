package level3;

import java.util.Arrays;

public class Ranking {
	/**
	 * level 3
	 * ����
	 * https://programmers.co.kr/learn/courses/30/lessons/49191
	 */
	public int solution(int n, int[][] results) {
		//��� �������� �� �� ������, �� ������ �� ���� ����� ��.
		//�÷��̵� ������ �ִܰŸ�ǥ�� �����, ǥ �� [i][j], [j][i] �� �ϳ��� ���� ������ ��� �������� �� �� �ִٰ� �Ǵ�.
		int INF = 100001;
		int answer = 0;
		int[][] fw = new int[n+1][n+1];
		
		//��� ��� INF�� ä���
		for(int[] arr : fw) {
			Arrays.fill(arr, INF);
		}
		
		//�÷��̵� ���� ǥ ä���
		for(int[] arr : results) {
			fw[arr[0]][arr[1]] = 1;
		}
		
		for(int k = 1; k < fw.length; k++) {				//��ġ�� ���
			for(int i = 1; i < fw.length; i++) {			//���� ����
				for(int j = 1; j < fw.length; j++) {		//���� ���� ex) k-1, i-2, j-3 �̸� 2->3 > 2->1->3�� ��
					if(fw[i][j] > fw[i][k] + fw[k][j]) {
						fw[i][j] = fw[i][k] + fw[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i < fw.length; i++) {
			boolean flag = true;
			for(int j = 1; j < fw[i].length; j++) {
				if(i == j) continue;
				if(fw[i][j] == INF && fw[j][i] == INF) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;				//��� �������� �� �� �ִ� ������ ã�� ���
		}
		return answer;
	}
	
}
