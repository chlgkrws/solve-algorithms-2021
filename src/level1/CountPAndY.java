package level1;


public class CountPAndY {
	
	/**
	 * ���α׷��ӽ� Level 1 
	 * ���ڿ� �� p�� y�� ����
	 * https://programmers.co.kr/learn/courses/30/lessons/12916
	 */
	public boolean solution(String s) {
		// 1.p, y������ true, �ƴϸ� false
		// 2.��� ���� ��� true
		// 3.��ҹ��ڴ� �������� �ʴ´�. o
		s = s.toLowerCase();						//�ҹ��� ġȯ �޼��� 
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