package level1;

import java.util.HashSet;
import java.util.Set;

public class Ponketmon {
	/**
	 * 프로그래머스 Level 1 / 찾아라 프로그래밍 마에스터
	 * 폰켓몬
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
