package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Darts {
	/**
	 * level 1 / 2018 KAKAO BLIND RECRUITMENT
	 * [1차] 다트 게임
	 * https://programmers.co.kr/learn/courses/30/lessons/17682
	 */
	public int solution(String dartResult) {
		//총 3번 기회
		//1회당 0~10 획득 가능
		//S, D, T 영역 존재, 1제곱, 2제곱, 3제곱
		//*스타상, #아차상 존재, *스타상 당첨 시 바로 전에 얻은 점수, 해당 점수 2배 / 아차상은 해당 점수가 마이너스됨
		//*은 첫번째 기회에 나올 수 있지만 이 경우 해당 점수만 2배 
		//*와 *은 중첩가능 4배
		//*와 # 중첩가능 -2배
		//s,d,t는 점수마다 하나씩 존재 *, #은 둘 중 하나만 존재 or 존재 안할 수 도 있음
		
		Matcher m = Pattern.compile("[0-9]{1,2}[SDT]{1}[*#]?").matcher(dartResult);
		String[] darts = new String[3];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		HashMap<String, Integer> scoreMapping = new HashMap<String, Integer>();
		scoreMapping.put("S", 1);
		scoreMapping.put("D", 2);
		scoreMapping.put("T", 3);
		int dartsIdx = 0;
		
		//패턴 매칭 후 회차로 나누기
		while(m.find()) {
			darts[dartsIdx++] = m.group();
		}
		
		
		for(int i = 0; i < darts.length; i++) {
			//첫 번째 자리 확인
			//길이 확인
			int score = Integer.parseInt(darts[i].split("[SDT]")[0]);
			String sdt = darts[i].split("[0-9]{1,2}")[1].charAt(0) + "";			//ex) 10S* -> S* -> S
			
			score = (int)(Math.pow(score, scoreMapping.get(sdt)));
			
			Matcher astOrSha = Pattern.compile("[*#]").matcher(darts[i]);
			if(astOrSha.find()) {
				String astSha = astOrSha.group();
				if(i != 0) {
					if(astSha.equals("*")) {
						score *= 2;
						resultList.set(i - 1, resultList.get(i - 1) * 2);
					}else {
						score *= -1;
					}
				//첫 번째 시도 일때
				}else {
					if(astSha.equals("*")) {
						score *= 2;
					}else {
						score *= -1;
					}
				}
			}
			resultList.add(score);
		}
		
		return resultList.stream().mapToInt(Integer::intValue).sum();
	}
	
	public static void main(String[] args) {
		Darts a = new Darts();
		a.solution("1S2D*3T");
	}
}
