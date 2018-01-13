/*
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (24.63%)
 * Total Accepted:    77.6K
 * Total Submissions: 314.8K
 * Testcase Example:  '"aab"'
 *
 * 
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced
 * using 1 cut.
 * 
 * i.e. given s = "aabaa", return 0.
 * cut[i] means min cut for s[i...n-1]
 */
class Solution {
    public int minCut(String s) {
        if(s==null||s.length()==0) return 0;
	boolean[][] pal = new boolean[s.length()][s.length()];
	int[] cut = new int[s.length()];
	for(int i=0; i<s.length(); i++)
	    Arrays.fill(pal[i], false);

	for(int i=s.length()-1; i>=0; i--){
	    cut[i] = s.length()-1-i;
	    for(int j=i; j<s.length(); j++){
		if(s.charAt(i) == s.charAt(j)){
		    if(j-i < 2) pal[i][j] = true;
		    else
			pal[i][j] = pal[i+1][j-1];
		}
		if(pal[i][j]){
		    if(j == s.length()-1) cut[i]=0;
		    else
			cut[i]=Math.min(cut[i], cut[j+1]+1);
		}
	   }
	}
	return cut[0];	
    }
}
