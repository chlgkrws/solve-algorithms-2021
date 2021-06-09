package level2;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {

	
	/**
	 * level 2 / 2017 īī���ڵ� ����
	 * īī�������� �÷�����
	 * https://programmers.co.kr/learn/courses/30/lessons/1829
	 */
	int areaCount;		//���� ����
	int largestAreaElements;		//���� ū ����
	boolean[][] visited;		//�湮����
	
	public int[] solution(int m, int n, int[][] picture) {
		largestAreaElements = 0;
		areaCount = 0;
		visited = new boolean[m][n];

		for(int i = 0; i < picture.length; i++) {
			for(int j = 0; j < picture[0].length; j++) {
				if(!visited[i][j] && picture[i][j] != 0) {
					bfs(i, j, picture[i][j], picture);
					areaCount++;
				}
			}
		}
		
		return new int[] {areaCount, largestAreaElements};
	}
	
	public void bfs(int i, int j, int targetValue, int[][] picture) {
		int areaElementCount = 1;		//���� ��� ��
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(j, i));
		
		while(!q.isEmpty()) {
			Point present = q.poll();
			int y = present.getY();
			int x = present.getX();
			System.out.println(y+ " "+x);
			visited[y][x] = true;
			
			if(y > 0 && !visited[y - 1][x] && picture[y - 1][x] == targetValue) {		//�� ��� Ž��
				q.add(new Point(x, y - 1));
				visited[y - 1][x] = true;
				areaElementCount++;
			}
			
			if(y < picture.length - 1 && !visited[y + 1][x] &&  picture[y + 1][x] == targetValue) {		//�Ʒ���� Ž��
				q.add(new Point(x, y + 1));
				visited[y + 1][x] = true;
				areaElementCount++;
			}
			
			if(x > 0 && !visited[y][x - 1] && picture[y][x - 1] == targetValue) {		//���ʿ�� Ž��
				q.add(new Point(x - 1, y));
				visited[y][x - 1] = true;
				areaElementCount++;
			}
			
			if(x < picture[0].length - 1 && !visited[y][x + 1] &&  picture[y][x + 1] == targetValue) {		//�����ʿ�� Ž��
				q.add(new Point(x + 1, y));
				visited[y][x + 1] = true;
				areaElementCount++;
			}
		}
		
		if(areaElementCount > largestAreaElements) {		//���� ū ����
			largestAreaElements = areaElementCount;
		}
	}
	
	class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
	

	public static void main(String[] args) {
		KakaoFriendsColoringBook s = new KakaoFriendsColoringBook();
		s.solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});

	}

}
