// Given an array arr[] and a number K where K is smaller than size of array,
// the task is to find the Kth smallest element in the given array. It is given
// that all array elements are distinct.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#

// Input:
// N = 6
// arr[] = 7 10 4 3 20 15
// K = 3
// Output : 7

// Input:
// N = 5
// arr[] = 7 10 4 20 15
// K = 4
// Output : 15

// Sorting
// Sort the array in ascending order and return the kth element
// Time Complexity - O(nlogn)
// Space Complexity - O(n)

// Using Min Heap
// Add every element into the min heap. Now pop k-1 elements and now the top of
// the min heap is the result
// Time Complexity - O(nlogk)
// Space Complexity - O(n)

// Using Max Heap
// If size of max heap is less than k, add to max heap.
// Else if top of max heap is greater than current element, pop out from max
// heap and then add the current element. After processing all elements, the top
// of the max heap is the result
// By doing so, at every iteration, the top of the max heap would be the kth
// smallest element among the elements processed
//// Time Complexity - O(nlogk)
// Space Complexity - O(k)

class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            if (maxHeap.size() != k) {
                maxHeap.add(num);
                continue;
            }

            if (maxHeap.peek() > num) {
                maxHeap.poll();
                maxHeap.add(num);
            }

        }

        return maxHeap.peek();
    }
}