package level3;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;


public class MakeAllZeroes {
	
	/**
	 * level 3 / 월간 코드 챌린지 시즌 2
	 * 모두 0으로 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/76503
	 */
	long answer;
	boolean[] visited; 
	ArrayList<ArrayList<Integer>> tree;
	public long solution(int[] a, int[][] edges) {
		answer = 0;
		
		int sum = IntStream.of(a).sum();
		if(sum != 0) return -1;
		
		tree = new ArrayList<ArrayList<Integer>>();
		
		//방문 초기화
		visited = new boolean[a.length];
		
		//트리 초기화
		for(int i = 0; i < a.length; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		//양방향으로 선언
//		for(int[] edge : edges) {
//			tree.get(edge[0]).add(edge[1]);
//			tree.get(edge[1]).add(edge[0]);
//		}

		for(int i = 0; i < edges.length; i++) {
			tree.get(edges[i][0]).add(edges[i][1]);
			tree.get(edges[i][1]).add(edges[i][0]);
		}
		visited[0] = true;
		return dfs(a, 0) == 0 ? answer : -1;
	}
	
	public long dfs(int[] a, int index) {
		long sum = 0;
			//본인 노드의 값을 sum에 더함
//			for(int e : tree.get(index)) {
//				if(!visited[e]) {
//					visited[e] = true;
//					sum += dfs(a, e, tree);
//				}
//			}
			ArrayList<Integer> temp = tree.get(index);
			for(int i = 0; i < temp.size(); i++) {
				if(!visited[temp.get(i)]) {
					visited[temp.get(i)] = true;
					sum = sum + dfs(a, temp.get(i));
				}
			}
		sum += a[index];
		answer = answer + Math.abs(sum);
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		MakeAllZeroes m = new MakeAllZeroes();
		m.solution(	new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}});
	}

}
