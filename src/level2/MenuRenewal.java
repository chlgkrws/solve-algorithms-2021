package level2;

<<<<<<< HEAD

public class MenuRenewal {
	/**
	 * level 2
	 * https://programmers.co.kr/learn/courses/30/lessons/72411
	 * 메뉴 리뉴얼
	 */
	public String[] solution(String[] orders, int[] course) {
		return new String[] {};
	}
	public static void main(String[] args) {
		MenuRenewal m = new MenuRenewal();
		m.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,4});
	}

=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuRenewal {
	/**
	 * level 2 / 2021 KAKAO BLIND RECRUITMENT
	 * 메뉴리뉴얼
	 * https://programmers.co.kr/learn/courses/30/lessons/72411
	 */
	public String[] solution(String[] orders, int[] course) {
		//가장 많이 함께 주문한 단품메뉴들을 코스요리로 구성
		//최소 2가지 이상 단품메뉴로 코스요리 구성
		//최소 2명 이상의 손님으로부터 주문된 담품메뉴 조합에 대해 코스요리 구성
		
		List<String> combine = new ArrayList<>();
		
		for(int i = 0; i < course.length; i++) {
			for(int j = 0; j < orders.length; j++) {
				combination(combine, orders[j], course[i]);
			}
		}
		
		combine.stream().forEach(System.out::println);
		return null;
	}
	
	//조합을해서 course에 맞게 List에 조합된 알파벳을 저장
	public void combination(List<String> combination, String orders, int count) {
		char[] order = orders.toCharArray();
		Arrays.sort(order);
		
		combination(combination, order, count);
	}
	
	public void combination(List<String> combination, char[] order, int count) {
		boolean[] visited = new boolean[order.length];
		combination(combination, visited, 0, "", order, count);
	}
	
	public void combination(List<String> combination, boolean[] visited, int idx, String target, char[] order, int count) {
		if(count == 0) {
			combination.add(target);
			return;
		}
		
		for(int i = idx; i < order.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				target += order[i];
				combination(combination, visited, idx+1, target, order, count-1);
				target = target.substring(0, target.length() - 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		MenuRenewal a = new MenuRenewal();
		a.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
	}
>>>>>>> 48d5b30465da4cc8cd57659e9ab18f22645b262c
}
