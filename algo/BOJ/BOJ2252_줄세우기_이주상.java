package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 순서를 정하는 위상정렬 알고리즘을 사용한다.
*/

public class BOJ2252_줄세우기_이주상 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 몇 명인지 = 정점 수
		int M = sc.nextInt();	// 비교 횟수 = 간선 수
		
		// 진입차수(자신에게 들어오는 화살표)를 기록
		int[] indegree = new int[N+1]; // 0 인덱스 무시
		
		// 연결 리스트 생성
		ArrayList<Integer>[] nodeList = new ArrayList[N+1];
		
		// 자기가 연결된 녀석들을 가르키는 노드 리스트를 초기화함
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		// =====================================
		// data input
		for (int i = 0; i < M; i++) {
			// from -> to
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			nodeList[from].add(to);
			indegree[to]++;			// 자신에게 들어오는 차수를 기록
		}
		
		// =====================================
		// q를 활용하여 위상정렬을 실시
		Queue<Integer> q = new LinkedList<>();
		// 결과값을 기록하는 변수
		Queue<Integer> result = new LinkedList<>();
		
		// 차수가 0인 녀석들을 먼저 선택
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		// 위상정렬
		while(!q.isEmpty()) {
			int zero = q.poll();
			result.add(zero);  // 0인 녀석들을 결과에 일단 넣기
			
			for (int i = 0; i < nodeList[zero].size(); i++) {
				// 진입차수가 0인 노드가 가르키는 녀석들을 순차적으로 탐색
				// 가르키는 녀석들의 진입차수를 지우기
				int current = nodeList[zero].get(i);
				indegree[current]--;
				
				if(indegree[current] == 0) {
					q.add(current);
				}
			}
		}
		
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		
	}

}


/*
 * 휴지통
 
 [풀이 생각]
 1. 크다/작다고 입력받은 모든 수들을 카운팅하기
 1-1. 큰 경우 + / 작은 경우 -
 2. 최종적으로 카운팅 된 수 크기대로 출력
 
 >>> 몇번 나왔는지 카운팅을 하고, 카운팅 된 수를 기준으로 정렬하여 출력하는 형태..

	int[][] height = new int[N][2];
	
	for (int i = 0; i < N; i++) {
		height[i][0] = i;
	}
	
	
	for (int i = 0; i < M; i++) {
		int t = sc.nextInt();
		int s = sc.nextInt();
		
		height[t-1][1]++;
		height[s-1][1]--;
	}
	
	
	// 키 순서가 담긴 height[][1] 배열을 정렬하기
	Arrays.sort(height, new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[1] - o1[1];
		}
	});
	
	
	for (int i = 0; i < N; i++) {
		System.out.print(height[i][0]+1 + " ");
	}

 */