/*
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (34.42%)
 * Total Accepted:    68.9K
 * Total Submissions: 199.9K
 * Testcase Example:  '[]'
 *
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This
 * time, all houses at this place are arranged in a circle. That means the
 * first house is the neighbor of the last one. Meanwhile, the security system
 * for these houses remain the same as for those in the previous street. 
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length+1];
		dp[1] = nums[0];

		for(int i=2; i<nums.length; i++)
			dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
		int first = (dp.length > 2) ? dp[dp.length-2] : dp[1];

		Arrays.fill(dp, 0);
		for(int i=2; i<=nums.length; i++)
			dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
		int end = dp[dp.length-1];

		return Math.max(first, end);
    }
}
