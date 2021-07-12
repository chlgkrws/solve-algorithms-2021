package level3;

import java.util.LinkedList;
import java.util.Queue;

import level3.PedestrianParadise.Point;

public class PedestrianParadise {


	public int solution(int m, int n, int[][] cityMap) {
		int[][] resultMap = new int[m][n];

		bfs(cityMap,resultMap);

		return resultMap[m-1][n-1];
	}
	
	public void bfs(int[][] cityMap, int[][] resultMap) {
		int[] rightMove = {1, 0};
		int[] downMove = {0, 1};
		
		Queue<Point> q = new LinkedList<>();

		q.
		//첫 번째 출발 지점 연관지점 출발
		if(isPossibleToMoveRight(0, 1, cityMap)) {
			q.add(new Point(1, 0, 0));
		}
		
		if(isPossibleToMoveDown(1, 0, cityMap)) {
			q.add(new Point(0, 1, 1));
		}

		while(!q.isEmpty()){
			
		}
		
	}
	
	public boolean isPossibleToMoveRight(int i, int j, int[][] cityMap) {
		
		if(j >= cityMap[0].length - 1) {
			return false;
		}
		
		return isPossibleToMove(i, j, cityMap);
	}
	
	public boolean isPossibleToMoveDown(int i, int j, int[][] cityMap) {
		
		if(i >= cityMap.length - 1) {
			return false;
		}
		
		return isPossibleToMove(i, j, cityMap);
	}
	
	public boolean isPossibleToMove(int i, int j, int[][] cityMap) {
		if(cityMap[i][j] == 1) {
			return false;
		}
		return true;
	}
	
	
	class Point{
		int x;
		int y;
		int state; //상태 0 : 오른쪽 이동, 1 : 아래쪽 이동
		
		public Point(int x, int y, int state) {
			super();
			this.x = x;
			this.y = y;
			this.state = state;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getState() {
			return state;
		}
		
	}
}




























/**
 * level 3 / 2017 카카오코드 예선
 * 보행자 천국
 * https://programmers.co.kr/learn/courses/30/lessons/1832
 */