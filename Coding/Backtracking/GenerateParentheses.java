// Given an integer N representing the number of pairs of parentheses, the task
// is to generate all combinations of well-formed(balanced) parentheses.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1#

// Input:
// N = 3
// Output:
// ((()))
// (()())
// (())()
// ()(())
// ()()()

class Solution {

    public void AllParanthesis(int open, int close, StringBuilder cur, List<String> res) {
        // If all open and close brackets are placed, add current set to result.
        if (open == 0 && close == 0) {
            res.add(cur.toString());
            return;
        }

        // If num(open) == num(close), only open bracket is allowed
        if (open == close) {
            cur.append("(");
            AllParanthesis(open - 1, close, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        // If num(open) < num(close), both brackets are allowed
        else if (open < close) {
            // If num(open) != 0, open bracket is allowed
            if (open != 0) {
                cur.append("(");
                AllParanthesis(open - 1, close, cur, res);
                cur.deleteCharAt(cur.length() - 1);
            }

            cur.append(")");
            AllParanthesis(open, close - 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    public List<String> AllParenthesis(int n) {
        List<String> res = new ArrayList<>();

        AllParanthesis(n, n, new StringBuilder(""), res);

        return res;
    }
}