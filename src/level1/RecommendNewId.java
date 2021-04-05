package level1;

public class RecommendNewId {
	/**
	 * ���α׷��ӽ� level 1 / 2021 KAKAO BLIND RECRUITMENT �ű� ���̵� ��õ
	 * https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
	 */
	public String solution(String new_id) {
		
		//1�ܰ� 
		new_id = new_id.toLowerCase(); 	
		
		//2�ܰ�
		new_id = new_id.replaceAll("[^a-z0-9-_.]", ""); 
		
		//3�ܰ�
		new_id = new_id.replaceAll("[.]+", "."); 	
		
		//4�ܰ�
		new_id = new_id.charAt(0) == '.' ? new_id.substring(1) : new_id;
		new_id = new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;
		
		//5�ܰ�
		new_id = new_id.equals("") ? "a" : new_id;
		
		//6�ܰ�
		new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
		new_id = new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;
		
		//7�ܰ�
		while(new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
		
		return new_id;
	} 

	public static void main(String[] args) {
		      
		RecommendNewId rni = new RecommendNewId();
		rni.solution("");

		System.out.println("abcde".substring(0, 5));
	}
}
