// Given three arrays sorted in increasing order. Find the elements that are
// common in all three arrays.
// Note: can you take care of the duplicates without using any additional Data
// Structure?

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/common-elements1132/1/

// Input:
// n1 = 6; A = {1, 5, 10, 20, 40, 80}
// n2 = 5; B = {6, 7, 20, 80, 100}
// n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
// Output: 20 80
// Explanation: 20 and 80 are the only
// common elements in A, B and C.

class Solution {
    void swapArr(int arr1[], int arr2[]) {
        int temp[] = arr1;
        arr1 = arr2;
        arr2 = temp;
    }

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {

        ArrayList<Integer> res = new ArrayList<>();

        // Make sure that len(A) < len(B) < len(C)
        if (B.length > C.length) {
            int temp[] = B;
            B = C;
            C = temp;
        }

        if (A.length > B.length) {
            int temp[] = A;
            A = B;
            B = temp;
        }

        int j = 0, k = 0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i];

            // Move forward in B till >= element
            while (j < B.length && B[j] < x)
                j++;

            // Move forward in C till >= element
            while (k < C.length && C[k] < x)
                k++;

            // If equal element, add to res
            if ((j < B.length && B[j] == x) && (k < C.length && C[k] == x)) {
                res.add(x);
                j++;
                k++;
            }

            // Handle duplicates
            while (j < B.length && j > 0 && B[j] == B[j - 1])
                j++;

            while (k < C.length && k > 0 && C[k] == C[k - 1])
                k++;

        }

        return res;
    }
}