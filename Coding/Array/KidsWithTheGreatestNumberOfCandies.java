// Given the array candies and the integer extraCandies, where candies[i]
// represents the number of candies that the ith kid has.

// For each kid check if there is a way to distribute extraCandies among the
// kids such that he or she can have the greatest number of candies among them.
// Notice that multiple kids can have the greatest number of candies.

// Leetcode -
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

// Input: candies = [2,3,5,1,3], extraCandies = 3
// Output: [true,true,true,false,true]

// Input: candies = [4,2,1,1,2], extraCandies = 1
// Output: [true,false,false,false,false]

// Input: candies = [12,1,12], extraCandies = 10
// Output: [true,false,true]

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = -1;
        List<Boolean> res = new ArrayList<>();

        // Find max in given array
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            // If current candies + extraCandies is greater than or equal to max, then true
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;

    }
}
