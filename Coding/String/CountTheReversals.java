// Given a string S consisting of only opening and closing curly brackets '{'
// and '}', find out the minimum number of reversals required to convert the
// string into a balanced expression.
// A reversal means changing '{' to '}' or vice-versa.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1#

// Input:
// S = "}{{}}{{{"
// Output: 3
// Explanation: One way to balance is:
// "{{{}}{}}". There is no balanced sequence
// that can be formed in lesser reversals.

// Input:
// S = "{{}{{{}{{}}{{"
// Output: -1
// Explanation: There's no way we can balance
// this sequence of braces.

class Sol {
    int countRev(String s) {
        int open = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // If open bracket, increment open
            if (s.charAt(i) == '{') {
                open++;
            }
            // If close bracket
            else {
                // If there is no open brackets to be balanced, then the close bracket is not
                // possible. So increment result and open bracket
                if (open == 0) {
                    res++;
                    open++;
                }
                // Else decrement open (Balanced)
                else {
                    open--;
                }
            }
        }

        // If there are odd number of open brackets, then balancing not possible
        if (open % 2 != 0)
            return -1;

        return res + open / 2;
    }
}