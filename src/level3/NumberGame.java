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
				if(B[j] < temp) {				//�ּڰ��� ���ؼ� ������ �̱�� ���� ������ �긦 ���� �ؾ��ϹǷ� �з��س�
					temp = B[j];
					tempIdx = j;
				}
			}
			if(j == B.length) {					//B�� ������ Ž���� ���� A�� �̱� ���.
				B[tempIdx] = 0;					//�ּڰ��� ������ �����Ѵ�.
			}
			temp = Integer.MAX_VALUE;
		}
		return bPoint;
	}
	public static void main(String[] args) {

	}

}
