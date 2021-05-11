package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	
	/**
	 * level 2
	 * ��ɰ���
	 * https://programmers.co.kr/learn/courses/30/lessons/42586
	 */
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> workDate = new LinkedList<>();			//�۾� �ð�		
		ArrayList<Integer> result = new ArrayList<Integer>();	//���
		
		//100���� �ɸ��� �۾��ð� ����
		for(int i = 0; i < progresses.length; i++) {
			workDate.add((int)Math.ceil(((double)(100 - progresses[i])) / speeds[i]));	//�ɸ� �۾� �ð�
		}
		
		
		int max = workDate.poll();		//ó�� ���� ������ �����ϹǷ� ��� �� �� �־���
		int stack = 1;
		
		for(int i = 1; i < progresses.length; i++) {			//������ �ɸ� �ִ� �۾� �ð�����, ū �۾� �ð��� ���´ٸ� ����.
			if(max < workDate.peek()) {
				max = workDate.peek();
				result.add(stack);
				stack = 0;
			}
				workDate.poll();
				stack++;
		}
		result.add(stack);				//���������� ���� �ִ��۾� �ð����� ���� ��찡 ���� �� �����Ƿ� 
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
