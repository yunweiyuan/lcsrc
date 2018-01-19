/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Medium (44.63%)
 * Total Accepted:    45.9K
 * Total Submissions: 102.8K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * 
 * 
 * You may assume that there is only lower case English letters in both s and
 * t. t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (
 * 
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * 
 * Return true.
 * 
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * 
 * Return false.
 * 
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[26];
	    for(int i=0; i<t.length(); i++){
			if(idx[t.charAt(i)-'a'] == null)
				idx[t.charAt(i)-'a'] = new ArrayList<Integer>();
			idx[t.charAt(i)-'a'].add(i);
	    }

		int prev = 0;
		for(int i=0; i<s.length(); i++){
			if(idx[s.charAt(i)-'a'] == null) return false;
			int injection = Collections.binarySearch(idx[s.charAt(i)-'a'], prev);
			if(injection < 0) injection = -injection - 1;
			if(injection == idx[s.charAt(i)-'a'].size()) return false;
			prev = idx[s.charAt(i)-'a'].get(injection) + 1;
		}
		return true;
    }
}
