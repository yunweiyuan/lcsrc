/*
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (42.55%)
 * Total Accepted:    52.2K
 * Total Submissions: 122.5K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * ⁠Given an integer array with all positive numbers and no duplicates, find
 * the number of possible combinations that add up to a positive integer
 * target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers? 
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
		/*1.recursive solution time-limitation exceded
		if(target == 0) return 1;
		int counts = 0;

		for(int num : nums){
			if(target >= num)
				counts += combinationSum4(nums, target - num);
		}
		return counts;
		*/

		//2.DP solution
		int[] dp = new int[target+1];
		dp[0] = 1;
		for(int i=1; i<dp.length; i++){
			for(int j=0; j<nums.length; j++){
				if(i-nums[j] >= 0)
					dp[i] += dp[i-nums[j]];
			}
		}
		return dp[target];
    }
}
