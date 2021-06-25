package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 풀이 순서
 * 1. 수 입력
 * 1-1. 연산자의 경우, 숫자 갯수대로 해당 숫자로 list에 넣기 (e.g. 11234)
 * 2. 연산자 갯수대로 순열 생성
 * 3. 순열 완성 시, 순서대로 숫자를 접근하며 계산하기
 * - 숫자는 Queue에 넣고, 계속 뽑아가며 시행
 * - 연산자는 ArrayList에 넣기
 */

public class BOJ14888_연잔사끼워넣기 {

	static Queue<Integer> number;
	static ArrayList<Integer> operator;
	static int[] picked;	// 뽑힌 연산자를 기록하기 위함
	static boolean[] isPick;

	// 문제에서 제시한 것대로 최대/최소 값을 설정
	static int MAX = -1000000000;
	static int MIN = 1000000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		number = new LinkedList<>();
		operator = new ArrayList<>();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			number.add(sc.nextInt());
		}

		for (int i = 1; i <= 4; i++) {
			int cur = sc.nextInt();
			int cnt = 1;
			while (cnt++ <= cur) {
				operator.add(i);
			}
		}

		picked = new int[operator.size()];
		isPick = new boolean[operator.size()];

		permutation(0);
		
		System.out.println(MAX);
		System.out.println(MIN);

	}

	// 순열 생성 - 연산자 넣기 위한
	// cnt : 현재 뽑은 수
	private static void permutation(int cnt) {
		if (cnt == operator.size()) {
			calculator();
			return;
		}
		
		for (int i = 0; i < picked.length; i++) {
			if(isPick[i]) continue;
			
			isPick[i] = true;
			picked[cnt] = operator.get(i);
			permutation(cnt+1);
			isPick[i] = false;
		}

	}

	// 뽑힌 순열을 기준으로 계산하여 MAX, MIN 값 도출
	private static void calculator() {
		// Queue로 숫자를 관리중이므로, 해당 숫자를 다시 넣음
		int res = number.poll();
		number.add(res);
		
		for (int i = 0; i < picked.length; i++) {
			int next = number.poll();
			number.add(next);
			
			switch(picked[i]) {
				case 1:	// 덧셈
					res = res + next;
					break;
				case 2:	// 뺄셈
					res = res - next;
					break;
				case 3:	// 곱셈
					res = res * next;
					break;
				case 4:	// 나눗셈
					if(res > 0) {
						res = res / next;
					}else {
						res = Math.abs(res) / next;
						res = -res;
					}
					break;
			};
		}
		
		MAX = Math.max(res, MAX);
		MIN = Math.min(res, MIN);
		
	}

}
