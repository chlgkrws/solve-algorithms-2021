package level2;

public class WhichBeatIsLessThanTwo {
	
	/**
	 * level 2 / ���� �ڵ� ç���� ���� 2
	 * 2�� ���Ϸ� �ٸ� ��Ʈ
	 * https://programmers.co.kr/learn/courses/30/lessons/77885
	 */
	public long[] solution(long[] numbers) {
		
		long[] result = new long[numbers.length];
		
		for(int i = 0; i < result.length; i++) {				//�� ��� ���� ó��
			result[i] = nextValueDifferentBit(numbers[i]);
		}
		
        return result;
    }
	
	public long nextValueDifferentBit(long number) {
		String binary = "0" + Long.toBinaryString(number);		//111 -> 0111
		StringBuilder result = new StringBuilder(binary);		//���ڿ� ó�� ���Ǽ��� ���� StringBuilder�� ���
		
		int lastZeroIndex = result.lastIndexOf("0");			//ó�� 0�� �κ��� ã��
		result.setCharAt(lastZeroIndex, '1');					//0�� 1�� �ٲ���
			
		if(!isEvenNumber(number)) {								//number�� Ȧ����, 0 �������� 1�� 0���� �ٲ���
			result.setCharAt(result.indexOf("1", lastZeroIndex + 1), '0');
		}
		
		return convertFromBinaryToDecimal(result.toString());
	}
	
	public boolean isEvenNumber(long number) {					//¦�� ����
		return number % 2 == 0 ? true : false;
	}
	
	public long convertFromBinaryToDecimal(String binary) {		//2���� -> 10���� ġȯ
		return Long.parseLong(binary, 2);
	}
}
