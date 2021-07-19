package level3;

public class LockAndKey {
	public boolean solution(int[][] key, int[][] lock) {
		int volume = lock.length * 3 - 2;
		int[][] testArr = new int[volume][volume];						//lock배열보다  (lock*3 -2) 만큼 큰 2차원 배열을 만든다.	
		
		for(int i = 0; i < lock.length; i++) {							
			for(int j = 0 ; j < lock.length; j++) {
				testArr[i+lock.length-1][j+lock.length-1] = lock[i][j];
			}
		}
		
		for(int i = 0; i < 4; i++) {									//key가 3번 회전할 수 있으므로
			for(int j = 0; j < volume - key.length + 1; j++) {
				for(int q = 0; q < volume - key.length +1; q++) {		//testArr 필드에서 key를 대입해본다.
					if(isCorrect(j, q, testArr.length, key, lock)) {
						return true;
					}
				}
			}
			key = turnArr(key);											//키회전
		}
		return false;
	}
	
	public int[][] turnArr(int[][] key) {								//키를 90도 회전 시키는 메서드
		int[][] tempArr = new int[key.length][key.length];
		for(int i = 0; i < key.length; i++) {
			int targetI = key.length-1;
			for(int j = 0; j <key.length; j++) {
				tempArr[i][j]= key[targetI][i]; 
				targetI--;
			}
		}
		return tempArr;
		
	}
	public boolean isCorrect(int n, int m, int testArrLen, int[][] key, int[][] lock) {
		int y = n;
		int x = m;
		int[][] ax= new int[testArrLen][testArrLen];
		
		for(int i = 0; i < key.length; i++) {				//TestArr크기의 빈배열의 적절한 위치에 key 요소를 넣고
			for(int j = 0; j < key.length; j++) {
				ax[y][x++] += key[i][j];
			}
			y++; x=m;
		}
		
		for(int i = 0; i < lock.length; i++) {				//키 값이 들어간 이차원 배열의 중앙에 lock의 값을 넣어준다. 
			for(int j = 0 ; j < lock.length; j++) {
				ax[i+lock.length-1][j+lock.length-1] += lock[i][j];
				if(ax[i+lock.length-1][j+lock.length-1] != 1) {		//lock의 모든 요소가 1이 아니면 false
					return false;
				}
			}
		}		
		return true;
	}
	public static void main(String[] args) { 
		int[][] a = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] b = {{1,1,1},{1,1,0},{1,0,1}};
		LockAndKey as = new LockAndKey();
		System.out.println(as.solution(a, b));
	}

}
