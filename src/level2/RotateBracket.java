package level2;

import java.util.Stack;

public class RotateBracket {
	
	/**
	 * level 2 / 월간 코드 챌린지 시즌2 
	 * 괄호 회전하기
	 * https://programmers.co.kr/learn/courses/30/lessons/76502
	 */
	public int solution(String s) {
		
		int answer = isCorrect(s);					//for문을 돌면서 한칸 씩 이동 시키기 전 수행
		
		for(int i = 1; i < s.length(); i++) {
			s = s.substring(1) + s.charAt(0);		//왼쪽으로 한칸 씩 이동
			
			answer += isCorrect(s);					//올바르지 않으면 + 1
		}
		
		return answer;
	}
	
	public int isCorrect(String s) {
		Stack<Character> stack = new Stack<>();
		
		try {
			//스택에 넣기
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '}') {		//닫는 괄호}, ), ] 일 때 스택에 최근에 쌓인 괄호가 여는 괄호인지 판단
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
				}else {							//여는 괄호(, {, ( 면 스택에 추가
					stack.add(s.charAt(i));
				}
			}
		}catch (Exception e) {					//빈 스택 참조시 발생할 수 있는 에러 예방
			return 0;
		}finally {
			if(stack.size() > 0) return 0;		//모든 케이스가 여는 괄호 일 때, ex= {{{{{
		}
		
		return 1;							
	}
	public static void main(String[] args) {
		RotateBracket a = new RotateBracket();
		a.solution("}]()[{");
	}

}
