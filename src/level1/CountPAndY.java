package level1;


public class CountPAndY {
	
	/**
	 * 프로그래머스 Level 1 
	 * 문자열 내 p와 y의 개수
	 * https://programmers.co.kr/learn/courses/30/lessons/12916
	 */
	public boolean solution(String s) {
		// 1.p, y같으면 true, 아니면 false
		// 2.모두 없는 경우 true
		// 3.대소문자는 구별하지 않는다. o
		s = s.toLowerCase();						//소문자 치환 메서드 
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p') {
				count++;
				continue;
			}
			if(s.charAt(i) == 'y') {
				count--;
			}
		}
		
		return count == 0 ? true : false; 
	}
	public static void main(String[] args) {
		
	}

}



/*

s = s.toUpperCase();
int pCount = 0;
int yCount = 0;
for(int i = 0 ; i < s.length(); i++) {
	if(s.charAt(i)=='Y') {
		yCount++;
        continue;
	}
    if(s.charAt(i)=='P'){
		pCount++;
    }
}

return yCount == pCount ? true : false;
}
*/