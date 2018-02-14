/*
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (39.12%)
 * Total Accepted:    37.8K
 * Total Submissions: 96.8K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * 
 * Note:
 * 
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 */
class Solution {
/* TLE
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int num : nums) sum += num;
		if((sum % 2) != 0) return false;

		return helper(0, 0, sum/2, nums);
    }

	boolean helper(int curSum, int idx, int target, int[] nums){
		if(curSum == target) return true;

		for(int i=idx; i<nums.length; i++){
			if(helper(curSum+nums[i], i+1, target, nums)) return true;
			if(helper(curSum, i+1, target, nums)) return true;
		}

		return false;
	}
*/


    public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int num : nums) sum += num;
		if((sum & 1) == 1) return false;

		sum /= 2;

		boolean[] dp = new boolean[sum+1];
		Arrays.fill(dp, false);
		dp[0] = true;

		for(int num: nums){
			for(int i=sum; i>0; i--){
				if(i >= num) dp[i] = dp[i] || dp[i-num];
			}
		}

		return dp[sum];
	}
}
