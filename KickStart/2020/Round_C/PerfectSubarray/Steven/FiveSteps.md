# Five Steps

## 1. Understand
  There is an array of N integers. a contiguous non-empty subarray of the array is perfect if its total sum is a perfect square. A perfect square is a number that is the product of a non-negative integer with itself. the task is counting how many subarrrays are perfect in the array. 

* Limits
1. -100 ≤ **N(i)** ≤ 100
2. For up to 5 cases, 1 ≤ **N** ≤ 10^5^.  
3. For the remaining cases, 1 ≤ **N** ≤ 1000.

## 2. Redefine
  Subarray can be redefined as this formula. 
  * a = sum[0, i] (sum of 0 and i in the array)
  * b = sum[0, j] (sum of 0 and j in the array)
 
 in 0 <= j <= i, subarray is a - b. therefore, the task should be counting a - b = x^2^ (x^2^ is a perfect number like 0, 1, 4, 9)
 
## 3. Plan
 Simply, we can get the result by calculating every possibility. for example, there is a an array consisting of 3 integers. then, just check out a - b (a = 1, 2, 3 / b = 1, 2, 3) is x^2^. but it takes so long. the other way is using b = a - x^2^ formula from the original one. basically, we store every b into the map (key is b,  value is the number of duplication). when we got 'a', we check out 'b' satisfied with a - x^2^ in the map. count it.
 
## 4. Verify
 this way to solve the problem is based on the formula. as redefinition makes sense, this approach should work, time complexity is $$O(N * \sqrt {x^2})$$ enough to pass the problem
 
## 5. Review
 this problem is about logical thinking. i was trying to find out any data structures or algorithm. but i could not find it. if anyone got something related to this, please let me know that :D
  
###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003379bb)

