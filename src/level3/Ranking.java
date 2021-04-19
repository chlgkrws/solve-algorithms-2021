package level3;

import java.util.Arrays;

public class Ranking {
	/**
	 * level 3
	 * 순위
	 * https://programmers.co.kr/learn/courses/30/lessons/49191
	 */
	public int solution(int n, int[][] results) {
		//모든 정점에서 갈 수 있으면, 그 정점은 비교 가능 대상이 됨.
		//플로이드 워샬로 최단거리표를 만들고, 표 중 [i][j], [j][i] 중 하나라도 길이 있으면 모든 정점에서 갈 수 있다고 판단.
		int INF = 100001;
		int answer = 0;
		int[][] fw = new int[n+1][n+1];
		
		//모든 경로 INF로 채우기
		for(int[] arr : fw) {
			Arrays.fill(arr, INF);
		}
		
		//플로이드 워샬 표 채우기
		for(int[] arr : results) {
			fw[arr[0]][arr[1]] = 1;
		}
		
		for(int k = 1; k < fw.length; k++) {				//거치는 경로
			for(int i = 1; i < fw.length; i++) {			//시작 정점
				for(int j = 1; j < fw.length; j++) {		//도착 정점 ex) k-1, i-2, j-3 이면 2->3 > 2->1->3을 비교
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
			if(flag) answer++;				//모든 정점에서 갈 수 있는 정점을 찾은 경우
		}
		return answer;
	}
	
}
