import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20057_마법사상어와_토네이도 {

	static int N, out;
	static int[][] map;
	
	/*
	 * 3차원 배열 형태로 정리 가능
	 *  int[][][] dir = {
	 *  	{
	 *  		{}
	 *  	}
	 *  };
	 */

	// 각 방향별 좌표를 미리 저장
	static int[] dx = { -1, -1, 0, 0, 0, 0, 1, 1, 1, 2 };
	static int[] dy = { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 };
	static int[] ux = { 1, 1, 0, 0, 0, 0, -1, -1, -1, -2 };
	static int[] uy = { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 };
	static int[] lx = { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 };
	static int[] ly = { 1, 1, 0, 0, 0, 0, -1, -1, -1, -2 };
	static int[] rx = { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 };
	static int[] ry = { -1, -1, 0, 0, 0, 0, 1, 1, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		out = 0;

		// data input
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

//		print(map);
		int x = N / 2;
		int y = N / 2;
//		int temp = 1;

		// 달팽이 흐름도 만들기
		// x,y를 가운데 부터 시작해서, 실제 좌표를 계속 변화시키며 달팽이 모양으로 탐색
		for (int round = 1; round <= N / 2 + 1; round++) {

			// left
			for (int step = 0; step < 2 * round - 1; step++) {
				storm(x,--y,'l');
//				map[x][--y] = temp++;

				// round 횟수를 +1 함으로써 마지막 한 줄까지 실행함
				// 이때 종료 조건을 걸어서 밑에는 접근 못하도록
				if (x == 0 && y == 0) {
//					print(map);
					System.out.println(out);
					return;
				}
			}

			// down
			for (int step = 0; step < 2 * round - 1; step++) {
				storm(++x, y, 'd');
//				map[++x][y] = temp++;
			}

			// right
			for (int step = 0; step < 2 * round; step++) {
				storm(x,++y,'r');
//				map[x][++y] = temp++;
			}

			// up
			for (int step = 0; step < 2 * round; step++) {
				storm(--x,y,'u');
//				map[--x][y] = temp++;
			}

		}
	}

	private static void storm(int i, int j, char dir) {
		int sand = map[i][j];

		/*
		 * 미리 계산하는 경우와
		 * 배열 위치에 해당 값을 넣어두고, 즉석에서 곱해서 처리하는 방식이 존재
		 */
		int s1 = (int) (sand * 0.01);
		int s2 = (int) (sand * 0.02);
		int s5 = (int) (sand * 0.05);
		int s7 = (int) (sand * 0.07);
		int s10 = (int) (sand * 0.1);
		int left = sand - (s1 + s2 + s7 + s10) * 2 - s5;

		int[] target = { s1, s1, s2, s2, s7, s7, s10, s10, left, s5 };
//		System.out.println(Arrays.toString(target));

		switch (dir) {
		case 'd':
			for (int k = 0; k < 10; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					map[nx][ny] += target[k];
				} else {
					out += target[k];
				}
			}
			break;

		case 'u':
			for (int k = 0; k < 10; k++) {
				int nx = i + ux[k];
				int ny = j + uy[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					map[nx][ny] += target[k];
				} else {
					out += target[k];
				}
			}
			break;

		case 'l':
			for (int k = 0; k < 10; k++) {
				int nx = i + lx[k];
				int ny = j + ly[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					map[nx][ny] += target[k];
				} else {
					out += target[k];
				}
			}
			break;

		case 'r':
			for (int k = 0; k < 10; k++) {
				int nx = i + rx[k];
				int ny = j + ry[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					map[nx][ny] += target[k];
				} else {
					out += target[k];
				}
			}
			break;

		}

		map[i][j] = 0;
	}

	private static void print(int[][] input) {
		for (int[] s : input) {
			System.out.println(Arrays.toString(s));
		}

	}

}