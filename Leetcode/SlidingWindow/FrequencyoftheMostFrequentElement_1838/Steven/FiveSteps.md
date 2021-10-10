# Five Steps

## 1. Understand
 integer array인 nums와 정수 k가 들어온다. 이때 한 operation마다 nums에서 하나의 element를 선택해 1씩 증가시킬 수 있다. 최대 k번 operations 한 이후 maximum possible frequency of the element를 반환해라.
 - (The frequency of an element is the number of times it occurs in an array.)

## 2. Redefine
이 문제를 다음과 같이 다시 정의할 수가 있다. nums가 오름차순으로 정렬이 되었을 때 i번마다 (최대 k번만큼) 어떤 element를 1 증가시켰을 때 어떤 위치 l, r가 있을 때 

 nums[l] == nums[r]이고 l < m < r nums[m] == nums[r]인 최대 길이를 반환해라.  

## 3. Plan
 이 문제의 포인트는 2가지가 될 수 있다.
 1. 최대 k번마다 어떤 element를 1씩 증가시켜서  
   최대한 nums[l] == nums[r]이고 nums[m] == nums[r]이 되도록 한다. 
 2. 앞서 언급한 것을 충족시키는 최대 길이를 구하라  따라서 이것은 sliding windows로 풀 수가 있다. 그렇다면 i는 다음과 같이 정의 내릴 수 있다. 

 * i == nums[r] * (r - l + 1) - (sum of l..r)
 * nums[r] * (r - 1 + 1) - (sum of l..r) <= k
  
   최대 길이는 r - l + 1이다. l과 r값은 i의 값에 따라서 변화해주면 된다.
다음은 "의사 코드"이다.
 
```
 l = 0, r = 0, 
 lSum = 0, rSum = 0;
 int res = 0;
 
  for(r = 0 ; r < nums.length ; r++){
	  rSum+=nums[r];
	  
	  while(l < r && nums[r] * (r - l + 1) - (rSum - lSum)) > k){
		  lSum+=nums[l];		
		  l++;
	  }
	  res = max(res, r - l + 1);
 }
 
return res; 
```
## 4. Verify

이 접근법은 O(n)을 가지므로 충분히 통과할 수 있다.
## 5. Review
이 문제를 풀 때 가장 중요한 부분은 redefine을 할 때 이 문제를 새롭게 정의를 한 것이다. 이를 통해서 Sliding Window 개념을 적용시킬 수 있었다. 

###### [Problem Link](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)
