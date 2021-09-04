// Given an array of integers nums and a positive integer k, find whether it's
// possible to divide this array into sets of k consecutive numbers
// Return True if it is possible. Otherwise, return False.

// Leetcode -
// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

// Input: nums = [1,2,3,3,4,4,5,6], k = 4
// Output: true
// Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

// Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
// Output: true
// Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and
// [9,10,11].

// Input: nums = [3,3,2,2,1,1], k = 3
// Output: true

// Input: nums = [1,2,3,4], k = 3
// Output: false
// Explanation: Each array should be divided in subarrays of size 3.

// Using MinHeap (Time Limit Exceeded)
// Time Complexity - O(n^2)
// Space Complexity - O(n)

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        // The length of given array should be divisible by k
        if (nums.length % k != 0) {
            return false;
        }

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int prev = -1; // Intially there will be no prev element

        // Add everything to the min heap
        for (int num : nums) {
            minHeap.add(num);
        }

        LinkedList<Integer> temp = new LinkedList<>();
        int count = 0;

        // Till min heap is empty (all elements are processed)
        while (!minHeap.isEmpty()) {
            int cur = minHeap.poll(); // Pop

            // If no prev element, it is valid. Increment count and updated prev
            if (prev == -1) {
                prev = cur;
                count++;
                continue;
            }

            // If cur <= prev, we need to store it in a temp storage as this might help in
            // next set
            if (cur <= prev) {
                temp.add(cur);
            }
            // If cur is a consecutive number of prev, update prev, push back all elements
            // in temp to minHeap and update count. If count == k, reset prev and count
            else if (prev + 1 == cur) {
                prev = cur;
                while (temp.size() != 0) {
                    minHeap.add(temp.remove());
                }
                count++;
                if (count == k) {
                    prev = -1;
                    count = 0;
                }
            }
            // If invalid consecutive number, return false;
            else {
                return false;
            }

        }

        // After processing all elements in the minHeap, the temp storage should be
        // empty.
        if (temp.isEmpty()) {
            return true;
        }

        return false;

    }
}

// Efficient Approach - Hashing
// Time Complexity - O(nlogn + nk)
// Space Complexity - O(n)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        // Tree map stores it in the ascending order (of key)
        // Store val and its frequency in the tree map
        TreeMap<Integer, Integer> hash = new TreeMap<>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                hash.put(num, hash.get(num) + 1);
            } else {
                hash.put(num, 1);
            }
        }

        // Iterate the hashmap
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int freq = entry.getValue();
            int cur = entry.getKey();

            // If freq == 0, nothing to process, skip
            // Else
            if (freq != 0) {
                // Check next k consecutive elements
                for (int i = 0; i < k; i++) {
                    // If there is no next consecutive element or frequency of next consecutive
                    // element is < freq, return false
                    if (hash.get(cur + i) == null || hash.get(cur + i) < freq) {
                        return false;
                    }
                    // Else update freq
                    else {
                        hash.put(cur + i, hash.get(cur + i) - freq);
                    }
                }
            }

        }

        return true;

    }
}