// Given an integer x, find the square root of x. If x is not a perfect square,
// then return floor(√x).

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/square-root/1/?track=amazon-searching&batchId=192#

// Input:
// x = 5
// Output: 2

// For Input:
// 13
// Output of Online Judge
// 3

// Time Complexity - O(logn)
class Solution {
    long floorSqrt(long x) {
        // For optimization start high with x/2 as values greater than x/2 are not
        // possible
        long low = 1, high = x / 2, res = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long temp = mid * mid;

            // If temp == x, break
            if (temp == x) {
                res = mid;
                break;
            }

            // If temp < x, this can be a solution. So store it in res. Values less than mid
            // cant be the solution. So set low = mid+1
            if (temp < x) {
                res = mid;
                low = mid + 1;
            }
            // If temp > x, values more than mid cant be a solution. So set high to mid-1
            else {
                high = mid - 1;
            }
        }

        return res;
    }
}