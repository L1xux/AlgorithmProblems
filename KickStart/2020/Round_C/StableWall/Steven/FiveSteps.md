# Five Steps

## 1. Understand
polyomino is consisted of one or more squares that connects each edges of the squares to form the shape. each polyomino has a unique alphabet. if a piece of polyomino is at the bottom of a map or its piece is under another piece, it's "supported". we can put a polyomino to the map one at a time. the size of the puzzle is R on row, C on column.
it can hold N polyominos.
the task is printing out the order where a person added the polyominos to satisfy all polyominos with "supported" condition.

* 1 <= T <= 100 (Test Case)
* 1 <= R <= 30
* 1 <= C <= 30
* 1 <= N <= 26

## 2. Redefine
1. if there is no visited piece under some pieces of a polyomino, these piece has to be attached firstly.
2. if there is a polyomino whose pieces are at the bottom of the puzzle or there is no any different pieces under the pieces, it should be the first polyomino.

With this conditions, we should know whether it's a kind of directed graph or not. 

## 3. Plan
 let's draw a graph by using dfs. more precisely, if can know which polyomino needs to be following, it means that we can get the graph. after that, we gonna order it by using topological order. during this process, if we visit a degree 0, this graph is not directed graph. if not, we print out alphabets in the order.
 

## 4. Verify
 As the redefinition, this problem narrow the problem to checking out directed graph.
this plan makes sense. 

## 5. Review
i pass the first case, i can't satisfy the second test set 2. please let me know which point i missed.

###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003379bb)

