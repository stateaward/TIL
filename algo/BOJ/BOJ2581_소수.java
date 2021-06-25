package baekjoon;

import java.util.*;

// M~N 사이의 수 중 소수를 모두 찾아내고 최솟값 출력 + 전체 합 구하기

public class BOJ2581_소수 {
	static int GCD = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int MIN = Integer.MAX_VALUE;
		
		//	소수 : 나눠지는 수가 자신 뿐
here:	for (int i = M; i <= N; i++) {			
			// 입력값이 1인 경우는 넘기기
			if(i == 1) continue;
			
			// 소수의 조건에 따라, 2~본인-1 까지만 돌리기
			for (int j = 2; j < i; j++) {	
				if(i % j == 0) {	// 나눠지면 -> 소수 아냐, 다음 수로
					continue here;
				}
			}
			// 소수 판별을 통과하면, 소수이므로 더하고 최솟값
			sum += i;
			MIN = Math.min(MIN, i);
		}
		
		// 합이 계속 0이면, 소수가 없는 경우
		if(sum == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);
		System.out.println(MIN);

	}

}
