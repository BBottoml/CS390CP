import java.util.HashMap;

/*
Problem description:
Given an array A of integers, return the number of 
(contiguous, non-empty) subarrays 
that have a sum divisible by K.


Approach: 
Employ prefix sums and use of HashMap 
to determine if we have visited a certain 
"sum" before. In the event we have, 
increment result by corresponing value 
to temp (key). This approach is O(n) time 
complexity and O(n) space. Brute force approach
for this problem has a time complexity of O(n^3)

Result:
Runtime: 26 ms, faster than 43.75% of Java online submissions for Subarray Sums Divisible by K.
Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Subarray Sums Divisible by K.

@author Bradley Bottomlee
*/

public class Solution {
    
    public int subarraysDivByK(int[] A, int K) {
        int result = 0; 
        int runningSum = 0;
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1); 
        
        for (int i = 0; i < A.length; i++) {
            runningSum += A[i];
            
            int temp = ((runningSum % K) + K) % K; 
            
            if (mp.containsKey(temp)) {
                int currentVal = mp.get(temp);
                result += currentVal;
                mp.put(temp, currentVal + 1); 
            } else {
                mp.put(temp, 1); 
            }
            
        }
        
        return result; 
    }
}