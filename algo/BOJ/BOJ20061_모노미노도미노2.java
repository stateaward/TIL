import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20061_모노미노도미노2 {

	static int[][] GREEN = new int[6][4];
	static int[][] BLUE = new int[4][6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int score = 0;
		int delCnt = 0;
		boolean isFill;

		for (int round = 0; round < N; round++) {
			String[] input = br.readLine().split(" ");

			int t = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);

			// 입력 받을 때마다 도미노 실행
			// 1. 블럭 놓기 (동시 발생)
			switch (t) {
			// t=1 / (x,y) BLUE(x) / GREEN(y)
			case 1:
				putBlockBlue(x);
				putBlockGreen(y);
				break;

			// t=2 / (x,y)(x,y+1) BLUE(x) / GREEN(y, y+1)
			case 2:
				isFill = false;

				// GREEN (y, y+1)
				for (int step = 0; step < 6; step++) {
					if (GREEN[step][y] == 0 && GREEN[step][y + 1] == 0)
						continue;

					GREEN[step - 1][y] = 1;
					GREEN[step - 1][y + 1] = 1;
					isFill = true;
					break;
				}
				if (!isFill) {
					GREEN[5][y] = 1;
					GREEN[5][y + 1] = 1;
				}
				putBlockBlue(x);
				putBlockBlue(x);
				break;

			// t=3 / (x,y)(x+1,y) BLUE(x, x+1) / GREEN(y)
			case 3:
				isFill = false;

				// BLUE (x, x+1)
				for (int step = 0; step < 6; step++) {
					if (BLUE[x][step] == 0 && BLUE[x + 1][step] == 0)
						continue;

					BLUE[x][step - 1] = 1;
					BLUE[x + 1][step - 1] = 1;
					isFill = true;
					break;
				}
				if (!isFill) {
					BLUE[x][5] = 1;
					BLUE[x + 1][5] = 1;
				}

				putBlockGreen(y);
				putBlockGreen(y);
				break;
			}



			// 2. 그린, 블루 각 영역에서 점수 체크
			// GREEN
			for (int step = 2; step < 6; step++) {
				if (GREEN[step][0] + GREEN[step][1] + GREEN[step][2] + GREEN[step][3] == 4) {
					removeGreenLine(1,step);
					score++;
				}
			}
			
			// BLUE
			for (int step = 2; step < 6; step++) {
				if (BLUE[0][step] + BLUE[1][step] + BLUE[2][step] + BLUE[3][step] == 4) {
					removeBlueLine(1,step);
					score++;
				}
			}

			// 3. 그린, 블루 각 영역에서, deleteZone 체크
			// GREEN
			delCnt = 0;
			for (int line = 0; line < 2; line++) {
				if(GREEN[line][0] + GREEN[line][1] + GREEN[line][2] + GREEN[line][3] != 0) {
					delCnt++;
				}
			}
			if(delCnt!=0) removeGreenLine(delCnt, 5);
			
			// BLUE
			delCnt = 0;
			for (int line = 0; line < 2; line++) {
				if(BLUE[0][line] + BLUE[1][line] + BLUE[2][line] + BLUE[3][line] != 0) {
					delCnt++;
				}
			}
			if(delCnt!=0) removeBlueLine(delCnt, 5);
			
//			System.out.println("# BLUE");
//			print(BLUE);
//			System.out.println("# GREEN");
//			print(GREEN);
//			System.out.println();
//			System.out.println();
			
		} // end-for
		
		
		System.out.println(score);
		
		int cntBlock = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				cntBlock += BLUE[i][j];
				cntBlock += GREEN[j][i];
			}
		}
		
		System.out.println(cntBlock);
		
		
	}

	private static void removeBlueLine(int round, int target) {
		int t = 0;
		int first = 0;
		while(t < round) {
			for (int line = target; line > 0; line--) {
				BLUE[0][line] = BLUE[0][line-1];
				BLUE[1][line] = BLUE[1][line-1];
				BLUE[2][line] = BLUE[2][line-1];
				BLUE[3][line] = BLUE[3][line-1];
			}
			
			BLUE[0][first] = 0;
			BLUE[1][first] = 0;
			BLUE[2][first] = 0;
			BLUE[3][first++] = 0;
			
			t++;
		}
	}

	private static void removeGreenLine(int round, int target) {
		int t = 0;
		int first = 0;
		while(t < round) {
			for (int line = target; line > 0; line--) {
				GREEN[line][0] = GREEN[line-1][0];
				GREEN[line][1] = GREEN[line-1][1];
				GREEN[line][2] = GREEN[line-1][2];
				GREEN[line][3] = GREEN[line-1][3];
			}
			
			GREEN[first][0] = 0;
			GREEN[first][1] = 0;
			GREEN[first][2] = 0;
			GREEN[first++][3] = 0;
			
			t++;
		}
	}

	private static void putBlockBlue(int x) {
		// BLUE (x)
		for (int step = 0; step < 6; step++) {
			if (BLUE[x][step] == 0)
				continue;
			BLUE[x][step - 1] = 1;
			return;
		}
		BLUE[x][5] = 1;
	}

	private static void putBlockGreen(int y) {
		// GREEN (y)
		for (int step = 0; step < 6; step++) {
			if (GREEN[step][y] == 0)
				continue;
			GREEN[step - 1][y] = 1;
			return;
		}
		GREEN[5][y] = 1;
	}
	
	private static void print(int[][] map) {
		for (int[] is : map) {
			System.out.println(Arrays.toString(is));
		}
	}
}
