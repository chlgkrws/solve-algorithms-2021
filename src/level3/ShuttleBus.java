package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShuttleBus {

	/**
	 * level 3
	 * [1��] ��Ʋ����
	 * https://programmers.co.kr/learn/courses/30/lessons/17678
	 */
	public String solution(int n, int t, int m, String[] timetable) {
		//��Ʋ ���� Ƚ�� n
		//��Ʋ ���� ���� t
		//�� ��Ʋ�� Ż �� �ִ� �ִ� ũ�� �� m
		//ũ�簡 ��⿭�� �����ϴ� �ð��� ���� �迭 timetable
		
		//������� 
		//���� Ƚ���� ����Ѵ�.
		//�� ��Ʋ�� Ż �� �ִ� �ִ� ũ����� ����Ѵ� -> ������ ����� -1�� ���� �����ϸ� �ȴ�.
		//������ �������� üũ�� �߿�.-> 18:00 � ������ �ִ� ������ ���� 
		
		//���ѻ���
		//�ð� ������ �ٸ��� ������ timetable�� t�� �ʴ����� �ٲ۴�.
		
		//Ǯ��
		//00:00�� ���� 1�о� ������Ű�鼭 �񱳴� <=, ���� ������ Ż �� �ִ��� ���,
		//������ üũ����Ʈ�� ��ȯ�Ѵ�.
		
		//�ð� ����
		int second = 60;
		int startTime = 9 * 3600;	//09:00
		int lastTime = 18 * 3600;	//18:00
		//�ð��� ��� �� ������ �ٲ۴�.
		t = t * 60;
		
		//������ ũ�� ����
		Arrays.sort(timetable);
		//�ð� -> �ʷ� ����
		List<Integer> time = new ArrayList<>();
		for(int i = 0; i < timetable.length; i++) {
			time.add(Integer.parseInt(timetable[i].split(":")[0]) * 3600 + Integer.parseInt(timetable[i].split(":")[1]) *60); 
		}
		
		//ũ�� ��⿭
		Queue<Integer> waitQ = new LinkedList<>(time);
		int lastCrew = 0;
		int lastOnCrew = 0;
		//���� Ƚ����ŭ  
		for(int i = 0; i < n; i++) {
			int flag = 0;
			int on = 0;
			while(!waitQ.isEmpty() && flag < m) {			//��ٸ��� ũ�簡 �����ϰ�, m���� ������
				if(waitQ.peek() <= startTime) {				//���� Ż �� ������
					lastCrew = waitQ.poll();				//�ش� ũ����� �¿�鼭 ������ ũ�� ���.
					on++;
				}
				flag++;
			}
			lastOnCrew = m - on;							//������ ũ�簡 ������ ������, �ƴ��� üũ 
			if(waitQ.isEmpty()) break;						//�� �̻� Ż ũ�簡 ������ ����.
			if(startTime == lastTime) break;
            if(i + 1 == n) break;							//������ �����̸� �ð��� �߰����� ����.
			startTime += t;									//���� �����ð�.
		}
		if(lastOnCrew == 0) {								//������ ������ ����
			startTime = lastCrew - 60;						//������ ũ�� -1��
		}
		
		//�� -> �ð�, ������ �ٲٱ�
		String result = setLPad(((startTime / 3600)+""),2,"0")+":"+ setLPad(((startTime % 3600) / 60)+"",2,"0");
		return result;
	}
	
	private static String setLPad(String strContext, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = strContext.length(); i < iLen; i++) { // iLen���� ��ŭ strChar���ڷ� ä���.
			sbAddChar.append(strChar);
		}
		strResult = sbAddChar + strContext; // LPAD�̹Ƿ�, ä�﹮�ڿ� + �������ڿ��� Concate�Ѵ�.
		return strResult;
	}
	public static void main(String[] args) {
		//��Ʋ ���� Ƚ��
		System.out.println(setLPad(((3660 / 3600)+""),2,"0")+":"+ setLPad(((3660 % 3600) / 60)+"",2,"0"));
		
	}

}
