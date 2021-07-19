package level3;

public class longestPalindrome {
	public int solution(String s) {
		int oddCount = 0;
		int evenCount = 0;
		if(s.length() == 1) {			//���̰� 1�̸� 1��ȯ
			return 1;
		}
		for(int i = 0; i < s.length()-1; i++) {
			if(i>0 && s.charAt(i-1) == s.charAt(i+1)) {  //Ȧ ��
				int left = i-1;
				int right = i+1;
				int tempcount = 0;
				while(0<= left &&  right <= s.length()-1) {	//���� ������ ����, ������ ���� ������
					if(s.charAt(left) == s.charAt(right)) {
						tempcount++;
						left -= 1;
						right += 1;
					}else {
						break;
					}
				}
				if(oddCount< tempcount) oddCount = tempcount;
			}
			if(s.charAt(i) == s.charAt(i+1)) {			//¦ ��
				int left = i;
				int right = i+1;
				int tempcount = 0;
				while(0<= left &&  right <= s.length()-1) { //���簪�� �������� ���ٸ�.
					if(s.charAt(left) == s.charAt(right)) {
						tempcount++;
						left -= 1;
						right += 1;
					}else {
						break;
					}
				}
				if(evenCount < tempcount) evenCount = tempcount;
			}
		}
		return oddCount < evenCount ? evenCount*2 : oddCount*2 +1; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
