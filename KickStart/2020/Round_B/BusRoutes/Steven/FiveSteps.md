# Five Steps

## 1. Understand
Bucket is planning to travel by bus. Her journey consists of **N** bus routes, numbered from 1 to **N** in the order she must take them. here are special rules for the bus.

1. The i-th bus runs every X(i) days. for example, X(i) * 1, X(i) * 2, X(i) * 3 ... X(i) * N.  
2. she can take multiple buses on the same day. if there are X(i) == X(j), then she can take both of them.

Your task is finding the latest day she could take the first bus, and still finish her journey by day **D**

※  it is guaranteed that it is possible for her to finish the journey by day **D**.
## 2. Redefine
This task can be defined like this. multiply X(i) with x times to approximate X(i+1)  (also, i = N-1). the reason why i can redefine it in this way because if i make every numbers to be close to D, then i can get the the latest day. but it should not be close to D all the time since the routes numbered from 1 to N in the **order** so that's why i replace D with X(i+1). 

## 3. Plan
Firstly, let's store the last number N in a list. after that, take the last number from the list as X(i+1) and the last number from X as X(i). then calculate X(i+1) / X(i) * X(i) to get the closest X(i+1). and this value gonna be stored into the list as X(i+1). keep calculating until getting the lowest value.

## 4. Verify
The redefinition makes sense. that's why it's verified. and it gonna be O(N) enough to pass the problem 


## 5. Review
Time complexity should be O(N) enough to pass the problem. but i think i can reduce space like O(1).

###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83bf#problem)

