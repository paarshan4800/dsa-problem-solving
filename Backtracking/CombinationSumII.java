// Given an array of integers A[] of size N and a sum B, find all unique
// combinations in A where the sum is equal to B. Each number in A may only be
// used once in the combination.

// Note:
// All numbers will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order.
// (ie, a1 ≤ a2 ≤ … ≤ ak).
// The combinations themselves must be sorted in ascending order.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1#

// Input:
// N = 7
// A = {9, 1, 2, 7, 6, 1, 5}
// B = 8
// Output: (1 1 6)(1 2 5)(1 7)(2 6)
// Explaination: These are the only possible
// combinations for getting sum 8.

// Time Complexity - O(2^n)
class Solution {
    static void findCombinations(int[] A, int sum, int index, int N, ArrayList<Integer> cur, List<List<Integer>> res) {

        // If sum reaches 0, add current set to result
        if (sum == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = index; i < N; i++) {
            // If including the current results sum < 0, skip that
            if (sum - A[i] < 0)
                continue;

            // Check for duplicates
            // If current element and previous element are same, skip
            if (i > index && A[i] == A[i - 1])
                continue;

            // Add current element
            cur.add(A[i]);
            // Recur
            findCombinations(A, sum - A[i], i + 1, N, cur, res);
            // BACKTRACK - Remove from current set
            cur.remove(cur.size() - 1);
        }

    }

    static List<List<Integer>> combinationSum(int A[], int N, int B) {
        Arrays.sort(A);

        List<List<Integer>> res = new ArrayList<>();
        findCombinations(A, B, 0, N, new ArrayList<Integer>(), res);
        return res;
    }
}