package level3;

public class WordConversion {

	/**
	 * level 3 단어 변환 https://programmers.co.kr/learn/courses/30/lessons/43163
	 */
	boolean[] visited;
	int minCount;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		minCount = Integer.MAX_VALUE;
		
		dfs(begin, target, words, 0);

		return minCount != Integer.MAX_VALUE ? minCount : 0;
	}

	public void dfs(String begin, String target, String[] words, int preCount) {
		// 분기 한정
		if (preCount >= minCount) {
			return;
		}

		// 종료 조건 : begin과 target이 같고, 최소 단계이면 최소 단계 업데이트
		if (begin.equals(target)) {
			if (minCount > preCount) {
				minCount = preCount;
				return;
			}
		}

		for (int i = 0; i < words.length; i++) {
			if (begin.equals(words[i]))
				continue;
			if (!visited[i]) {
				if (convertor(begin, words[i])) {
					visited[i] = true;
					dfs(words[i], target, words, preCount + 1);
					visited[i] = false;
				}
			}
		}
	}

	public boolean convertor(String begin, String target) {
		int count = 0;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != target.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		WordConversion w = new WordConversion();
		w.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
	}

}
