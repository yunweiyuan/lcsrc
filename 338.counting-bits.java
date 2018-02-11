/*
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (61.90%)
 * Total Accepted:    102.8K
 * Total Submissions: 165.7K
 * Testcase Example:  '2'
 *
 * Given a non negative integer number num. For every numbers i in the range 0
 * ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 * 
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount  in c++ or in any other language.
 * 
 * 
 * 
 * Credits:Special thanks to @ syedee  for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int[] countBits(int num) {
		int res[] = new int[num+1];
		int loopSize = 1;
		for(int i=1; i<=num; i++){
			if(i > 1) loopSize = i%loopSize == 0 ? loopSize*2 : loopSize;
			int idx = i%loopSize;
			res[i] = res[idx]+1;
		}
		return res;
    }
}
