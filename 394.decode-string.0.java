/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (41.94%)
 * Total Accepted:    47.5K
 * Total Submissions: 113.2K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 */
class Solution {

	public String decodeString(String s) {
		String base = "";
		Stack<Integer> coefs = new Stack<>();
		Stack<String> prefix = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int coef = s.charAt(i) - '0';
				while(Character.isDigit(s.charAt(i + 1))){
					coef = coef * 10 + s.charAt(++i) - '0';
				}
				coefs.push(coef);
			} else if(s.charAt(i) == '[') {
				prefix.push(base);
				base = "";
			} else if(s.charAt(i) == ']') {
				String prev = prefix.pop();
				int coef = coefs.pop();
				for(int j = 0; j < coef; j++) {
					prev += base;
				}
				base = prev;
			} else {
				base += s.charAt(i);
			}
		}

		return base;
	}

// Recursive
/*	public String decodeString(String s) {
		String digit = "";
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				digit += s.charAt(i);
			} else if(s.charAt(i) == '[') {
				int coef = Integer.valueOf(digit);
				digit = "";
				int start = i + 1;
				int bracketCount = 0;
				while(++i < s.length()) {
					if(s.charAt(i) == '['){
						bracketCount++;
					}
					if(s.charAt(i) == ']' && bracketCount == 0) {
						break;
					}
					if(s.charAt(i) == ']') {
						bracketCount--;
					}
				}
				String inner = "";
				String temp = decodeString(s.substring(start, i));
				for(int j = 0; j < coef; j++) {
					inner += temp;
				}
				result += inner;
			} else {
				result += s.charAt(i);
			}
		}
		return result;
    }
*/
}
