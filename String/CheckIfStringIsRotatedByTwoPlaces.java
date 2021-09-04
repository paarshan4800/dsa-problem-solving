// Given two strings a and b. The task is to find if the string 'b' can be
// obtained by rotating another string 'a' by exactly 2 places.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1#

// Input:
// a = amazon
// b = azonam
// Output: 1

// Input:
// a = geeksforgeeks
// b = geeksgeeksfor
// Output: 0

class Solution {
    // Function to check if a string can be obtained by rotating
    // another string by exactly 2 places.

    public static char[] reverse(char[] arr, int low, int high) {
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

    public static boolean isRotated(String str1, String str2) {
        // Length should be same
        if (str1.length() != str2.length())
            return false;

        // If length == 1, check if equal (to avoid null pointer exception)
        if (str1.length() == 1) {
            if (str1.charAt(0) == str2.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }

        // Rotate array counter-clockwise by 2 and check if equal
        char[] arr1 = str1.toCharArray();

        arr1 = reverse(arr1, 0, 1);
        arr1 = reverse(arr1, 2, str1.length() - 1);
        arr1 = reverse(arr1, 0, str1.length() - 1);

        if (String.valueOf(arr1).equals(str2)) {
            return true;
        }

        // Rotate array clockwise by 2 and check if equal
        arr1 = str1.toCharArray();

        arr1 = reverse(arr1, 0, str1.length() - 3);
        arr1 = reverse(arr1, str1.length() - 2, str1.length() - 1);
        arr1 = reverse(arr1, 0, str1.length() - 1);

        if (String.valueOf(arr1).equals(str2)) {
            return true;
        }

        return false;
    }

}