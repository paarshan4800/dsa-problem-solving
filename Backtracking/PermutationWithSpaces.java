// Given a string you need to print all possible strings that can be made by
// placing spaces (zero or one) in between them. The output should be printed in
// sorted increasing order of strings

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1#

// Input:
// S = "ABC"
// Output: (A B C)(A BC)(AB C)(ABC)
// Explanation:
// ABC
// AB C
// A BC
// A B C
// These are the possible combination of "ABC".

// Input:
// S = "AB"
// Output: (A B)(AB)

// Time Complexity - O(2^n)
class Solution {

    public void permutation(String S, String cur, int index, ArrayList<String> res) {

        // Boundary Condition
        // If a string using all letters in S is built, add it to res
        if (index == S.length() - 1) {
            res.add(cur);
            return;
        }

        // If penultimate character is traversed, dont branch by adding next character
        // and space since it wont yield a valid solution (it will have space as last
        // character)
        if (index != S.length() - 2)
            // Branch by adding character and space
            permutation(S, cur + S.charAt(index + 1) + " ", index + 1, res);

        // Branch by adding character only
        permutation(S, cur + S.charAt(index + 1), index + 1, res);
    }

    ArrayList<String> permutation(String S) {
        ArrayList<String> res = new ArrayList<>();

        permutation(S, "", -1, res);

        return res;
    }

}