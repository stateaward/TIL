package baekjoon;

import java.util.Scanner;

public class BOJ2460_지능형기차2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int person = 0;
		int MAX = 0;
		
		for (int i = 0; i < 10; i++) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			
			person = person - out + in;
			
			MAX = Math.max(person, MAX);
		}
		
		System.out.println(MAX);
		
	}

}
