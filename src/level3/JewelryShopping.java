package level3;

import java.util.HashMap;
import java.util.HashSet;

public class JewelryShopping {
	
	/**
	 * level 3 / 2020 īī�� ���Ͻ�
	 * ��������
	 * https://programmers.co.kr/learn/courses/30/lessons/67258
	 */
	public int[] solution(String[] gems) {
		//������ gems ��������
		//two pointer ������� ���
		//map�� �̿��ؼ� s, e����Ʈ�� �����ϸ� ��� ����.
		//e�� �����̸� map�� ��� add.
		//map�� size�� set�� ������� �������ٸ� �� ã���Ƿ�, e�� s�� ���̸� term�� ���� ������ startpoint, endpoint�� �����Ѵ�.
		//�� ã������, s�� �ִ� ��Ҹ� +1���ش�.
		
		HashSet<String> set = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int term = Integer.MAX_VALUE;
		int s = 0;
		int e = 0;
		
		int startPoint = 0;
		int endPoint = 0;
		//set
		for(String gem : gems) {
			set.add(gem);
		}
		
		//two pointer
		for(int i = 0; i < gems.length; i++) {
			s = i;
			
			//e �÷����� ���� ���
			while(e < gems.length && set.size() != map.size()) {
				map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
				
				if(set.size() == map.size()) {
					break;
				}else {
					e++;
				}
			}
			//�� ���� ������ ���� term ���� ���� �� ������ ������Ʈ
			if(set.size() == map.size() && e - s < term && e - s >= 0) {
				System.out.println("s : "+ s +" e :" + e );
				startPoint = s;
				endPoint = e;
				term = e - s;
			}
			
			//���� s�� ��ġ�� map���� 1�̸� ����(1-1=0), 1���� ũ�ٸ� -1
			if(map.get(gems[s]) <= 1) {
				map.remove(gems[s]);
			}else {
				map.put(gems[s], map.get(gems[s]) - 1);
			}
			
		}
		return new int[] {startPoint+1, endPoint+1};
	}
}
