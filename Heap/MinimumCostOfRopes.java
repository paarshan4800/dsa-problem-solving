// There are given N ropes of different lengths, we need to connect these ropes
// into one rope. The cost to connect two ropes is equal to sum of their
// lengths. The task is to connect the ropes with minimum cost.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1/

// Input:
// n = 4
// arr[] = {4, 3, 2, 6}
// Output:
// 29
// Explanation:
// For example if we are given 4
// ropes of lengths 4, 3, 2 and 6. We can
// connect the ropes in following ways.
// 1) First connect ropes of lengths 2 and 3.
// Now we have three ropes of lengths 4, 6
// and 5.
// 2) Now connect ropes of lengths 4 and 5.
// Now we have two ropes of lengths 6 and 9.
// 3) Finally connect the two ropes and all
// ropes have connected.
// Total cost for connecting all ropes is 5
// + 9 + 15 = 29. This is the optimized cost
// for connecting ropes. Other ways of
// connecting ropes would always have same
// or more cost. For example, if we connect
// 4 and 6 first (we get three strings of 3,
// 2 and 10), then connect 10 and 3 (we get
// two strings of 13 and 2). Finally we
// connect 13 and 2. Total cost in this way
// is 10 + 13 + 15 = 38.

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long res = 0;

        for (long num : arr)
            minHeap.add(num);

        while (minHeap.size() > 1) {
            long rope1 = minHeap.poll();
            long rope2 = minHeap.poll();

            long attach = rope1 + rope2;

            res += attach;

            minHeap.add(attach);
        }

        return res;
    }
}