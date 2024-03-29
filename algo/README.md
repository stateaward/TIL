# Solved

| date | type |  num  |         problem         | level |    type    |             desc.              |
| :--: | :--: | :---: | :---------------------: | :---: | :--------: | :----------------------------: |
| 4/2  | 백준 | 17142 |        연구소 3         |  🥇   | 시뮬레이션 |        [✏️](#연구소-3)         |
| 4/13 | 백준 | 14888 |     연산자 끼워넣기     |  🥈   | 시뮬레이션 |                                |
| 4/19 | 백준 | 15685 |       드래곤 커브       |  🥇   | 시뮬레이션 |       [✏️](#드래곤-커브)       |
| 4/20 | 백준 | 20058 | 마법사상어와 파이어스톰 |  🥇   | 시뮬레이션 | [✏️](#마법사상어와-파이어스톰) |
| 4/21 | 백준 | 20057 |  마법사상어와 토네이도  |  🥇   | 시뮬레이션 |  [✏️](#마법사상어와-토네이도)  |
| 4/21 | 백준 | 17143 |   이차원 배열과 연산    |  🥇   | 시뮬레이션 |   [✏️](#이차원-배열과-연산)    |
| 4/21 | 백준 | 17140 |         낚시왕          |  🥇   | 시뮬레이션 |         [✏️](#낚시왕)          |
| 4/23 | 백준 | 20061 |     모노미노도미노2     |  🥇   | 시뮬레이션 |                                |

<br>

📌 [문제집](./List.md)

---

# Description

<br>

### 연구소 3

-  2는 10보다 작거나 같은 수 ... 왠만하면 완탐이다
   -  10C5 → 250
   -  50^2 = 2500
-  시간과 관련 되었다? -> BFS
-  결국 구하고자 하는 것은 남은 바이러스의 수, 카운팅을 하자

<br>

### 드래곤 커브

-  다양한 자료 구조를 활용하는게 중요하다. 특히, 역순으로 배열을 삽입해야 하는데 LIST를 이용하면 간편하다.
-  문제대로 표현하는 것만 생각하느라 어려웠는데, 어떻게 그림이 그려지는지 그 패턴을 파악하는게 우선이다.
-  구현 문제여도 다양한 표현법이 있으니 더 넓은 알고리즘 사고가 필요하다.

<br>

### 마법사상어와 파이어스톰

> 분명 시험장에서 풀었어서 로직도 희미하게 다 기억나는데, 다시 풀려니 자잘한 실수가 잦았다.

-  얼음이 녹는 경우엔, 체크하면서 같이 녹이면 더블체킹이 발생한다.  
   (녹은 얼음을 또 체크해서 또 녹이는 경우)
   -  이걸 해결하려고 Queue로 녹는 좌표들을 기록해서 따로 녹이게 했다.
   -  `다른 방법)` 원배열을 copy한 뒤, 해당 배열에서 값을 체크 -> 실제 배열의 얼음을 줄이기!
      -  clone() 사용하기
         ```
             int[][] map_copy = new int[N][N];
             for (int i = 0; i < map.length; i++) {
                 map_copy[i] = map[i].clone();
             }
             for (int i = 0; i < map.length; i++) {
                 for (int j = 0; j < map.length; j++) {
                     if (map_copy[i][j] > 0 && ice(i, j, map_copy) < 3) {
                         map[i][j]--;
                     }
                 }
             }
         ```
      -  System.arraycopy() 사용하기
         ```
             private static int[][] arraycopy(int[][] origin) {
                 int[][] ret = new int[size][size];
                 for (int i = 0; i < size; i++) {
                     System.arraycopy(origin[i], 0, ret[i], 0, size);
                 }
                 return ret;
             }
         ```
-  행렬에 자주 접근하는 문제는, i,j,x,y,nx,ny 등의 좌표 접근 변수에 더욱 신경쓰자.
-  BFS는 대기열 Q에 삽입할 때, 함께 방문 체크를 해줘야 한다! <- 습관처럼!
-  시뮬레이션은 차근히 풀면 된다. 침착하지만 시간 내에 풀려면 빠르게 움직여야 한다.

<br>

### 마법사상어와 토네이도

-  중요한 것은, 달팽이를 그리는 것 보다 `어떤 방향으로 달뱅이가 그려지는 지` 이다.
   -  달팽이 그리는 것에만 몰두해서, 그려지는 순서만 고려했는데,  
      이 문제에선 방향이 어떻게 늘어나는지를 파악해야 한다.
   -  어떤 방향으로 몇 회 움직이는 지를 파악해야 한다.
-  점수 계산 부분을 완전 노동으로 처리했는데, 다른 방법을 익혀보자.
   -  1. 계산 관련된 배열(5\*5)을 생성해서 할당하고, 이를 회전시켜서 다 만드는 방법
      -  배열 내부 값들은 모두 곱해야 하는 비율이다.
   -  2. (노동) 3차원 배열 형태로 좌표를 셋팅하기...

<br>

### 이차원 배열과 연산

-  열연산을 할 때, 계산을 내려가는 기준이 열인데. 배열 자체의 생성은 행 기준으로 이루어진다.  
   `arr[3] = new int[old.length]` - 생성은 행 기준으로 하고, 할당만 잘 하면 되겠지 했는데 인덱싱이 생각보다 복잡했다.

<br>

### 낚시왕

-  `상어가 벽에 부딪히면 어떻게 반대로 가지?` 때문에 막혀서 애먹었다..
   -  계속 이걸 어떻게 공식화 할 수 있을지 고민하다 포기했다..  
      `열크기 + 열크기 - 2` 를 한 만큼을 움직이면 자신의 방향을 유지한채 원래 위치로 올 수 있음을 파악했는데, 이걸 전체 적용하는게 도무지 생각이 안난다.
   -  이럴 땐, 그냥 시뮬레이션처럼 하자. `상어의 속력만큼 for문으로 실제로 움직이자`
      -  벽에 부딪히면, 방향을 바꾸고, dx/dy를 바꾸는 식으로
-  상어를 먹을 땐, 기존 배열을 건드리면 이벤트가 순차적으로 발생하므로  
   `이동은 이동대로!`, `먹는건 마지막에!` 하도록 해야한다. - 따라서 상어들이 위치하는 새 배열을 만들고, 여기서 비교가 이루어지게 했다. - 그리고 이동이 끝난 뒤, 해당 배열을 원 map에 깊은 복사! 끝!
-  빠르게 풀 로직이 떠오르지 않으면, 일단 문제에서 요구하는대로 빠르게 구현하는게 중요하다.
