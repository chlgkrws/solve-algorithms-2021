package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import level2.ShortestDistanceGameMap.Location;

public class ShortestDistanceGameMap {
	/**
	 * level 2 / ã�ƶ� ���α׷��� ��������
	 * ���� �� �ִܰŸ�
	 * https://programmers.co.kr/learn/courses/30/lessons/1844
	 */
	int[][] gameMap;
	public int solution(int[][] maps) {
		//�� ���� ���� maps[i][j] = 0�� ���.
		
		int n = maps.length;
		int m = maps[0].length;
		gameMap = new int[n][m];
		
		gameMap[n - 1][m - 1] = Integer.MAX_VALUE;
		
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(0,0,1));
		while(q.size() > 0) {
			Location present = q.poll();
			int i = present.i;
			int j = present.j;
			int v = present.prevDistance;
			//�ִܰŸ� �ݿ�
			gameMap[i][j] = v;
			
			if(gameMap[n - 1][m - 1] < v + 1) {
				continue;
			}
			
			//��
			if(j > 0 && maps[i][j-1] != 0 && (gameMap[i][j-1] > v + 1 || gameMap[i][j-1] == 0)) {
				q.add(new Location(i, j-1, v + 1));
			}
			//��
			if(j < m - 1 && maps[i][j+1] != 0 && (gameMap[i][j+1] > v + 1 || gameMap[i][j+1] == 0)) {
				q.add(new Location(i, j+1, v + 1));
			}
			//��
			if(i > 0 && maps[i-1][j] != 0 && (gameMap[i-1][j] > v + 1 || gameMap[i-1][j] == 0)) {
				q.add(new Location(i-1, j, v + 1));
			}
			//�Ʒ�
			if(i < n - 1 && maps[i+1][j] != 0 && (gameMap[i+1][j] > v + 1 || gameMap[i+1][j] == 0)) {
				q.add(new Location(i+1, j, v + 1));
			}
		}
		return gameMap[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : gameMap[n - 1][m - 1];
		
	}
    	class Location{
		int i;
		int j;
		int prevDistance;
		public Location(int i, int j, int prevDistance) {
			this.i = i;
			this.j = j;
			this.prevDistance = prevDistance;
		}
	}
	
	public static void main(String[] args) {
		ShortestDistanceGameMap a = new ShortestDistanceGameMap();
		a.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
	}
}
