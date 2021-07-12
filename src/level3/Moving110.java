package level3;

import java.util.Arrays;

public class Moving110 {
	/**
	 * level 3 / 월간 코드 챌린지 시즌 2
	 * 110 옮기기
	 * https://programmers.co.kr/learn/courses/30/lessons/77886
	 */
	public String[] solution(String[] s) {
		//뒤에서 부터 삽입할 위치를 찾으면서 0이면 insert 1이면 0에 삽입하거나 문자열 맨 압에 삽입

		String[] result = new String[s.length];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = moved110(s[i]);
		}
		
		return result;
	}
	
	public String moved110(String s) {
		//이전 값 저장
		//110을 찾고 맨 뒤에서 부터 삽입
		//1이면 0이 나올 때까지 or 인덱스가 0일 떄까지(문자열 맨 앞)
		//0이면 바로 삽입
		//이전 값과 같은지 체크 -> 같으면 반환
		
		StringBuffer originStr = new StringBuffer(s);
		StringBuffer AfterStr = new StringBuffer();
		
		return "";
	}
	
	public static void main(String[] args) {
		
	}
}
