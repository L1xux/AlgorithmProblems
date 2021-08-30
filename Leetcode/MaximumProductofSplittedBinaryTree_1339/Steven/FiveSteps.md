# Five Steps

## 1. Understand
 After removing one edge in a binary tree, there are splitted two subtrees. find out maximum product of the sums of the two subtrees

## 2. Redefine
 Find out the maximum value from (the sum of all nodes -  subtree) * subtree.

## 3. Plan
1. We can get the sum of all nodes by traversal.
2. We can get a candidate by calculating (the sum of all nodes - subtree) * subtree.

## 4. Verify
 Time complexity should be O(N). because we visit all nodes just twice. when we need the sum of all nodes and when we need the all candidates.  

## 5. Review
 Actually, i think i don't need to store the sum of subtree in the node. first just store the sum of all nodes in a variable. it's much stable.

  
###### [Problem Link](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)

