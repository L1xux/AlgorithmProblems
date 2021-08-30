# Five Steps

## 1. Understand
 There are some specific roads in a map, check if there is a valid path in the map.
 here the valid path is the path which starts from (0, 0) to (m - 1, n - 1)

## 2. Redefine
 Find out a way that are connected roads to go from (0, 0) to (m - 1, n - 1).

## 3. Plan
1. we already know each road go the specific directions. so we can keep tracking of a path on the road by using bfs
2. we can also know two roads are connected by supposing that we move a person on the road to another road and the person is on the another road. then, the two roads are connected

## 4. Verify
 Time complexity should be O(N*M). because we visit all nodes just once because we are gonna use bfs
 
## 5. Review
 Indeed, first thought i need to store all connections of the roads, after that i just follow the road. but it's worse apporach because we can easily know the two roads are connected by moving a person on the road to another road.

  
###### [Problem Link](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)
