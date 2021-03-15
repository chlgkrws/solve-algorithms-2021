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
		
		while(!s.equals("1")) {
			int zero = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') zero++;
			}
			
			s = s.replaceAll("0", "");
			s = Integer.toBinaryString(s.length());
			convertCount++;
			removeZero += zero;
		}
 		
		return new int[] {convertCount, removeZero};
	}
	public static void main(String[] args) {
			RepeatBinaryTransformation a = new RepeatBinaryTransformation();
			a.solution("011011101");
	}

}
