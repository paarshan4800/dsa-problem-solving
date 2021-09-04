// You are a product manager and currently leading a team to develop a new
// product. Unfortunately, the latest version of your product fails the quality
// check. Since each version is developed based on the previous version, all the
// versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first
// bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version
// is bad. Implement a function to find the first bad version. You should
// minimize the number of calls to the API.
// Leetcode - https://leetcode.com/problems/first-bad-version/

// Input: n = 5, bad = 4
// Output: 4

// Input: n = 5, bad = 4
// Output: 4

// Linear Scan (Inefficient approach)
// Traverse left to right and find first bad version
// Time Complexity - O(n)

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Binary Search
// Time Complexity - O(logn)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1, high = n;

        while (low < high) {

            int mid = low + (high - low) / 2; // To prevent overflow

            // If bad version, everything to its right side will be bad also.
            // The first bad version might be the mid or might be found to the left side of
            // mid. So update high = mid
            if (isBadVersion(mid)) {
                high = mid;
            }
            // If not bad version, everything to its left side will not be bad also.
            // The first bad version will be found to the left side of
            // mid. So update low = mid + 1
            else {
                low = mid + 1;
            }

        }

        // Low holds the first bad version
        return low;

    }

}