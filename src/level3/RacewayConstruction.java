package level3;

import java.util.LinkedList;
import java.util.Queue;

public class RacewayConstruction {

	/**
	 * level 3 / 2020 카카오 인턴십 경주로 건설
	 * https://programmers.co.kr/learn/courses/30/lessons/67259
	 */
	class Road {
		int x, y;
		int sum;
		int vector;

		public Road(int x, int y, int sum, int vector) {
			this.x = x;
			this.y = y;
			this.sum = sum;
			this.vector = vector;
		}
	}

	int minValue;
	int[][] map;
	int[] x = { -1, 0, 1, 0 };
	int[] y = { 0, -1, 0, 1 };
	int n;

	public int solution(int[][] board) {
		minValue = Integer.MAX_VALUE;
		n = board.length;
		map = board;

		bfs(0, 0, 0, -1);
		return minValue;
	}

	public void bfs(int x, int y, int sum, int vector) {
		Queue<Road> q = new LinkedList<>();
		q.add(new Road(x, y, sum, vector));
		map[0][0] = 1;
		
		while(!q.isEmpty()) {
			
			Road road = q.poll();
			if(road.x == n - 1 && road.y == n - 1) {
				if(minValue > road.sum) {
					minValue = road.sum;
				}
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int next_x = road.x + this.x[i];
				int next_y = road.y + this.y[i];
				if(next_x >= 0 && next_x < n && next_y >= 0 && next_y < n && map[next_x][next_y] != 1){
					int nextFieldSum = 0;
					
					if(road.vector == -1 || road.vector == i) {
						nextFieldSum = road.sum + 100;
					}else {
						nextFieldSum = road.sum + 600;
					}
					
					if(map[next_x][next_y] >= 0) {
						map[next_x][next_y] = nextFieldSum;
						q.add(new Road(next_x, next_y, nextFieldSum, i));
					}
					//처음 가는 곳인지 아닌지를 판단.
					if(map[next_x][next_y] == 0) {
						map[next_x][next_y] = nextFieldSum;
						q.add(new Road(next_x, next_y, nextFieldSum, i));
					}else if(map[next_x][next_y] >= nextFieldSum) {
						map[next_x][next_y] = nextFieldSum;
						q.add(new Road(next_x, next_y, nextFieldSum, i));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
