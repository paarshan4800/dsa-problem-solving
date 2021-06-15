// Given a list of non negative integers, arrange them in such a manner that
// they form the largest number possible.The result is going to be very large,
// hence return the result in the form of a string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1#

// Input:
// N = 5
// Arr[] = {3, 30, 34, 5, 9}
// Output: 9534330

// Input:
// N = 4
// Arr[] = {54, 546, 548, 60}
// Output: 6054854654

//Sorting using comparator
class Solution {

    class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            String xy = x + y;
            String yx = y + x;

            return xy.compareTo(yx);

        }
    }

    String printLargest(String[] arr) {
        // code here

        Arrays.sort(arr, new CustomComparator());

        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(arr[i]);
        }

        return res.toString();

    }
}