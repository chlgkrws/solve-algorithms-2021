package level1;

import java.util.HashSet;
import java.util.Set;

public class Ponketmon {
	/**
	 * ���α׷��ӽ� Level 1 / ã�ƶ� ���α׷��� ��������
	 * ���ϸ�
	 * https://programmers.co.kr/learn/courses/30/lessons/1845
	 */
	public int solution(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		
		return set.size() < nums.length/2 ? set.size() : nums.length/2; 
	}
}
