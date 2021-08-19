// Given a string S. The task is to print all permutations of a given string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#

// YT - https://www.youtube.com/watch?v=GuTPwotSdYw

// Input: ABC
// Output:
// ABC ACB BAC BCA CAB CBA

// Input: ABSG
// Output:
// ABGS ABSG AGBS AGSB ASBG ASGB BAGS
// BASG BGAS BGSA BSAG BSGA GABS GASB
// GBAS GBSA GSAB GSBA SABG SAGB SBAG
// SBGA SGAB SGBA

// Time Complexity - O(n*n!) i.e O(time taken to print one permutation * no. of permutation)
// no. of permutation = n!
// time taken to print one permutation = n (depth of recursion tree. the leaf node of recursion tree will be one permutation)
class Solution {

    public char[] swap(char str[], int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return str;
    }

    public void permute(List<String> res, char[] str, int l, int r) {
        // If l == r, add to res as no more permutation is possible and this is the leaf
        // of recursion tree
        if (l == r) {
            res.add(String.valueOf(str));
        }

        for (int i = l; i <= r; i++) {
            str = swap(str, i, l); // Swap i and l
            permute(res, str, l + 1, r); // With l fixed, permute l+1 and r
            str = swap(str, i, l); // Swap back i and l to original position (BACKTRACK)
        }
    }

    public List<String> find_permutation(String S) {
        List<String> res = new LinkedList<>();

        // Convert to char array as string is immutable
        char[] str = S.toCharArray();

        permute(res, str, 0, S.length() - 1);

        Collections.sort(res); // Result should be in lexographically sorted order

        return res;
    }
}