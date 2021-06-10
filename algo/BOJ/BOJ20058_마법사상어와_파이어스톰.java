import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ20058_마법사상어와_파이어스톰 {

	static int[][] map;
	static boolean[][] isVisit;
	static int count;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);

		int N2 = (int) Math.pow(2, N); // 실질적인 행렬의 사이즈

		map = new int[N2][N2];
		isVisit = new boolean[N2][N2];

		// data input
		for (int i = 0; i < N2; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N2; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 파이어 스톰을 실행할 녀석을 input[] 배열에 할당해줌
		input = br.readLine().split(" ");

		// 파이어 스톰을 Q번 실행!
		// 1. 레벨값 대로 회전
		// 2. 얼음 녹는지 확인
		for (int fire = 0; fire < Q; fire++) {
			int level = Integer.parseInt(input[fire]);
			int lev2 = (int) Math.pow(2, level); // 실질적인 레벨의 사이즈

			// 각 덩어리의 첫 타자를 돌면서 회전을 시킴
			for (int i = 0; i < N2; i += lev2) {
				for (int j = 0; j < N2; j += lev2) {
					rotate(i,j,lev2);
				}
			}
			
			// 녹은 얼음을 보관했다가 일괄적으로 빼기 위한 LIST 생성
			Queue<Integer> meltList = new LinkedList<>();
			
			// 얼음 녹는지 확인
			for (int i = 0; i < N2; i++) {
				for (int j = 0; j < N2; j++) {
					if(map[i][j] == 0) continue;
					
					int iceCnt = 0;
					
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(!(0<= nx && nx < N2 && 0 <= ny && ny < N2)) continue;
						if(map[nx][ny] != 0) iceCnt++;
					}
					
					if(iceCnt < 3) {
						meltList.add(i);
						meltList.add(j);
					}
				}
			}
			
			// 녹는 얼음 대상을 한번에 녹음 처리하기
			while(!meltList.isEmpty()) {
				int x = meltList.poll();
				int y = meltList.poll();
				
				map[x][y]--;
			}
			
		}
		
		int total = 0;
		
		// 전체 중 남은 얼음의 합
		for (int i = 0; i < N2; i++) {
			for (int j = 0; j < N2; j++) {
				if(map[i][j] == 0) continue;
				total += map[i][j];
			}
		}
		
		int maxCnt = 0;
		
		// BFS로 덩어리 체크
		for (int i = 0; i < N2; i++) {
			for (int j = 0; j < N2; j++) {
				if(map[i][j] == 0 || isVisit[i][j]) continue;
				BFS(i,j);
				maxCnt = Math.max(count, maxCnt);
			}
		}
		
		System.out.println(total);
		System.out.println(maxCnt);
		
	}
	
	private static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		q.add(j);
		isVisit[i][j] = true;
		
		count = 1;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
					
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(!(0<= nx && nx < map.length && 0 <= ny && ny < map.length)) continue;
				
				if(map[nx][ny] != 0 && !isVisit[nx][ny]) {
					q.add(nx);
					q.add(ny);
					isVisit[nx][ny] = true;
					count++;
				}
			}
		}
		
	}

	// 현재 시작 x,y를 기준으로 lv 범위만큼 회전함
	// 1. 현재 가르키는 범위만큼 카피 배열 생성
	// 2. 카피 배열에 회전 후의 값 넣기
	// 3. 카피 배열을 원배열로 대체하기
	private static void rotate(int x, int y, int lv) {	// 범위 2
		int[][] copy = new int[lv][lv];
		
		// 카피 배열에 회전 후 값 셋팅
		for (int i = x, xrd = 1; i < x + lv; i++, xrd++) {
			for (int j = y, yrd = 0; j < y + lv; j++, yrd++) {
				copy[yrd][lv-xrd] = map[i][j];
			}
		}
		
		// 카피 배열 원 배열로 대체
		for (int i = 0; i < lv; i++) {
			for (int j = 0; j < lv; j++) {
				map[x+i][y+j] = copy[i][j];
			}
		}
	}

}