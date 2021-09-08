# Five Steps

## 1. Understand
 n개의 nodes와 edges[i] = [ai, bi]인 n-1개의 edges를 가진 tree가 올 때 a[i]와 b[i] 관계가 undirected edge이다. 이 트리에서 root를 0부터 n-1에서 아무거나 설정할 수 있다. x가 root일 때 height h를 가진다. 이 h에서 가장 작은 height을 MHTs라고 부르면 이 MHTs를 가진 labels의 리스트를 반환해라

## 2. Redefine
root는 0부터 n-1이 될 수 있다. 또한 directed edge이기 때문에 edges[ai]이나 edges[bi]부터 출발할 수 있지만 시작점이 정해지면 똑같은 node의 재방문은 금지가 된다. minimum height를 가진 root node, x는 다음과 같이 정의할 수가 있다. x = 시작점 노드 a에서 끝 노드 b 사이의 거리가 최대가 될 때 그 사이의 중간 node. 이와 같이 정의할 수 있는 이유는 그 중간값을 root로 잡았을 때 한 node의 거리만을 길게 하는 것이 아닌 모든 node의 거리가 균등적으로 짧게 할 수 있다. 

## 3. Plan
[contract] findMinHeightTrees : Number, Array -> List\<Integer\>
[purpose] 모든 minimum heights에 대한 리스트를 받아온다.
 
[contact] findTheLastPoint : Number, Number, Point,boolean[], List\<Integer\>[] -> Number
[purpose] 양 끝점을 설정해준다. 가령, 시작점과 도착점을 설정해주는 것이다.
 
[contact] findCentroid : Number, Number, Point, boolean[], List<\Integer\>[], List -> boolean
[purpose] 중앙값을 list에 입력해준다.

dfs으로 두 개의 노드 사이의 거리가 최대가 되는 a와 b를 설정해준다. 이때 노드 사이의 거리 k값도 저장한다. 다음으로 tree를 순회하고 a에서 b까지 도달했을 때 backtracking을 사용해서 중앙값 위치를 구한다.
   
## 4. Verify
tree을 전체 3번만 순회하면 되므로 시간 복잡도는 O(n)으로 충분히 통과할 수 있다.
 
## 5. Review
 이 문제는 저번에 bfs로 접근해서 O(n^2^)으로 풀었던 문제다. 이번에는 저번에 리뷰에서 언급했던대로 minimum height의 정의를 구체적으로 만들었다. 이를 바탕으로 dfs와 backtracking으로 접근하면 된다는 사실을 파악했다. 이 문제는 위상 정렬로도 풀 수 있다고 하는데 어떤 정의가 필요할지 고민해야겠다.

  
###### [Problem Link](https://leetcode.com/problems/minimum-height-trees/submissions/)

