// Alice and Bob have candy bars of different sizes: aliceSizes[i] is the size
// of the i-th bar of candy that Alice has, and bobSizes[j] is the size of the
// j-th bar of candy that Bob has.

// Since they are friends, they would like to exchange one candy bar each so
// that after the exchange, they both have the same total amount of candy. (The
// total amount of candy a person has is the sum of the sizes of candy bars they
// have.)

// Return an integer array ans where ans[0] is the size of the candy bar that
// Alice must exchange, and ans[1] is the size of the candy bar that Bob must
// exchange.

// If there are multiple answers, you may return any one of them. It is
// guaranteed an answer exists.

// Leetcode - https://leetcode.com/problems/fair-candy-swap/

// Input: aliceSizes = [1,1], bobSizes = [2,2]
// Output: [1,2]

// Input: aliceSizes = [1,2], bobSizes = [2,3]
// Output: [1,2]

// Input: aliceSizes = [2], bobSizes = [1,3]
// Output: [2,3]

// Input: aliceSizes = [1,2,5], bobSizes = [2,4]
// Output: [5,4]

// Time Complexity - O(n)
// Space Complexity - O(n)
// Intuition - If Alice swaps candy x, she expects some specific quantity of candy y back.
// sum(alice) - x + y = sum(bob) + x -y

class Solution {
    public int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumAlice = findSum(aliceSizes);
        int sumBob = findSum(bobSizes);

        HashSet<Integer> hash = new HashSet<>();

        for (int num : aliceSizes) {
            hash.add(num);
        }

        int[] res = new int[2];
        int diff = (sumAlice - sumBob) / 2;

        for (int num : bobSizes) {
            if (hash.contains(num + diff)) {
                res[0] = num + diff;
                res[1] = num;
                return res;
            }
        }

        return res;

    }
}