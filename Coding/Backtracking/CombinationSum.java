// Given an array of integers and a sum B, find all unique combinations in the
// array where the sum is equal to B. The same number may be chosen from the
// array any number of times to make B.

// Note:
// 1. All numbers will be positive integers.
// 2. Elements in a combination (a1, a2, …, ak) must be in non-descending order.
// (ie, a1 ≤ a2 ≤ … ≤ ak).
// 3. The combinations themselves must be sorted in ascending order.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1#

// Input:
// N = 4
// arr[] = {7,2,6,5}
// B = 16
// Output:
// (2 2 2 2 2 2 2 2)
// (2 2 2 2 2 6)
// (2 2 2 5 5)
// (2 2 5 7)
// (2 2 6 6)
// (2 7 7)
// (5 5 6)

class Solution {
    // Function to return a list of indexes denoting the required
    // combinations whose sum is equal to given number.

    static void combinationSum(ArrayList<Integer> A, int sum, int index, ArrayList<Integer> cur,
            ArrayList<ArrayList<Integer>> res) {

        // If sum reaches 0, then add the current set to result
        if (sum == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < A.size(); i++) {
            // If including current element gives result < 0, break from loop
            if (sum - A.get(i) < 0)
                break;

            // Include the current element
            cur.add(A.get(i));
            // Recur
            combinationSum(A, sum - A.get(i), i, cur, res);
            // BACKTRACK
            cur.remove(cur.size() - 1);
        }

    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        // Sort the given array and remove duplicates
        Collections.sort(A);
        HashSet<Integer> hash = new HashSet<>(A);
        A = new ArrayList<>(hash);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        combinationSum(A, B, 0, new ArrayList<Integer>(), res);

        return res;
    }
}