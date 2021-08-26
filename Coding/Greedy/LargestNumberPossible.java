// Given two numbers 'N' and 'S' , find the largest number that can be formed
// with 'N' digits and whose sum of digits should be equals to 'S'.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/largest-number-possible5028/1

// Input: N = 2, S = 9
// Output: 90
// Explaination: It is the biggest number
// with sum of digits equals to 9.

// Input: N = 3, S = 20
// Output: 992
// Explaination: It is the biggest number
// with sum of digits equals to 20.

class Solution {
    static String findLargest(int N, int S) {

        if (S == 0 && N > 1)
            return "-1";

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < N; i++) {

            if (S == 0) {
                res.append("0");
                continue;
            }

            if (S > 9) {
                S -= 9;
                res.append("9");
            } else {
                res.append(S);
                S = 0;
            }
        }

        if (S != 0)
            return "-1";

        return res.toString();
    }
}