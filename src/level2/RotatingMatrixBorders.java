package level2;

import java.util.ArrayList;
import java.util.List;

public class RotatingMatrixBorders {

	/**
	 * level 2 / 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
	 * 행렬 테두리 회전하기
	 * https://programmers.co.kr/learn/courses/30/lessons/77485
	 */
    public int[] solution(int rows, int columns, int[][] queries) {
    	int num = 1;
    	int[] result = new int[queries.length];
    	int[][] table = new int[rows][columns];
    	
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < columns; j++) {
    			table[i][j] = num++;
    		}
    	}
    	
    	int resultIdx = 0;
    	
    	for(int i = 0; i < queries.length; i++) {
    		int[] element = minusOneFromElement(queries[i]);
    		
    		result[resultIdx++] = getMinValue(element, table);
    		
    	}
    	return result;
    }
    
    public int[] minusOneFromElement(int[] query) {
    	for(int i = 0; i < query.length; i++) {
    		query[i] -= 1;
    	}
    	return query;
    }
    
    public int getMinValue(int[] element, int[][] table) {
    	List<int[]> rotatingList = getRotatingArray(element);
    	
    	int tempFirst = table[rotatingList.get(0)[0]][rotatingList.get(0)[1]];
    	int min = Integer.MAX_VALUE;
    	for(int i = rotatingList.size() - 1; i > 0 ; i--) {
    		if(table[rotatingList.get(i)[0]][rotatingList.get(i)[1]] < min) {
    			min = table[rotatingList.get(i)[0]][rotatingList.get(i)[1]];
    		}
    		if(i == 1) {
    			table[rotatingList.get(i)[0]][rotatingList.get(i)[1]]  = tempFirst;
    			break;
    		}
    		table[rotatingList.get(i)[0]][rotatingList.get(i)[1]] = table[rotatingList.get(i - 1)[0]][rotatingList.get(i - 1)[1]];
    	}
    	return min;
    }
    
    public List<int[]> getRotatingArray(int[] element) {
    	List<int[]> rotatingList = new ArrayList<>();
    	int x1 = element[0];
    	int y1 = element[1];
    	int x2 = element[2];
    	int y2 = element[3];
    	
    	//윗줄
    	for(int i = y1; i < y2; i++) {
    		rotatingList.add(new int[] {x1, i});
    	}
    	//오른쪽줄
    	for(int i = x1; i < x2; i++) {
    		rotatingList.add(new int[] {i, y2});
    	}
    	//아랫줄
    	for(int i = y2; i > y1; i--) {
    		rotatingList.add(new int[] {x2, i});
    	}
    	//왼쪽줄
    	for(int i = x2; i >= x1; i--) {
    		rotatingList.add(new int[] {i, y1});
    	}
    	
    	return rotatingList;
    }
    
}
