package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SSAFY SWEA 1952 수영장
 * @author Park Sangwoo
 * @since 2020-11-02
 * @use DP
 */
public class Solution1952_수영장_DP {
	
	static int moneys[], days[], min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			//이용권 가격들
			moneys = new int [4];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				moneys[i]=Integer.parseInt(st.nextToken());
			}
			// 12개월 이용계획
			days = new int[13];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= 12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#"+t+" "+plan());
		}
		
	}
	
	private static int plan() {
		int D[] = new int [13];
		
		for (int i = 1; i <= 12; i++) {
			//1일권
			D[i] = D[i-1] + days[i] * moneys[0];
			//1달권
			if(days[i]>0) D[i] = Math.min(D[i], D[i-1] + moneys[1]);
			//3달권
			if(i>=3) D[i] = Math.min(D[i], D[i-3] + moneys[2]);
			
		}
		return Math.min(D[12], moneys[3]);
	}
}
