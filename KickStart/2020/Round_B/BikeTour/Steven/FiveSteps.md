# Five Steps

## 1. Understand
Li gonna climb mountains. these mountains consist of check points numbered from 1 to N. the i-th checkpoint has a height of **H[i]**. A checkpoint is a  _peak_ if   
 1. It is not the 1st checkpoint or the  **N**-th checkpoint 
 2. the height of the checkpoint is  _strictly greater than_  the checkpoint immediately before it and the checkpoint immediately after it.

Task: find out the number of peaks.

the constraints of this problem are

* Time limit: 10 seconds per test set.  
* Memory limit: 1GB.

1 ≤ **T** ≤ 100 (T is a test case) 
1 ≤ **H[i]** ≤ 100
3 ≤  **N**  ≤ 5 (for test set 1)  
3 ≤  **N**  ≤ 100 (for test set 2)

## 2. Redefine
 P (_peak_) can be defined as when 1 <= i < N -1, and H[i-1] < H[i] > H[i+1] 

## 3. Plan
Simply, count P from 1 to N when H[i] is satisfied with the condition

## 4. Verify
this time complexity should be O(N) enough to pass the problem

## 5. Review
if i want to count all peaks in the H, then i should visit all elements at least once !
therefore, time complexity should not exceed than O(N)

###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d82e6)

