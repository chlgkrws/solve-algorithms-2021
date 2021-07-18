package level3;

import java.util.HashMap;
import java.util.HashSet;

public class JewelryShopping {
	
	/**
	 * level 3 / 2020 카카오 인턴십
	 * 보석쇼핑
	 * https://programmers.co.kr/learn/courses/30/lessons/67258
	 */
	public int[] solution(String[] gems) {
		//셋으로 gems 개수세기
		//two pointer 방식으로 계산
		//map을 이용해서 s, e포인트를 지정하며 계산 진행.
		//e를 움직이며 map에 요소 add.
		//map의 size가 set의 사이즈와 같아진다면 다 찾으므로, e와 s의 차이를 term과 비교해 작으면 startpoint, endpoint를 저장한다.
		//다 찾았으면, s에 있는 요소를 +1해준다.
		
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
			
			//e 늘려가며 범위 잡기
			while(e < gems.length && set.size() != map.size()) {
				map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
				
				if(set.size() == map.size()) {
					break;
				}else {
					e++;
				}
			}
			//두 개의 포인터 차가 term 보다 작을 시 포인터 업데이트
			if(set.size() == map.size() && e - s < term && e - s >= 0) {
				System.out.println("s : "+ s +" e :" + e );
				startPoint = s;
				endPoint = e;
				term = e - s;
			}
			
			//만약 s에 위치한 map값이 1이면 삭제(1-1=0), 1보다 크다면 -1
			if(map.get(gems[s]) <= 1) {
				map.remove(gems[s]);
			}else {
				map.put(gems[s], map.get(gems[s]) - 1);
			}
			
		}
		return new int[] {startPoint+1, endPoint+1};
	}
}
