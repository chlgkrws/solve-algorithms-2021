package level2;

import java.util.Stack;

public class RotateBracket {
	
	/**
	 * level 2 / ���� �ڵ� ç���� ����2 
	 * ��ȣ ȸ���ϱ�
	 * https://programmers.co.kr/learn/courses/30/lessons/76502
	 */
	public int solution(String s) {
		
		int answer = isCorrect(s);					//for���� ���鼭 ��ĭ �� �̵� ��Ű�� �� ����
		
		for(int i = 1; i < s.length(); i++) {
			s = s.substring(1) + s.charAt(0);		//�������� ��ĭ �� �̵�
			
			answer += isCorrect(s);					//�ùٸ��� ������ + 1
		}
		
		return answer;
	}
	
	public int isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		
		try {
			//���ÿ� �ֱ�
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '}') {		//�ݴ� ��ȣ}, ), ] �� �� ���ÿ� �ֱٿ� ���� ��ȣ�� ���� ��ȣ���� �Ǵ�
					if(stack.peek() != '{') {
						return 0;
					}
					stack.pop();
				}else if(s.charAt(i) == ']') {
					if(stack.peek() != '[') {
						return 0;
					}
					stack.pop();
				}else if(s.charAt(i) == ')') {
					if(stack.peek() != '(') {
						return 0;
					}
					stack.pop();
				}else {							//���� ��ȣ(, {, ( �� ���ÿ� �߰�
					stack.add(s.charAt(i));
				}
			}
		}catch (Exception e) {					//�� ���� ������ �߻��� �� �ִ� ���� ����
			return 0;
		}finally {
			if(stack.size() > 0) return 0;		//��� ���̽��� ���� ��ȣ �� ��, ex= {{{{{
		}
		
		return 1;							
	}
	public static void main(String[] args) {
		RotateBracket a = new RotateBracket();
		a.solution("}]()[{");
	}

}
