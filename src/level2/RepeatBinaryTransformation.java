package level2;


public class RepeatBinaryTransformation {
	/**
	 * level 2
	 * 이진 변환 반복하기
	 * https://programmers.co.kr/learn/courses/30/lessons/70129
	 */
	public int[] solution(String s) {
		int convertCount = 0;
		int removeZero = 0;
		
		//s의 길이가 1이 아니면서
		while(!s.equals("1")) {
			int zero = 0;
			
			//0 개수 구하기.
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') zero++;
			}
			
			//0을 제거한 뒤, 해당 문자열의 길이를 이진수로 변환. ex 1111(4) -> 100
			s = s.replaceAll("0", "");
			s = Integer.toBinaryString(s.length());
			convertCount++;
			removeZero += zero;
		}
 		
		//변환한 스텝과 제거된 0의 개수를 배열로 반환
		return new int[] {convertCount, removeZero};
	}
	public static void main(String[] args) {
			RepeatBinaryTransformation a = new RepeatBinaryTransformation();
			a.solution("011011101");
	}

}
