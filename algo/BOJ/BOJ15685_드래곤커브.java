package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15685_드래곤커브 {

	static int[][] map = new int[110][110];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int x = Integer.parseInt(line[1]);	// 행렬 -> 그래프 변환
			int y = Integer.parseInt(line[0]);  // 행렬 -> 그래프 변환
			int d = Integer.parseInt(line[2]);
			int g = Integer.parseInt(line[3]);

			int[] start = { d };

			int[] pattern = makepattern(start, 0, g);
			
			map[x][y] = 1;
			for (int k = 0; k < pattern.length; k++) {
				switch(pattern[k]) {
					case 0:
						map[x][++y] = 1;
						break;
					case 1:
						map[--x][y] = 1;
						break;
					case 2:
						map[x][--y] = 1;
						break;
					case 3:
						map[++x][y] = 1;
						break;
				}
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);

	}

	// 시작 입력 배열 / 목적지 세대 / 현재 세대
	private static int[] makepattern(int[] start, int now, int dest) {
		int[] output = new int[start.length * 2];

		if (dest == now) {
			return start;
		}

		for (int i = 0; i < start.length; i++) {
			output[i] = start[i];
		}

		// i : 역순으로 들어가는 해당 숫자(계속 감소) / j : output에 담기는 숫자(계속 증가)
		for (int i = start.length - 1, j = start.length; i >= 0; i--, j++) {
			output[j] = ++start[i] % 4; // 0,1,2,3 을 돌면서 입력
		}

		return makepattern(output, now + 1, dest);
	}

}
