# Five Steps

## 1. Understand
 There is an array consisting of N positive integers. it's a integer A(i) at i-th. m-countdown is a subarray of the array whose length is m and its order is m, m-1, m-2, ..., 2, 1. The task is counting k-countdown in the array 

* 2 <= N <= 2 X 10^5^.
* 2 <= K <= N
* 1 <= A(i) <= 2 X 10^5^

## 2. Redefine
 Here is an array A and a subarray of the array S. k-countdown is S(1) = k, S(2) = k-1, S(3) = k-2, ..., S(k) = 1

## 3. Plan
 Check out whether it has a k-countdown or not by visiting every numbers in the array ,A. if there is the subarray satisfied the conditions, we can count it. if not, we check out again from the point where we got a subarray that aren't satisfied the conditions

## 4. Verify
Given A(1), A(2), ..., A(k-1), A(k), if A(i) (1 < i <= k) is A(i) >= A(i), it assure that we don't need to start checking out whether it's satisfied with the conditions or not from A(a) (1 <= a < i). A(a) ~ A(a+k-1)  needs to pass through A(i) since a+k-1 >= i. therefore, we don't need to visit it again anymore. when k-countdown is failed, we can start it from when it's failed. 


## 5. Review
it takes O(N) time complexity. i don't know how to enhance it in terms of speed.

###### [Problem Link](https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003380d2)
