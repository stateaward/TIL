package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_일곱난쟁이_2 {
	

	static int[] input;
	static int[] answer;
	static boolean[] visit;
	
	static boolean isFinal;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		visit = new boolean[9];
		
		answer = new int[7];
		
		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0, 0);
		
		Arrays.sort(answer);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void combination(int cnt, int cur, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				isFinal = true;
				return;
			}
			return;
		}
		
		for (int i = cur; i < input.length; i++) {
			if(isFinal) return;
			
			answer[cnt] = input[i];
			combination(cnt+1, i+1, sum + input[i]);
		}
		
	}

}
