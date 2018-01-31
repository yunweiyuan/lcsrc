/*
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (37.65%)
 * Total Accepted:    100K
 * Total Submissions: 265.1K
 * Testcase Example:  '1'
 *
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * 
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public int numSquares(int n) {
		int[] dp = new int[n];
		dp[0] = 1;

		for(int i=1; i<n; i++){
			double root = Math.sqrt(i+1);
			if(root - (int)root == 0){
				dp[i] = 1;
				continue;
			}
			int min = i+1;
			for(int j=0; j<root-1; j++){
				int factor = (j+1)*(j+1);
				min = Math.min(min, dp[factor-1] + dp[i-factor]);
			}
			dp[i] = min;
		}
		return dp[n-1];
    }
}
