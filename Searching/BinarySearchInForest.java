// There are n trees in a forest. The heights of the trees is stored in array
// tree[], where tree[i] denotes the height of the ith tree in the forest. If
// the ith tree is cut at a height H, then the wood collected is tree[i] - H,
// provided tree[i] > H. If the total woods that needs to be collected is
// exactly equal to k, find the height H at which every tree should be cut (all
// trees have to be cut at the same height). If it is not possible then return
// -1 else return H.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/ffd66b6a0bf7cefb9987fa455974b6ea5695709e/1/#

// Input:
// n = 5, k = 4
// nums[] = {2, 3, 6, 2, 4}
// Output: 3
// Explanation: Wood collected by cutting trees
// at height 3 = 0 + 0 + (6-3) + 0 + (4-3) = 4
// hence 3 is to be subtracted from all numbers.
// Since 2 is lesser than 3, nothing gets
// subtracted from it.

// Input:
// n = 6, k = 8
// nums[] = {1, 7, 6, 3, 4, 7}
// Output: 4
// Explanation: Wood collected by cutting trees
// at height 4 = 0+(7-4)+(6-4)+0+0+(7-4) = 8

class Solution {

    // Helper method to find the max in an array
    static int findMax(int tree[]) {
        int max = -1;
        for (int num : tree) {
            max = Math.max(max, num);
        }
        return max;
    }

    // calculates how much wood will be collected for given H
    static int getWoodsCollected(int tree[], int H) {
        int woods = 0;

        for (int num : tree) {
            if (num > H) {
                woods += (num - H);
            }
        }

        return woods;
    }

    static int find_height(int tree[], int n, int k) {
        // We need to find H. Can calculate woods collected beginning with 0 and
        // incrementing by 1 everytime. This is brute force approach

        // Instead of this, fix the lowest and highest value.
        // Perform binary search and obtain optimal value each time

        int low = 0, high = findMax(tree);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate how much wood is collected given all trees are cut by mid
            int woods = getWoodsCollected(tree, mid);

            // If equal to k, then mid is the result
            if (woods == k) {
                return mid;
            }
            // If woods collected is greater than k, then we need to increase mid
            else if (woods > k) {
                low = mid + 1;
            }
            // If woods collected is lesser than k, then we need to decrease mid
            else {
                high = mid - 1;
            }

        }

        return -1;
    }
}