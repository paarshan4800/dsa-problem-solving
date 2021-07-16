// Given two integer arrays A1[ ] and A2[ ] of size N and M respectively. Sort
// the first array A1[ ] such that all the relative positions of the elements in
// the first array are the same as the elements in the second array A2[ ].
// See example for better understanding.
// Note: If elements are repeated in the second array, consider their first
// occurance only.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/relative-sorting4323/1#

// Input:
// N = 11
// M = 4
// A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
// A2[] = {2, 1, 8, 3}
// Output:
// 2 2 1 1 8 8 3 5 6 7 9
// Explanation: Array elements of A1[] are
// sorted according to A2[]. So 2 comes first
// then 1 comes, then comes 8, then finally 3
// comes, now we append remaining elements in
// sorted order.

// Input:
// N = 11
// M = 4
// A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
// A2[] = {99, 22, 444, 56}
// Output:
// 1 1 2 2 3 5 6 7 8 8 9
// Explanation: No A1[] elements are in A2[]
// so we cannot sort A1[] according to A2[].
// Hence we sort the elements in non-decreasing
// order.

// Time Complexity - O(nlogn)
// Space Complexity - O(n)
class Solution {
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]

    // Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int[] res = new int[N];
        List<Integer> remains = new LinkedList<>();

        // Store the values of A2 as key in count with value initialized to 0. Skip
        // duplicates
        for (int num : A2) {
            if (count.containsKey(num))
                continue;

            count.put(num, 0);
        }

        // Traverse A1
        for (int num : A1) {
            // If num is in count hash, increment frequency
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            }
            // Else add to remains list
            else {
                remains.add(num);
            }
        }

        // Sort the remains list as we will append this to the result array
        Collections.sort(remains);

        int index = 0;

        // Traverse A2
        for (int num : A2) {
            // If num is not in the hash, skip
            if (!count.containsKey(num))
                continue;

            // Get the frequency of num
            int times = count.get(num);
            // Add frequency times num to the res array
            for (int i = 0; i < times; i++) {
                res[index++] = num;
            }
            // Remove num from the count hash to avoid duplicates
            count.remove(num);
        }

        // Add remains to res array
        for (int num : remains) {
            res[index++] = num;
        }

        return res;

    }
}
