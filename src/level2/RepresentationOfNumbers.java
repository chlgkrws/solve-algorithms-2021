package level2;

import java.util.stream.IntStream;

public class RepresentationOfNumbers {
	
	/**
	 * level 2
	 * 숫자의 표현
	 * https://programmers.co.kr/learn/courses/30/lessons/12924
	 */
	public int solution(int n) {
		int result = 1;
		int startPoint = 0;
		int endPoint = 1;
		int halfLength = n/2 + 1;
		int[] continuousNumber = IntStream.rangeClosed(0, halfLength)
				.toArray();
		
		for(int i = 1; i < continuousNumber.length; i++) {
			continuousNumber[i] += continuousNumber[i - 1];
		}
		
		while(startPoint < halfLength) {
			if(continuousNumber[endPoint] -  continuousNumber[startPoint] < n) {
				if(endPoint == halfLength) {
					break;
				}
				endPoint++;
			}else if(continuousNumber[endPoint] -  continuousNumber[startPoint] == n) {
				result++;
				
				if(endPoint == halfLength) {
					break;
				}
				
				endPoint++;
			}else {
				startPoint++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		RepresentationOfNumbers s = new RepresentationOfNumbers();
		System.out.println(s.solution(15));

	}

}
