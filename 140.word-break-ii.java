/*
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (24.10%)
 * Total Accepted:    107.3K
 * Total Submissions: 442.4K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 * 
 * 
 * 
 * Return all such possible sentences.
 * 
 * 
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * 
 * 
 * A solution is ["cats and dog", "cat sand dog"].
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
/*    public List<String> wordBreak(String s, List<String> wordDict) {
		int longest = 0;
		Set<String> dict = new HashSet<>();
		List<String> res = new LinkedList<>();

		for(String word : wordDict) {
			longest = Math.max(longest, word.length());
			dict.add(word);
		}

		helper(res, "", s, dict, longest);
    	return res;
	}

	void helper(List<String> res, String sentence, String remain, Set<String> dict, int longest) {
		if(remain.equals("")){
			res.add(sentence.trim());
			return;
		}

		for(int i=Math.min(remain.length(), longest); i>0; i--){
			String cur = remain.substring(0, i);
			if(dict.contains(cur)) helper(res, sentence + " " + cur, remain.substring(i), dict, longest);
		}
	}
*/
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> map = new HashMap<>();
		Set<String> words = new HashSet<>();
		for (String word : wordDict) {
			words.add(word);
		}
		return helper(s, words, map);
	}
	private List<String> helper(String s, Set<String> words, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			return res;
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (words.contains(right)) {
				if (left.length() == 0) {
					res.add(right);
				} else {
					List<String> leftParts = helper(left, words, map);
					for (String part : leftParts) {
						res.add(part + " " + right);
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
