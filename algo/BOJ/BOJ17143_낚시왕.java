import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17143_낚시왕 {

	private static class Shark {
		int x, y, s, d, z;

		public Shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark (" + x + "," + y + ") [ 속력 : " + s + ", 방향 = " + d + ", 크기 = " + z + "]";
		}
	}

	static int[][] map;
	static boolean[] isVisted;
	static ArrayList<Shark> sharkList = new ArrayList<>();

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int M = Integer.parseInt(input[2]);

		map = new int[R + 1][C + 1];
		isVisted = new boolean[M + 1];

		sharkList.add(null); // 상어 인덱스 순서 일치를 위해, 0에다 null 추가

		// 모든 상어들을 리스트와 맵에 할당
		for (int i = 1; i <= M; i++) {
			input = br.readLine().split(" ");

			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]); // 속력
			int d = Integer.parseInt(input[3]); // 방향
			int z = Integer.parseInt(input[4]); // 크기

			sharkList.add(new Shark(x, y, s, d, z));

			map[x][y] = i; // 해당 위치에 현재 상어의 번호를 기록
		}

		// 시뮬레이션 시작
		// 1. 현재 위치가 열과 동일하게 될 때까지 반복
		// 2. 1번 열부터 마지막까지 내려가며 해당 위치에 상어가 있으면 0으로 잡고, 잡은 크기 +
		// 3. 상어 이동 실행

		int fishingKing = 0;
		int totalSize = 0;

		// 낚시왕이 끝까지 갈 때까지 실행 (1.)
		while (fishingKing++ < C) {

			// 상어잡기 실행 (2.)
			for (int i = 1; i <= R; i++) {
				if (map[i][fishingKing] != 0) {
					int sharkNum = map[i][fishingKing]; // 상어가 있다면, 그때의 인덱스를
					totalSize += sharkList.get(sharkNum).z; // 가져와서 잡은 상어 크기 추가
					map[i][fishingKing] = 0; // 상어 잡음 처리

					break; // 종료
				}
			}

			// 상어 이동 (3.)
			// 1. 모든 좌표에서 인덱스 대로 상어를 이동한다.
			// 2. 이동 후에 해당 인덱스를 카피 맵에 넣을 때, 기존에 값이 있으면 크기 비교를 해서 넣는다.
			// 3. 이동이 끝난 후에 배열을 옮긴다.
			int[][] copy = new int[R + 1][C + 1];
			
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] == 0) continue;
					
					Shark now = sharkList.get(map[i][j]);
					
					int x = now.x;
					int y = now.y;
					int dir = now.d;
					int speed = now.s;
					
					for (int k = 0; k < speed; k++) {
						// 좌측 이동 중 벽 
						if(dir == 4 && y == 1) {
							dir = 3;
						}
						// 우측 이동 중 벽 
						if(dir == 3 && y == C) {
							dir = 4;
						}
						// 상향 이동 중 벽 
						if(dir == 1 && x == 1) {
							dir = 2;
						}
						// 하향 이동 중 벽 
						if(dir == 2 && x == R) {
							dir = 1;
						}
						
						x += dx[dir];
						y += dy[dir];
					}
					
					now.x = x;
					now.y = y;
					now.d = dir;
					
					// 복사 배열에 이동 끝난 상어 번호 넣기
					if(copy[x][y] != 0) {	// 기존에 상어가 있을 경우
						Shark rival = sharkList.get(copy[x][y]);
						
						if(now.z > rival.z) {
							copy[x][y] = map[i][j];
						}
					}else {
						copy[x][y] = map[i][j];
					}
				}
			}
			
			map = copyArr(map, copy);
//			System.out.println("몇 회 차 : " + fishingKing);
//			print(map);
		}
		
		System.out.println(totalSize);

	}
	
	private static int[][] copyArr(int[][] copy, int[][] target) {
		for (int i = 0; i < copy.length; i++) {
			copy[i] = target[i].clone();
		}
		return copy;
	}

	private static void print(int[][] target) {

		for (int i = 0; i < target.length; i++) {
			for (int j = 0; j < target[i].length; j++) {
				System.out.print(target[i][j]);
			}
			System.out.println();
		}
	}

}