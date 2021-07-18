package level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Tuple {

	/**
	 * level 2 / 2019 카카오 개발자 겨울 인턴십
	 * 튜플 
	 * https://programmers.co.kr/learn/courses/30/lessons/64065
	 */
	public int[] solution(String s) {
		s = removeFirstAndLastBracket(s);
		s = removeFirstAndLastBracket(s);
		String[] elements = s.split("\\},\\{");
		List<String[]> numbers = new ArrayList<>();
		
		
		for(int i = 0; i < elements.length; i++) {
			String[] element = elements[i].split(",");
			numbers.add(element);
		}
		
		numbers = numbers.stream()
					.sorted(new Comparator<String[]>() {
						@Override
						public int compare(String[] o1, String[] o2) {
							if(o1.length < o2.length) {
								return -1;
							}else if(o1.length > o2.length) {
								return 1;
							}else {
								return 0; 
							}
						}
					})
					.collect(Collectors.toList());
		
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i = 0; i < numbers.size(); i++) {
			String[] temp = numbers.get(i);
			for(String t : temp) {
				if(!set.contains(t)) {
					set.add(t);
				}
			}
		}
		
		return set.stream().mapToInt(Integer::parseInt).toArray();
	}
	
	public String removeFirstAndLastBracket(String s) {
		s = s.substring(1);
		s = s.substring(0, s.length() - 1);
		return s;
	}
}
