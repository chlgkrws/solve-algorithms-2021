package level3;

import java.util.Arrays;

public class Moving110 {
	/**
	 * level 3 / ���� �ڵ� ç���� ���� 2
	 * 110 �ű��
	 * https://programmers.co.kr/learn/courses/30/lessons/77886
	 */
	public String[] solution(String[] s) {
		//�ڿ��� ���� ������ ��ġ�� ã���鼭 0�̸� insert 1�̸� 0�� �����ϰų� ���ڿ� �� �п� ����

		String[] result = new String[s.length];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = moved110(s[i]);
		}
		
		return result;
	}
	
	public String moved110(String s) {
		//���� �� ����
		//110�� ã�� �� �ڿ��� ���� ����
		//1�̸� 0�� ���� ������ or �ε����� 0�� ������(���ڿ� �� ��)
		//0�̸� �ٷ� ����
		//���� ���� ������ üũ -> ������ ��ȯ
		
		StringBuffer originStr = new StringBuffer(s);
		StringBuffer AfterStr = new StringBuffer();
		
		return "";
	}
	
	public static void main(String[] args) {
		
	}
}
