// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k
// Leetcode - https://leetcode.com/problems/subarray-sum-equals-k/
// GeeksForGeeks - Must do questions topic wise

// O(n^2) - Time Complexity
class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        // Two for loops to generate subarrays
        for(int i=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                // Kind of cumulative sum
                sum+=nums[j];
                // If sum == k, increment count
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

// O(n) - Time Complexity
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        
        // Single Traversal
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            
            // If sum == k, increment count
            if(sum == k) {
                count++;
            }
            
            // If sum-k has already occured, then increment count by occurence of sum-k times
            if(hashMap.containsKey(sum-k) == true) {
                count+=hashMap.get(sum-k);
            }
            
            // If sum has already occured, increment its count
            if(hashMap.containsKey(sum) == true) {
                hashMap.put(sum,hashMap.get(sum)+1);    
            }
            // Else create entry in hashmap and initialize value to 1
            else {
                hashMap.put(sum,1);
            }
            
        }
        
        return count;
    }
}