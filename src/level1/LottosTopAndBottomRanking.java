package level1;

import java.util.HashSet;
import java.util.Set;

public class LottosTopAndBottomRanking {
	/**
	 * level 1
	 * 로또의 최고 순위와 최저 순위
	 * 2021.04.28
	 */
	public int[] solution(int[] lottos, int[] win_nums) {
		int countZero = 0;
		int countSame = 0;
		
		int[] level = {6, 6, 5, 4, 3, 2, 1};
		
		Set<Integer> set = new HashSet<>();
		
		for(int e : win_nums) {
			set.add(e);
		}
		
		for(int e : lottos) {
			if(e == 0) {
				countZero++;
				continue;
			}
			if(set.contains(e)) countSame++;
		}
		
        return new int[] {level[countSame + countZero], level[countSame]};
    }
}
