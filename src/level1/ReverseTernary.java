package level1;

public class ReverseTernary {
	
	/**
	 * 프로그래머스 Level 1 
	 * 3진법 뒤집기
	 * https://programmers.co.kr/learn/courses/30/lessons/68935
	 */
	public int solution(int n) {
		String rTernary = "";
		
		while(n >= 3) {											//3진법 변환
			rTernary += (n % 3) + "";
			n /= 3;
		}
		rTernary += n;											//마지막 몫 더해주기.
		
		int answer = Integer.parseInt(rTernary.toString(), 3);	//3진법 to 10진법
		return answer;
	}
}
