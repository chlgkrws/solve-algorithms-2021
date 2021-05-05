package level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
	
	/**
	 * level 2
	 * ������
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * 2021.05.05
	 */
	public int solution(int[] priorities, int location) {
		//�켱����ť : �켱����ť���� ���� ���� ��⿭ �� ���� ���� ��
		//ť		  : docs(��ġ, �߿䵵)�� ����
		int answer = 1;
		
		PriorityQueue<Integer> importances = new PriorityQueue<Integer>(Collections.reverseOrder());	//max heap
		Queue<document> docs = new LinkedList<>();
		
		//�켱����ť�� ť�� �� �ֱ�
		for(int i = 0; i < priorities.length; i++) {
			importances.add(priorities[i]);
			docs.add(new document(i, priorities[i]));
		}
		
		
		while(true) {
			//ť���� ���� �տ��ִ� ������ ����.
			document doc = docs.peek();
			int docIPT = doc.importance;
			int highestIPT = importances.peek();
			
			//�ش� ������ �߿䵵�� ��⿭ �� ���� ���� �߿䵵�� ���ٸ� �� ��ȯ
			if(docIPT == highestIPT) {
				//�ش� ������ ��ġ�� �������� �־��� ��ġ�� ���ٸ� ���� ��ȯ
				if(doc.location == location) {
					return answer;
				}
				docs.poll();		//�μ�
				importances.poll();	//�μ�
				answer++;			
			}else {
				docs.add(docs.poll());		//������ �������� �־��ش�.
			}
		}
	}
	
	//���� Ŭ���� (��ġ, �߿䵵)
	class document{
		int location;
		int importance;
		
		public document(int location, int importance) {
			this.location = location;
			this.importance = importance;
		}
		
	}
}
