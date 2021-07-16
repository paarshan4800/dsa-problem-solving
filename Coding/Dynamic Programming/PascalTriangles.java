// Given an integer numRows, return the first numRows of Pascal's triangle.

// Leetcode - https://leetcode.com/problems/pascals-triangle/

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Build a DP bottom up approach array and compute result
class Solution {
    public List<List<Integer>> generate(int numRows) {

        int[][] arr = new int[numRows][numRows];

        // First and last element is always 1
        for (int i = 0; i < numRows; i++) {
            arr[i][i] = 1;
            arr[0][i] = 1;
        }

        // Compute values of middle elements
        for (int k = 2; k < numRows; k++) {
            for (int i = 1; i < k; i++) {
                arr[i][k] = arr[i - 1][k - 1] + arr[i][k - 1];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int j = 0; j < numRows; j++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= j; i++) {
                temp.add(arr[i][j]);
            }
            res.add(temp);
        }

        return res;
    }
}

// Efficient Approach. Without DP array
class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        // Base case. With numRows = 1
        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> prevRow = res.get(i - 1);

            // First element is always 1
            curRow.add(1);

            // Fill the remaining elements as the sum of adjacent elements in prev row
            for (int j = 1; j < i; j++) {
                curRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }

            // Last element is always 1
            curRow.add(1);
            res.add(curRow);
        }

        return res;
    }
}