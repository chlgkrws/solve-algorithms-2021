package level1;

import java.util.HashMap;
import java.util.Map;

public class PressKeypad {
	
	/**
	 * level 1 / 2020 카카오 인턴십
	 * 키패드 누르기
	 * https://programmers.co.kr/learn/courses/30/lessons/67256
	 */
	public String solution(int[] numbers, String hand) {
		boolean isRight = hand.equals("right") ?  true : false;
		String result = "";
		
		int[] locateLeftHand = new int[] {0,3};				//*
		int[] locateRightHand = new int[] {2,3};			//#
		
		Map<Integer,Point> numState = new HashMap<>(); 
		
		
		numState.put(1, new Point(0, 0));
		numState.put(2, new Point(1, 0));
		numState.put(3, new Point(2, 0));
		numState.put(4, new Point(0, 1));
		numState.put(5, new Point(1, 1));
		numState.put(6, new Point(2, 1));
		numState.put(7, new Point(0, 2));
		numState.put(8, new Point(1, 2));
		numState.put(9, new Point(2, 2));
		numState.put(0, new Point(1, 3));
		
		for(int i = 0; i < numbers.length; i++) {
			int targetNumber = numbers[i];
			if(targetNumber == 1 || targetNumber == 4 || targetNumber == 7) {
				result += "L";
				locateLeftHand[0] = numState.get(targetNumber).getX();
				locateLeftHand[1] = numState.get(targetNumber).getY();
			}else if(targetNumber == 3 || targetNumber == 6 || targetNumber == 9) {
				result += "R";
				locateRightHand[0] = numState.get(targetNumber).getX();
				locateRightHand[1] = numState.get(targetNumber).getY();
			}else {																		//2, 5, 8, 0
				Point point = numState.get(targetNumber);
				int leftManhattan = getManhattanDistance(point.getX(), point.getY(), locateLeftHand[0], locateLeftHand[1]);
				int rightManhattan = getManhattanDistance(point.getX(), point.getY(), locateRightHand[0], locateRightHand[1]);
				
				if(leftManhattan < rightManhattan) {
					result += "L";
					locateLeftHand[0] = point.getX();
					locateLeftHand[1] = point.getY();
				}else if(leftManhattan > rightManhattan) {
					result += "R";
					locateRightHand[0] = point.getX();
					locateRightHand[1] = point.getY();
				}else {
					if(isRight) {
						result += "R";
						locateRightHand[0] = point.getX();
						locateRightHand[1] = point.getY();
					}else {
						result += "L";
						locateLeftHand[0] = point.getX();
						locateLeftHand[1] = point.getY();
					}
				}
			}
		}
		return result;
	}
	
	public int getManhattanDistance(int numX, int numY, int targetX, int targetY) {
		
		return Math.abs(numX - targetX) + Math.abs(numY - targetY);
	}
	
	class Point{
		private int x;
		private int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}
