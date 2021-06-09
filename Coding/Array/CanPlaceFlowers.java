// You have a long flowerbed in which some of the plots are planted, and some
// are not. However, flowers cannot be planted in adjacent plots.

// Given an integer array flowerbed containing 0's and 1's, where 0 means empty
// and 1 means not empty, and an integer n, return if n new flowers can be
// planted in the flowerbed without violating the no-adjacent-flowers rule.

// Leetcode - https://leetcode.com/problems/can-place-flowers/

// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true

// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (
                // If first element, check second element is zero or not
                (i == 0 && flowerbed[i + 1] == 0)

                        // If last element, check last-1 element is zero or not
                        || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0)

                        // If element is not a first one or a last one, check its prev and next element
                        || ((i > 0 && i < flowerbed.length) && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }

            }

        }

        return (n <= 0) ? true : false;

    }
}