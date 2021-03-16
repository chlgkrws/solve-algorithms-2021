package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShuttleBus {

	/**
	 * level 3
	 * [1차] 셔틀버스
	 * https://programmers.co.kr/learn/courses/30/lessons/17678
	 */
	public String solution(int n, int t, int m, String[] timetable) {
		//셔틀 은행 횟수 n
		//셔틀 은행 간격 t
		//한 셔틀에 탈 수 있는 최대 크루 수 m
		//크루가 대기열에 도착하는 시각을 모은 배열 timetable
		
		//고려사항 
		//운행 횟수를 고려한다.
		//한 셔틀에 탈 수 있는 최대 크루수를 고려한다 -> 마지막 사람의 -1분 빨리 도착하면 된다.
		//마지막 버스인지 체크가 중요.-> 18:00 운영 가능한 최대 마지막 버스 
		
		//제한사항
		//시간 형식이 다르기 때문에 timetable과 t를 초단위로 바꾼다.
		
		//풀이
		//00:00분 부터 1분씩 증가시키면서 비교는 <=, 다음 버스를 탈 수 있는지 고려,
		//마지막 체크포인트를 반환한다.
		
		//시간 증가
		int second = 60;
		int startTime = 9 * 3600;	//09:00
		int lastTime = 18 * 3600;	//18:00
		//시간을 모두 초 단위로 바꾼다.
		t = t * 60;
		
		//도착한 크루 정렬
		Arrays.sort(timetable);
		//시간 -> 초로 수정
		List<Integer> time = new ArrayList<>();
		for(int i = 0; i < timetable.length; i++) {
			time.add(Integer.parseInt(timetable[i].split(":")[0]) * 3600 + Integer.parseInt(timetable[i].split(":")[1]) *60); 
		}
		
		//크루 대기열
		Queue<Integer> waitQ = new LinkedList<>(time);
		int lastCrew = 0;
		int lastOnCrew = 0;
		//운행 횟수만큼  
		for(int i = 0; i < n; i++) {
			int flag = 0;
			int on = 0;
			while(!waitQ.isEmpty() && flag < m) {			//기다리는 크루가 존재하고, m보다 작으면
				if(waitQ.peek() <= startTime) {				//현재 탈 수 있으면
					lastCrew = waitQ.poll();				//해당 크루들을 태우면서 마지막 크루 기록.
					on++;
				}
				flag++;
			}
			lastOnCrew = m - on;							//마지막 크루가 꽉차게 탔는지, 아닌지 체크 
			if(waitQ.isEmpty()) break;						//더 이상 탈 크루가 없으면 종료.
			if(startTime == lastTime) break;
            if(i + 1 == n) break;							//마지막 루프이면 시간을 추가하지 않음.
			startTime += t;									//다음 버스시간.
		}
		if(lastOnCrew == 0) {								//막차에 여유가 없음
			startTime = lastCrew - 60;						//마지막 크루 -1분
		}
		
		//초 -> 시간, 분으로 바꾸기
		String result = setLPad(((startTime / 3600)+""),2,"0")+":"+ setLPad(((startTime % 3600) / 60)+"",2,"0");
		return result;
	}
	
	private static String setLPad(String strContext, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = strContext.length(); i < iLen; i++) { // iLen길이 만큼 strChar문자로 채운다.
			sbAddChar.append(strChar);
		}
		strResult = sbAddChar + strContext; // LPAD이므로, 채울문자열 + 원래문자열로 Concate한다.
		return strResult;
	}
	public static void main(String[] args) {
		//셔틀 은행 횟수
		System.out.println(setLPad(((3660 / 3600)+""),2,"0")+":"+ setLPad(((3660 % 3600) / 60)+"",2,"0"));
		
	}

}
