// Given a sorted array with possibly duplicate elements. The task is to find
// indexes of first and last occurrences of an element X in the given array.

// Note: If the element is not present in the array return {-1,-1} as pair.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1#

// Input:
// N = 9
// v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
// X = 5
// Output:
// 2 5

// Input:
// N = 9
// v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
// X = 7
// Output:
// 6 6

// Time Complexity - O(logn)
class Solution {

    // Find the left most occurence of x
    public int leftMostIndex(long v[], long x) {
        int low = 0, high = v.length - 1, index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If v[mid] == x, store index=mid
            if (v[mid] == x) {
                index = mid;
            }

            // Keep searching for x's occurence on the left of mid
            if (v[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

    // Find the right most occurence of x
    public int rightMostIndex(long v[], long x) {
        int low = 0, high = v.length - 1, index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If v[mid] == x, store index=mid
            if (v[mid] == x) {
                index = mid;
            }

            // Keep searching for x's occurence on the right of mid
            if (v[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }

    public pair indexes(long v[], long x) {
        // Your code goes here
        return new pair(leftMostIndex(v, x), rightMostIndex(v, x));

    }
}