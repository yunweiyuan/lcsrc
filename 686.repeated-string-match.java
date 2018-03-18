/*
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (34.27%)
 * Total Accepted:    23.7K
 * Total Submissions: 72.8K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * 
 * For example, with A = "abcd" and B = "cdabcdab". 
 * 
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 * 
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
		int count = 0;
		String dupA = "";
		while(dupA.length() < B.length()) {
			dupA += A;
			count++;
		}
		
		if(dupA.contains(B)) {
			return count;
		}
		if((dupA += A).contains(B)) {
			return ++count;
		}
		return -1;
	}
}
