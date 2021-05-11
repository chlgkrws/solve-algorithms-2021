package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	
	/**
	 * level 2
	 * 기능개발
	 * https://programmers.co.kr/learn/courses/30/lessons/42586
	 */
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> workDate = new LinkedList<>();			//작업 시간		
		ArrayList<Integer> result = new ArrayList<Integer>();	//결과
		
		//100까지 걸리는 작업시간 저장
		for(int i = 0; i < progresses.length; i++) {
			workDate.add((int)Math.ceil(((double)(100 - progresses[i])) / speeds[i]));	//걸린 작업 시간
		}
		
		
		int max = workDate.poll();		//처음 값은 무조건 존재하므로 계산 편리 상 넣어줌
		int stack = 1;
		
		for(int i = 1; i < progresses.length; i++) {			//이전에 걸린 최대 작업 시간보다, 큰 작업 시간이 나온다면 배포.
			if(max < workDate.peek()) {
				max = workDate.peek();
				result.add(stack);
				stack = 0;
			}
				workDate.poll();
				stack++;
		}
		result.add(stack);				//마지막까지 이전 최대작업 시간보다 작은 경우가 있을 수 있으므로 
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
