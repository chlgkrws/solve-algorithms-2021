package level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Camouflage {

	/**
	 * level 2
	 * ¿ß¿Â
	 * https://programmers.co.kr/learn/courses/30/lessons/42578
	 */
	public int solution(String[][] clothes) {
		int result = 1;
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		for(Entry<String, Integer> e : map.entrySet()) {
			result *= e.getValue() + 1;
		}
		
		return result - 1;
	}
}
