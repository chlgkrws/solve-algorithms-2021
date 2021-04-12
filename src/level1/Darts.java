package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Darts {
	/**
	 * level 1 / 2018 KAKAO BLIND RECRUITMENT
	 * [1��] ��Ʈ ����
	 * https://programmers.co.kr/learn/courses/30/lessons/17682
	 */
	public int solution(String dartResult) {
		//�� 3�� ��ȸ
		//1ȸ�� 0~10 ȹ�� ����
		//S, D, T ���� ����, 1����, 2����, 3����
		//*��Ÿ��, #������ ����, *��Ÿ�� ��÷ �� �ٷ� ���� ���� ����, �ش� ���� 2�� / �������� �ش� ������ ���̳ʽ���
		//*�� ù��° ��ȸ�� ���� �� ������ �� ��� �ش� ������ 2�� 
		//*�� *�� ��ø���� 4��
		//*�� # ��ø���� -2��
		//s,d,t�� �������� �ϳ��� ���� *, #�� �� �� �ϳ��� ���� or ���� ���� �� �� ����
		
		Matcher m = Pattern.compile("[0-9]{1,2}[SDT]{1}[*#]?").matcher(dartResult);
		String[] darts = new String[3];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		HashMap<String, Integer> scoreMapping = new HashMap<String, Integer>();
		scoreMapping.put("S", 1);
		scoreMapping.put("D", 2);
		scoreMapping.put("T", 3);
		int dartsIdx = 0;
		
		//���� ��Ī �� ȸ���� ������
		while(m.find()) {
			darts[dartsIdx++] = m.group();
		}
		
		
		for(int i = 0; i < darts.length; i++) {
			//ù ��° �ڸ� Ȯ��
			//���� Ȯ��
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
				//ù ��° �õ� �϶�
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
