package level1;

public class Divisor {
	
	/**
	 * level 1 /���� �ڵ� ç���� ���� 2
	 * ����� ������ ����
	 * https://programmers.co.kr/learn/courses/30/lessons/77884
	 */
	public int solution(int left, int right) {
		int sum = 0;

		for(int i = left; i <= right; i++) {
			sum += getValueOrNegativeValue(i);
		}
		
		return sum;
	}

	public int getValueOrNegativeValue(int num) {
		int divisorCount = 0;
		
		for(int i = 1; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				divisorCount++;
		}
		System.out.println(divisorCount);
		return isEven(divisorCount) ? num : -num;
	}
	
	
	
	private boolean isEven(int divisorCount) {
		return divisorCount % 2 == 0 ? true : false;
	}

	public static void main(String[] args) {

	}

}
