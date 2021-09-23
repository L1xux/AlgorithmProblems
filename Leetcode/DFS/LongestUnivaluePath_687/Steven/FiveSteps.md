# Five Steps

## 1. Understand
 하나의 이진트리가 들어올 때 각 node들은 같은 값을 가지고 있는 가장 긴 path의 길이를 반환해라. 이 path는 root를 포함시켜 path를 만들 수 있다.

## 2. Redefine
path를 다음과 같이 정의 할 수 있다. path의 길이 = left path의 길이 + right path의 길이 여기서 path의 각 node들은 같은 값을 가지고 있어야 하므로 다음과 같은 조건이 있다 
* root node의 val == left node의 val == right node의 val

## 3. Plan
A. tree를 traversal을 한다. 이때 post order 방식을 따른다.
B. 한 node x를 포함하고 있는 path를 구하려고 하면 다음과 같은 방식을 따른다.
 * left에서 가장 긴 path의 거리를 구한다.
 * right에서 가장 긴 path의 거리를 구한다.
 * 만약 left의 val와 root val가 같으면 left path의 가장 긴 길이를 사용한다.
 * 만약 right의 val와 root val가 같으면 right의 가장 긴 길이를 사용한다.
 * 따라서 node x의 길이는 = left 길이 + right 길이
 * 반환을 할 때는 max(left, right) + 1을 한다. (왜냐하면 path는 left와 right 중 하나만 갈 수 있기 때문이다.)

## 4. Verify
이 접근법은 O(node의 개수)이므로 문제를 충분히 통과할 수 있다.
 
## 5. Review
문제를 다시 redefine하는 부분에서 path의 길이를 정의해서 문제를 정확히 명시하는 것이 중요했다고 느껴졌다.

###### [Problem Link](https://leetcode.com/problems/longest-univalue-path/)

