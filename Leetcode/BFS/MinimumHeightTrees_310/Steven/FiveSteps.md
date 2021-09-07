# Five Steps

## 1. Understand
  n개의 nodes와 edges[i] = [ai, bi]인 n-1개의 edges를 가진 tree가 올 때 a[i]와 b[i] 관계가 undirected edge이다.  이 트리에서 root를 0부터 n-1에서 아무거나 설정할 수 있다.  x가 root일 때 height h를 가진다. 이 h에서 가장 작은 height을 MHTs라고 부르면 이 MHTs를 가진 labels의 리스트를 반환해라 

## 2. Redefine
 0부터 n-1개의 노드와 n-1개의 edges[i] = [ai, bi]가 들어올 때 root는 0부터 n-1이 될 수 있다. 또한 directed edge이기 때문에 edges[ai]이나 edges[bi]부터 출발할 수 있지만 시작점이 정해지면 다른 vertax는 시작점이 될 수가 없다. tree이므로 non-cycled graph이다. 마지막으로 height를 구하는 것은 root부터 시작해서 다른 node로 순회할 때 최소한의 움직임을 의미한다. 
 
## 3. Plan
BFS로 풀 수 있다. 0부터 n-1을 각각 root로 지정한 후에 그 root에서 bfs로 다음 node로 계속 순회한다. 다시 말해, 현재 node가 now일 때 now와 연결되어 있는 모든 next node에 이동한다. 이동할 때마다 Height는 1씩 증가한다. 마지막 node에 도착했을 때 Height를 array에 시작했던 root 값과 같은 index에 저장한다. 또한 minimum height를 계속 업데이트한다. 모든 n-1을 다 bfs로 처리한 후에 그 array에서 minimum height와 같은 값을 가진 index를 list에 넣는다.

## 4. Verify
N개의 노드에 BFS를 적용하기 때문에 시간복잡도는 O(N^2^)이다. Constraints에서 1 <= n <= 2 * 10^4^이므로 Time Limit Exceeded가 난다. O(N) 혹은 O(n log n)으로 최적화가 필요하다.
 
## 5. Review
트리에서 어떤 노드를 root를 해야 Minimum height를 가지는지 더 생각해봐야 하겠다. 정확히 말하면 한 vertax를 기준을 잡았을 때 subtree는 최대 노드의 개수를 가지는 방법을 생각해야 최적화가 된다고 생각한다.

  
###### [Problem Link](https://leetcode.com/problems/minimum-height-trees/)

