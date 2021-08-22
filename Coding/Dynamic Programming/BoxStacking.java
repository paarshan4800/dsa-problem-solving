// You are given a set of N types of rectangular 3-D boxes, where the ith box
// has height h, width w and length l. You task is to create a stack of boxes
// which is as tall as possible, but you can only stack a box on top of another
// box if the dimensions of the 2-D base of the lower box are each strictly
// larger than those of the 2-D base of the higher box. Of course, you can
// rotate a box so that any side functions as its base.It is also allowable to
// use multiple instances of the same type of box. You task is to complete the
// function maxHeight which returns the height of the highest possible stack so
// formed.

// Note:
// Base of the lower box should be strictly larger than that of the new box
// we're going to place. This is in terms of both length and width, not just in
// terms of area. So, two boxes with same base cannot be placed one over the
// other.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/box-stacking/1/

// YT - https://www.youtube.com/watch?v=kLucR6-Q0GA

// Input:
// n = 4
// height[] = {4,1,4,10}
// width[] = {6,2,5,12}
// length[] = {7,3,6,32}
// Output: 60

// Time Complexity - O(n^2)
class Solution {

    static class Box {
        int height;
        int width;
        int length;

        Box() {

        }

        Box(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }

        public String toString() {
            return String.format("Area - %d\n", width * length);
        }
    }

    static class SortByArea implements Comparator<Box> {
        public int compare(Box a, Box b) {
            return b.width * b.length - a.width * a.length;
        }
    }

    public static Box[] generateAllBoxes(int[] height, int[] width, int[] length, int n, int numBoxes) {
        Box[] boxes = new Box[numBoxes];
        int index = 0;
        for (int i = 0; i < n; i++) {

            boxes[index] = new Box();
            boxes[index].height = height[i];
            boxes[index].width = Math.max(width[i], length[i]);
            boxes[index].length = Math.min(width[i], length[i]);

            index++;

            boxes[index] = new Box();
            boxes[index].height = width[i];
            boxes[index].width = Math.max(height[i], length[i]);
            boxes[index].length = Math.min(height[i], length[i]);

            index++;

            boxes[index] = new Box();
            boxes[index].height = length[i];
            boxes[index].width = Math.max(height[i], width[i]);
            boxes[index].length = Math.min(height[i], width[i]);

            index++;

        }

        return boxes;
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        // Each box can be rotated and 3 unique forms can be formed
        // So total number boxes is 3 * n
        int numBoxes = 3 * n;

        Box[] boxes = generateAllBoxes(height, width, length, n, numBoxes);

        // Sort the boxes array in decreasing order of area
        Arrays.sort(boxes, new SortByArea());

        int res = 0;
        int[] dp = new int[numBoxes];

        // Run Longest Increasing subsequence
        for (int i = 0; i < numBoxes; i++) {
            dp[i] = boxes[i].height;
            res = Math.max(res, dp[i]);
        }

        for (int i = 1; i < numBoxes; i++) {
            for (int j = 0; j < i; j++) {
                // The lower box's width and length should be strictly decreasing
                if (boxes[j].width > boxes[i].width && boxes[j].length > boxes[i].length) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i].height);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}