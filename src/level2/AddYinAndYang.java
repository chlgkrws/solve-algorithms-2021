package level2;

import java.util.stream.IntStream;

public class AddYinAndYang {
	
	/**
	 * level 1 / ���� �ڵ� ç���� ����2
	 * ������ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/76501
	 * 2021.05.03
	 */
	public int solution(int[] absolutes, boolean[] signs) {
		//��� 1
//		int sum = 0;
//		
//		for(int i = 0; i < absolutes.length; i++) {
//			sum += signs[i] ? absolutes[i] : absolutes[i] * -1; 
//		}
//		return sum;
//		
		//��� 2
        return IntStream.range(0, absolutes.length).map(i -> signs[i] ? absolutes[i] * 1 : absolutes[i] * -1).sum();
    }
	
	public static void main(String[] args) {
		AddYinAndYang a = new AddYinAndYang();
		System.out.println(a.solution(new int[] {4,7,12}, new boolean[] {true,false,true}));
	}
}
