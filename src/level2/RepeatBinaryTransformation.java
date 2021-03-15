package level2;


public class RepeatBinaryTransformation {
	/**
	 * level 2
	 * ���� ��ȯ �ݺ��ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/70129
	 */
	public int[] solution(String s) {
		int convertCount = 0;
		int removeZero = 0;
		
		//s�� ���̰� 1�� �ƴϸ鼭
		while(!s.equals("1")) {
			int zero = 0;
			
			//0 ���� ���ϱ�.
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') zero++;
			}
			
			//0�� ������ ��, �ش� ���ڿ��� ���̸� �������� ��ȯ. ex 1111(4) -> 100
			s = s.replaceAll("0", "");
			s = Integer.toBinaryString(s.length());
			convertCount++;
			removeZero += zero;
		}
 		
		//��ȯ�� ���ܰ� ���ŵ� 0�� ������ �迭�� ��ȯ
		return new int[] {convertCount, removeZero};
	}
	public static void main(String[] args) {
			RepeatBinaryTransformation a = new RepeatBinaryTransformation();
			a.solution("011011101");
	}

}
