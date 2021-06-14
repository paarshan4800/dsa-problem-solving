// Given a string of S as input. Your task is to write a program to remove or
// delete the minimum number of characters from the string so that the resultant
// string is a palindrome.
// Note: The order of characters in the string should be maintained.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1

// Input : aebcbda
// Output : 2
// Remove characters 'e' and 'd'
// Resultant string will be 'abcba'
// which is a palindromic string

// Input : geeksforgeeks
// Output : 8

// Brute Force
// Remove all subsequences one by one and check if the remaining string is
// palindrome or not.
// Time Complexity - exponential.

// Efficient Approach
// Find the longest palindromic subsequence
// Minimum number of deletions = Length of string - Longest Palindromic
// Subsequence