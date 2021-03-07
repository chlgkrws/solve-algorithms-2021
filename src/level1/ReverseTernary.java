package level1;

public class ReverseTernary {
	
	/**
	 * ���α׷��ӽ� Level 1 
	 * 3���� ������
	 * https://programmers.co.kr/learn/courses/30/lessons/68935
	 */
	public int solution(int n) {
		String rTernary = "";
		
		while(n >= 3) {											//3���� ��ȯ
			rTernary += (n % 3) + "";
			n /= 3;
		}
		rTernary += n;											//������ �� �����ֱ�.
		
		int answer = Integer.parseInt(rTernary.toString(), 3);	//3���� to 10����
		return answer;
	}
}
