package level2;

import java.util.stream.Stream;

public class MultiplicationOfMatrices {

	/**
	 * level 2
	 * Çà·ÄÀÇ °ö¼À
	 * https://programmers.co.kr/learn/courses/30/lessons/12949
	 */
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] matrix = new int[arr1.length][arr2[0].length];
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2[0].length; j++) {
				int temp = 0;
				for(int k = 0; k < arr2.length; k++) {
					temp += arr1[i][k] + arr2[k][j];
				}
				matrix[i][j] = temp; 
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {

	}

}
