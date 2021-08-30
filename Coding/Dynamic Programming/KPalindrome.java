// A string is k palindrome if it can be transformed into a palindrome on
// removing at most k characters from it. Your task is to complete the function
// is_k_palin which takes two arguments a string str and a number N . Your
// function should return true if the string is k palindrome else it should
// return false.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/k-palindrome/1/

// Example:
// Input
// 2
// abcdecba 1
// acdcb 1
// Output
// 1
// 0

// Find the longest palindromic subsequence
// For example, for the string abcdecba, the longest palindromic subsequence is
// 7.
// If the length of the string - K (given in question) is less than or equal to
// the longest palindromic subsequence, then the result is true. Else false

// In the example, 8-1 <= 7. i.e By removing atmost 1 character from the string
// of length 8, the length of the palindromic subsequence should be less than or
// equal to it