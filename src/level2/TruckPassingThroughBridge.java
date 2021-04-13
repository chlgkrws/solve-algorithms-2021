package level2;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingThroughBridge {
	
	/**
	 * level 2
	 * https://programmers.co.kr/learn/courses/30/lessons/42583
	 * �ٸ��� ������ Ʈ��
	 */
	public int solution(int bridge_lentgh, int weight, int[] truck_weights) {
		
		int answer = 0;									//�ð�
		int bridgeWeight = 0;							//���� �ٸ� ����
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		for(int truck : truck_weights) {
			while(true) {
				if(q.isEmpty()) {
					q.offer(truck);
					answer++;
					bridgeWeight += truck;
					break;
				}else if(q.size() == bridge_lentgh) {
					bridgeWeight -= q.poll();
				}else {
					if(bridgeWeight + truck > weight) {
						q.offer(0);
						answer++;
					}else {
						q.offer(truck);
						answer++;
						bridgeWeight += truck;
						break;
					}
				}
			}
		}
		
		return answer + bridge_lentgh;
	}

	public static void main(String[] args) {

	}

}
