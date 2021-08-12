// Given an array of n distinct elements. Find the minimum number of swaps
// required to sort the array in strictly increasing order.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/minimum-swaps/1#

// Input:
// nums = {10, 19, 6, 3, 5}
// Output:
// 2
// Explaination:
// swap 10 with 3 and swap 19 with 5.

class Solution {
    class SortList implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }

    class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int minSwaps(int nums[]) {
        List<Pair> list = new ArrayList<>();

        // Store value with its index as a pair
        for (int i = 0; i < nums.length; i++)
            list.add(new Pair(nums[i], i));

        // Sort in ascending order wrt values
        Collections.sort(list, new SortList());

        int i = 0, res = 0;

        // Traverse the sorted list
        while (i < list.size()) {
            Pair pair = list.get(i);

            // If the index of current pair == i, then it is in the right position. So
            // continue
            if (pair.index == i) {
                i++;
                continue;
            }

            // If above if condition fails, then the current pair is in the wrong position
            // Swap i and index of current pair
            Collections.swap(list, i, pair.index);

            // Increment res
            res++;

        }

        return res;
    }
}