/*
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (29.88%)
 * Total Accepted:    81.1K
 * Total Submissions: 269.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * 
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		if(n == 0) return 0;
		int m = matrix[0].length;
		int max = 0;

		int[][] dp = new int[n+1][m+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				if(matrix[i-1][j-1] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max*max;
    }
}
