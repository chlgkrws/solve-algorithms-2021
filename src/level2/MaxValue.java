package level2;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValue {
	
	/**
	 * level 2
	 * 가장 큰 수
	 * https://programmers.co.kr/learn/courses/30/lessons/42746
	 */
	public String solution(int[] numbers) {
		String[] stringNumbers = new String[numbers.length];
		
		//int형 배열을 String형 배열로 바꿈
		for(int i = 0; i < numbers.length; i++) {
			stringNumbers[i] = Integer.toString(numbers[i]);
		}
		
		//두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
		Arrays.sort(stringNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		if(stringNumbers[0].equals("0")) return "0";
		
		//문자열을 delimiter("") 기준으로 합침
		return String.join("", stringNumbers);
	}
	

	public static void main(String[] args) {

	}

}
