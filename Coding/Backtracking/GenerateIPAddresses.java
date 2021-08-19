// Given a string S containing only digits, Your task is to complete the
// function genIp() which returns a vector containing all possible combination
// of valid IPv4 ip address and takes only a string S as its only argument.
// Note : Order doesn't matter.

// For string 11211 the ip address possible are
// 1.1.2.11
// 1.1.21.1
// 1.12.1.1
// 11.2.1.1

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1/

class Solution {

    public boolean isValidSegment(int current, String str, int len, int index) {
        // Value shouldn't exceed 255 and if length of current segment is >= 2, check
        // for leading zero
        if (current > 255 || len >= 2 && str.charAt(index) == '0')
            return false;

        return true;
    }

    public void genIp(String str, int index, int segment, int[] segments, ArrayList<String> res) {
        // index == str.length() --> whole string traversed
        // segment == 4 --> all 4 segments have been computed
        // So add to res
        if (index == str.length() && segment == 4) {
            String temp = String.format("%d.%d.%d.%d", segments[0], segments[1], segments[2], segments[3]);
            res.add(temp);
            return;
        }

        if (index == str.length() || segment == 4)
            return;

        // Each segment can have maximum of three char
        for (int len = 1; len <= 3 && index + len <= str.length(); len++) {
            String curSegment = str.substring(index, index + len);
            int current = Integer.parseInt(curSegment);

            // If valid segment
            if (isValidSegment(current, str, len, index)) {
                segments[segment] = current; // Choose
                genIp(str, index + len, segment + 1, segments, res); // Explore
                segments[segment] = -1; // Unchoose
            }
        }

    }

    public ArrayList<String> genIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        int[] segments = new int[4];

        genIp(s, 0, 0, segments, res);

        return res;
    }
}