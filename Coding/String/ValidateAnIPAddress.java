// Write a program to Validate an IPv4 Address. According to Wikipedia, IPv4
// addresses are canonically represented in dot-decimal notation, which consists
// of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g.,
// 172.16.254.1 . The generalized form of an IPv4 address is
// (0-255).(0-255).(0-255).(0-255). Here we are considering numbers only from 0
// to 255 and any additional leading zeroes will be considered invalid.

// Your task is to complete the function isValid which returns 1 if the ip
// address is valid else returns 0. The function takes a string s as its only
// argument .

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1/

// Input:
// ip = 222.111.111.111
// Output: 1

// Input:
// ip = 5555..555
// Output: 0
// Explanation: 5555..555 is not a valid
// ip address, as the middle two portions
// are missing.

class Solution {

    public boolean checkValidity(String segment) {
        // should have atleast the number 0
        if (segment.length() == 0)
            return false;

        // If length more than 1 and the first char is '0' --> leading zeroes
        if (segment.length() > 1 && segment.charAt(0) == '0')
            return false;

        // converting to number throws exception (incase of characters in the segment)
        try {
            int segmentVal = Integer.parseInt(segment);
            // range is 0 - 255
            if (segmentVal < 0 || segmentVal > 255)
                return false;
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public boolean isValid(String s) {

        int i = 0, j = 0, segments = 0;

        while (j < s.length()) {
            if (s.charAt(j) != '.') {
                j++;
            } else {
                String segment = s.substring(i, j);

                if (!checkValidity(segment))
                    return false;
                j++;
                i = j;
                segments++;
            }
        }

        String segment = s.substring(i, j);

        if (!checkValidity(segment))
            return false;

        segments++;

        // IP addr should have 4 segments
        if (segments != 4)
            return false;

        return true;
    }
}