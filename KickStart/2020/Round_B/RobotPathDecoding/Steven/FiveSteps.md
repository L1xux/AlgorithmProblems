# Five Steps

## 1. Understand
The rover can be maneuvered around on the surface of the planet of which size is 10^9^ X 10^9^(numbered starting from 1) by sending it a program. this program executes each character of the string representing movements in the four cardinal directions in order.
-   `N`: Move one unit north.
-   `S`: Move one unit south.
-   `E`: Move one unit east.
-   `W`: Move one unit west.

X(Y) instruction, where X is a number between 2 and 9 inclusive and Y is a non-empty subprogram. This denotes that the robot should repeat the subprogram Y a total of X times.
Since the planet is a torus, the first and last columns are adjacent. similarly, rows are the same way.

Task is determining the final position of the robot after it has finished all its movements.

* Constraints 
* 1 ≤ **T** ≤ 100. (T is test cases). 
* The length of each program is between 1 and 2000 characters inclusive.


## 2. Redefine
Let's say current position is P(x,y). then, directions can be defined like this. N = P(x, y-a), S = P(x, y+a), E = P(x+a, h), W = P(x-a, y). if P(x, y) is out of the range, it need to be changed because the planet is a torus. there are two cases.
 
1. if y-a <= 0, then y = 10^9^ + y - a. similarly, if x-a <= 0, then x = 10^9^ + x - a
2. if y+a > 10^9^, then y = (y + a) % 10^9^. also, if x+a > 10^9^, then x = (x + a) % 10^9^
 
 also, we can know how many steps it moves on row by adding N, S. similarly, by adding E, W, we can know how many steps it moves on column. 

## 3. Plan
 I have to know all instructions. that's why i need to transform X(Y) to normal execution. (decoding). i store each movements like moving N, S, E, W into an array. after that, i can get x = E - W + 1, y = S - N + 1. if P(x, y) exceeds 10^9^ or it's lower than 0, it's replaced with the form i mentioned above.

## 4. Verify
 As redefinition makes sense, this plan gonna work. also, it takes O(N) time complexity enough to pass the problem.


## 5. Review
 If there is some ways to solve the problem with O(log N), it gonna improve than before.
 for now, i don't find any solutions. 


###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83dc)

