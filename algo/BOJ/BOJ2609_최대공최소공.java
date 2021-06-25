package baekjoon;

import java.util.*;

public class BOJ2609_최대공최소공 {
	static int GCD = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		//최대공약수(GCD) : 유클리드 호제법으로 구하기
		//최소공배수(LCM) : GCD * LCM = A * B
		
		euclid(A,B);
		
		int LCM = A * B / GCD;
		
		System.out.println(GCD);
		System.out.println(LCM);
	}
	
	private static void euclid(int a, int b) {
		//탈출 조건
		if(a % b == 0) {
			GCD = b;
			return;
		}
		
		//두번째 수를 나머지로 계속 나누는 과정
		euclid(b, (a%b));
	}

}
