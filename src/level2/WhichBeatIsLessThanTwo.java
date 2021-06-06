package level2;

public class WhichBeatIsLessThanTwo {
	
	/**
	 * level 2 / 월간 코드 챌린지 시즌 2
	 * 2개 이하로 다른 비트
	 * https://programmers.co.kr/learn/courses/30/lessons/77885
	 */
	public long[] solution(long[] numbers) {
		
		long[] result = new long[numbers.length];
		
		for(int i = 0; i < result.length; i++) {				//각 요소 별로 처리
			result[i] = nextValueDifferentBit(numbers[i]);
		}
		
        return result;
    }
	
	public long nextValueDifferentBit(long number) {
		String binary = "0" + Long.toBinaryString(number);		//111 -> 0111
		StringBuilder result = new StringBuilder(binary);		//문자열 처리 편의성을 위해 StringBuilder를 사용
		
		int lastZeroIndex = result.lastIndexOf("0");			//처음 0인 부분을 찾음
		result.setCharAt(lastZeroIndex, '1');					//0을 1로 바꿔줌
			
		if(!isEvenNumber(number)) {								//number가 홀수면, 0 다음오는 1을 0으로 바꿔줌
			result.setCharAt(result.indexOf("1", lastZeroIndex + 1), '0');
		}
		
		return convertFromBinaryToDecimal(result.toString());
	}
	
	public boolean isEvenNumber(long number) {					//짝수 검증
		return number % 2 == 0 ? true : false;
	}
	
	public long convertFromBinaryToDecimal(String binary) {		//2진수 -> 10진수 치환
		return Long.parseLong(binary, 2);
	}
}
