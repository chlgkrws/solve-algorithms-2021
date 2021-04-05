package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RankingSearch {

	/**
	 * level 2 / 2021 KAKAO BLIND RECRUITMENT
	 * 순위 검색
	 * https://programmers.co.kr/learn/courses/30/lessons/72412
	 */
	public int[] solution(String[] info, String[] query) {
		// 다 상이한 값이기 때문에, 비교할 부분이 있다면 앞자리만 비교한다.
		// 패턴매칭으로 찾는다...
		
		String langRex = "[a-z]{3,6}";
		String devRex = "[a-z]{7,8}";
		String exRex = "[a-z]{6}";
		String food = "[a-z]{5,7}";
		
		int[] answer = new int[query.length];
		int answerIdx = 0;
		for(int i = 0; i < query.length; i++) {
			String rex = query[i].replaceAll("and", " ");
			String[] rexs = rex.split(" ");
			
			for(int j = 0; j < rexs.length; j++) {
				if(rexs[j].equals("-")) {
					if(j == 0) {
						rexs[j] = langRex; 
					}else if(j == 1) {
						rexs[j] = devRex;
					}else if(j == 2) {
						rexs[j] = exRex;
					}else {
						rexs[j] = food;
					}
				}
			}
			
			rex = rexs[0];
			for(int j = 1; j < rexs.length; j++) {
				rex += " "+rexs[j];
			}
			
			Pattern p = Pattern.compile(rex);
			Matcher m;
			int count = 0;
			for(int q = 0; q < info.length; q++) {
				m = p.matcher(info[q]);
				int temp = -1;
				if(m.matches()) {
					temp = Integer.parseInt(m.group().split(" ")[4]);
				}
				if(Integer.parseInt(query[i].split(" ")[4]) <= temp) {
					count++;
				}
			}
			answer[answerIdx++] = count;
			
		}
		return answer;
    }
	
	public static void main(String[] args) {
		Matcher m = Pattern.compile("[a-z]{3,6} [a-z]{7,8} junior pizza [0-9]{0,3}").matcher("java backend junior pizza 150");
		System.out.println(m.matches());
		System.out.println(m.group());
		String[] a= {"aa","2"};
		Arrays.toString(a);
		System.out.println(Arrays.toString(a).toString());
	}

}
