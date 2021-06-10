import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ17140_이차원_배열과_연산 {

	static class Num implements Comparable<Num> {
		int num, cnt;

		public Num(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (this.cnt == o.cnt) {
				if (this.num > o.num) {
					return 1;
				} else {
					return -1;
				}
			} else if (this.cnt > o.cnt) { // 첫 번째가 더 크다면, 오름차순(1) / 내림차순(-1)
				return 1;
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "(num=" + num + ", cnt=" + cnt + ")";
		}

	}

	static int[][] map;
	static int[] number; // 숫자들을 카운트해줄 변수

	static ArrayList<Num> numList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();

		map = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int time = -1;
		
		// 시간을 100까지 시행
		while (++time <= 100) {
			
			/* @생각
			 * map의 크기가 계속 변하므로, 아닌 곳에 접근했을 때도 생각해주어야 한다.
			 */
			if((r-1 < map.length && c-1 < map[0].length)
					&& map[r-1][c-1] == k) {
				System.out.println(time);
				return;
			}
			
			// R 연산 적용
			if (map[0].length <= map.length) {
				rowCalc();
			} else { // C 연산 적용
				columnCalc();
			}

		}

		System.out.println(-1);
	}

	// R연산 적용 -> 행별로 카운트
	private static void rowCalc() {

		int[][] tempMap = new int[map.length][];
		int maxRow = 0;

		// 행 별로 나온수를 카운트하기
		for (int i = 0; i < map.length; i++) {
			number = new int[101];
			numList.clear();

			// 행렬의 행을 돌면서, 나온 수만큼 카운트 UP
			for (int j = 0; j < map[i].length; j++) {
				number[map[i][j]]++;
			}

			// 카운트를 돌면서, 넘버 리스트에 숫자, 카운트 순서로 삽입
			for (int j = 1; j <= 100; j++) {
				if (number[j] != 0) {
					numList.add(new Num(j, number[j]));
				}
			}

			// 정렬 실행
			Collections.sort(numList);

			// 가장 큰 맥스 값을 기준으로 새로운 배열 생성
			maxRow = Math.max(numList.size() * 2, maxRow);

			// tempMap에 할당하기
			tempMap[i] = new int[numList.size() * 2];

			for (int j = 0, k = 0; j < tempMap[i].length; j += 2, k++) {
				tempMap[i][j] = numList.get(k).num;
				tempMap[i][j + 1] = numList.get(k).cnt;
			}
		}

		// 가장 큰 행을 기준으로 map 셋팅
		map = new int[map.length][maxRow];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (j < tempMap[i].length) {
					map[i][j] = tempMap[i][j];
				} else {
					map[i][j] = 0;
				}
			}
		}
		
//		print(map);

	}

	// C연산 적용 -> 열별로 카운트
	private static void columnCalc() {

		int[][] tempMap = new int[map[0].length][];
		int maxCol = 0;

		// 열 별로 나온수를 카운트하기
		for (int i = 0; i < map[0].length; i++) {
			number = new int[101];
			numList.clear();
			

			// 행렬의 열을 돌면서, 나온 수만큼 카운트 UP
			for (int j = 0; j < map.length; j++) {
				number[map[j][i]]++;
			}

			// 카운트를 돌면서, 넘버 리스트에 숫자, 카운트 순서로 삽입
			for (int j = 1; j <= 100; j++) {
				if (number[j] != 0) {
					numList.add(new Num(j, number[j]));
				}
			}

			// 정렬 실행
			Collections.sort(numList);

			// 가장 큰 맥스 값을 기준으로 새로운 배열 생성
			maxCol = Math.max(numList.size() * 2, maxCol);
			
			/* 
			 * @생각
			 * 열을 기준으로 temp값이 생성되어야 하는데, 배열 자체는 행을 기준으로 생성됨
			 * 일단 생성은 행기준으로 하고, 넣을 때 수정하자 헀는데. 그 과정에서 실수 발생..
			 */

			// tempMap에 할당하기
			tempMap[i] = new int[numList.size() * 2];

			for (int j = 0, k = 0; j < tempMap[i].length; j += 2, k++) {
				tempMap[i][j] = numList.get(k).num;
				tempMap[i][j + 1] = numList.get(k).cnt;
			}
			
		}
		
		/*
		 * @생각
		 * 전환하는 과정에서 배열별로 라벨링을 해서 잘 알아보고 하도록 해야겠다.
		 */

		// 가장 큰 열을 기준으로 map 셋팅
		map = new int[maxCol][map[0].length];

		for (int i = 0; i < map[0].length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (j < tempMap[i].length) {
					map[j][i] = tempMap[i][j];
				} else {
					map[j][i] = 0;
				}
			}
		}
		
//		print(map);
	}

	private static void print(int[][] target) {
		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < target[i].length; j++) {
				System.out.print(target[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}