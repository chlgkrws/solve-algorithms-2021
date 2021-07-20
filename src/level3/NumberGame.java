package level3;

import java.util.Arrays;

public class NumberGame {
	public int solution(int[] A, int[] B) {
		Arrays.sort(B);
		int bPoint = 0;
		int comp = 0;
		int temp = Integer.MAX_VALUE;
		int tempIdx = 0;
		for(int i = 0; i < A.length; i++) {
			comp = A[i];
			int j = 0;
			for(j = 0; j < B.length; j++) {
				if(B[j] == 0) continue;
				if(B[j] > comp) {
					B[j] = 0;
					bPoint++;
					break;
				}
				if(B[j] < temp) {				//최솟값에 대해서 앞으로 이기는 수가 없으면 얘를 삭제 해야하므로 분류해놈
					temp = B[j];
					tempIdx = j;
				}
			}
			if(j == B.length) {					//B를 끝까지 탐색한 경우는 A가 이긴 경우.
				B[tempIdx] = 0;					//최솟값을 내보내 지게한다.
			}
			temp = Integer.MAX_VALUE;
		}
		return bPoint;
	}
	public static void main(String[] args) {

	}

}
