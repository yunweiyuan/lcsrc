/*
 * [375] Guess Number Higher or Lower II
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
 *
 * algorithms
 * Medium (36.02%)
 * Total Accepted:    27.2K
 * Total Submissions: 75.6K
 * Testcase Example:  '1'
 *
 * We are playing the Guess Game. The game is as follows: 
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is
 * higher or lower. 
 * 
 * However, when you guess a particular number x,  and you guess wrong, you pay
 * $x. You win the game when you guess the number I picked.
 * 
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * 
 * 
 * 
 * Given a particular n ≥ 1, find out how much money you need to have to
 * guarantee a win.
 * 
 * Credits:Special thanks to @agave and @StefanPochmann for adding this problem
 * and creating all test cases.
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
	return dp(table, 1, n);	 
    }

    private int dp(int[][] table, int s, int e) {
	if(s >= e) return 0;
	if(table[s][e] != 0) return table[s][e];
	int pay = Integer.MAX_VALUE;
	for(int k=s; k<=e; k++){
	    int temp = k + Math.max(dp(table, s, k-1), dp(table, k+1, e));
	    pay = Math.min(pay, temp);
	}
	table[s][e] = pay;
	return pay;
    }
}
