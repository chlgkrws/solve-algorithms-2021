package level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
	
	/**
	 * level 2
	 * 프린터
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 * 2021.05.05
	 */
	public int solution(int[] priorities, int location) {
		//우선순위큐 : 우선순위큐에서 뽑은 값은 대기열 중 가장 높은 값
		//큐		  : docs(위치, 중요도)를 저장
		int answer = 1;
		
		PriorityQueue<Integer> importances = new PriorityQueue<Integer>(Collections.reverseOrder());	//max heap
		Queue<document> docs = new LinkedList<>();
		
		//우선순위큐와 큐에 값 넣기
		for(int i = 0; i < priorities.length; i++) {
			importances.add(priorities[i]);
			docs.add(new document(i, priorities[i]));
		}
		
		
		while(true) {
			//큐에서 가장 앞에있는 문서를 본다.
			document doc = docs.peek();
			int docIPT = doc.importance;
			int highestIPT = importances.peek();
			
			//해당 문서의 중요도와 대기열 중 가장 높은 중요도가 같다면 값 반환
			if(docIPT == highestIPT) {
				//해당 문서의 위치와 문제에서 주어진 위치가 같다면 순서 반환
				if(doc.location == location) {
					return answer;
				}
				docs.poll();		//인쇄
				importances.poll();	//인쇄
				answer++;			
			}else {
				docs.add(docs.poll());		//문서를 마지막에 넣어준다.
			}
		}
	}
	
	//문서 클래스 (위치, 중요도)
	class document{
		int location;
		int importance;
		
		public document(int location, int importance) {
			this.location = location;
			this.importance = importance;
		}
		
	}
}
