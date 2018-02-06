/*
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (30.98%)
 * Total Accepted:    194.1K
 * Total Submissions: 622.9K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * 
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * 
 * 
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a
 * set of strings). Please reload the code definition to get the latest
 * changes.
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
		int longestWord = 0;
		Set<String> set = new HashSet<String>();
		for(String word : wordDict){
			longestWord = Math.max(longestWord, word.length());
			set.add(word);
		}
		
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;

		int last = 0;
		for(int i=1; i<=s.length(); i++){
			if(i>last+longestWord) break;
			for(int j=Math.max(0, i-longestWord); j<i; j++){
				String temp = s.substring(j, i);
				if(dp[j] && set.contains(temp)){
					dp[i] = true;
					last = i;
					break;
				}
			}
		}
		return dp[s.length()];
    }
}
