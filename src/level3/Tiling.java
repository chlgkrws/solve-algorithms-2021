package level3;

public class Tiling {
	/**
	 * level 33
	 * 2 x n ≈∏¿œ∏µ
	 * https://programmers.co.kr/learn/courses/30/lessons/12900
	 */
	public int solution(int n) {
		int[] tile = new int[60000];
		tile[0] = 0;
		tile[1] = 1;
		tile[2] = 2;
		for(int i = 3; i < n; i++) {
			tile[i] = (tile[i-1] + tile[i-2]) % 1000000007;
		}
		
		return tile[n];
	}
}
