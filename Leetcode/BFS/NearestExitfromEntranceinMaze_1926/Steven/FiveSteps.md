# Five Steps

## 1. Understand
there is a 2d char array represented as a maze. the size of the maze is M x N. each cell is one of two types which are '.' represented as empty and '+' represented as wall. we have an entrance, initial position, is [entrance(row), entrance(col)]. In each steps, we can move up, down, left, right just once. also, we can't go out of the maze or go to a cell represented as '+'. the task is finding the nearest exit. (the exit is defined as an empty cell that is at the border of the maze)  if there is no exit, return -1

## 2. Redefine
  a. maze[row][col] = [empty cell represented as '.' or wall represented as '+']
  
  b. you can go anywhere only if you go one of up, down, left, right 
  => maze[row-1][col], maze[row+1][col], maze[row][col-1], maze[row][col+1]
  
  c. maze[row][col] can't be maze[m][col], maze[-1][col], maze[row][n] and maze[row][-1]
  also, maze[row][col] can't be '+' 
  
  d. exit = one of maze[0][col], maze[m-1][col], maze[row][0] and maze[row][n-1]
  
  e. if there is no exit, return -1

## 3. Plan

 I can get all candidates by using bfs. then pick up the candidate that takes
 the least steps. if we don't have no candidates, return -1.
 
 [contact] bfs char[][] maze, int[] entrance -> int
 [purpose] get the nearest exit

## 4. Verify
It takes O(m*n) enough to pass the problem. because, i used BFS for this.

## 5. Review
 It actually doesn't need for logical thinking. simply, find out all candidates and get the result from there. I think there is no way to find an exit unless you visit each cells in the maze.

  
###### [Problem Link](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/)

