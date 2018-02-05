/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (55.67%)
 * Total Accepted:    30.1K
 * Total Submissions: 54.4K
 * Testcase Example:  '"abc"'
 *
 * 
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * 
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters. 
 * 
 * 
 * Example 1:
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Note:
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s) {
		int len = s.length();
		int count = 0;
		for(int i=0; i<len; i++){
			for(int j=0; i-j>=0 && i+j<len && s.charAt(i-j) == s.charAt(i+j); j++) count++;
			for(int j=0; i-j>=0 && i+j+1<len && s.charAt(i-j) == s.charAt(i+j+1); j++) count++;
		}
		return count;
    }
}
