# Five Steps

## 1. Understand
1부터 n까지 값이 있는 vertices를 가진 undirected tree가 들어올 때 개구리는 vertex 1부터 시작해서 아직 방문하지 않은 인접한 vertex로 이동한다. 또한 개구리는 같은 vertex를 두 번 이상 갈 수가 없다. 만약에 여러 개의 vertices로 갈 수가 있으면 같은 랜덤적으로 하나에 간다. (단, 그 vertices로 가는 확률은 동일하다.)  만약에 개구리가 더 이상 방문하지 않은 vertex로 움직일 수가 없으면 같은 자리에 계속 머물게 된다.
edges는 다음과 같이 주어진다. edges[i] = [ai, bi]는 ai와 bi가 연결되어 있다.
* t초 이후에 개구리가 target vertex에 있을 확률을 반환해라. 

## 2. Redefine
다음과 같이 개구리가 ai에서 bi으로 움직였다고 가정하면  ai로 돌아갈 수가 없으므로 선택이 끝난 것이다.  따라서 다음 vertex를 고를 때 선택이 완료된다.
* undirected tree이므로 vertex의 edges의 수 = parent의 개수 + children의 개수

만약 현재 이동한 시간 x < t이고 현재 vertex, v = target일 때 3가지 고려할 것이 있다.

 * a. 현재 target의 child가 empty일 때
 * => v에 위치에 x = t일때까지 기다리면 되므로 target까지 가는 확률을 반환한다.
 * b. 현재 target의 child가 non-empty일 때
 * => t초 이후에 target에 갈 수가 없으므로 확률은 0이다.

확률 = 1 / (현재 vertex의 edges의 수 - 1)  * vertex 1부터 현재 vertex까지 오는 확률 

## 3. Plan
bfs을 사용해서 현재 vertex v에서 인접한 모든 unvisited vertices의 확률 각각 구한다. 만약 bfs을 돌고 있을 때 target을 만났을 때 redefine에서 말했던 x < t일 때의 경우를 고려하고 또는 x = t일 때는 target의 확률을 반환한다. bfs을 돌았을 때 target을 못찾았을 경우 0을 반환한다. 

## 4. Verify
 bfs를 사용하므로 O(n)이고 충분히 문제를 통과할 수 있다.

## 5. Review
문제를 처음 접근했을 때는 undirected tree라는 말을 놓쳤다. 이는 다음과 같은 문제를 발생했다. edges[ai, bi]이가 ai -> bi로 연결되어 있는 줄 알고 bi -> ai 경우를 무시해서 오류를 발생했다.

###### [Problem Link](https://leetcode.com/problems/frog-position-after-t-seconds/)

