// Given a string in roman no format (s) your task is to convert it to an
// integer . Various symbols and their values are given below.
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1#

// Input:
// s = V
// Output: 5

// Input:
// s = III
// Output: 3

class RomanToNumber {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);

        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            // If current val is < next val, subtract current val from next val and add to
            // res
            if (i + 1 < str.length() && hash.get(str.charAt(i)) < hash.get(str.charAt(i + 1))) {
                res += (hash.get(str.charAt(i + 1)) - hash.get(str.charAt(i)));
                i++;
            }
            // Else add current val to res
            else {
                res += (hash.get(str.charAt(i)));
            }
        }

        return res;
    }
}