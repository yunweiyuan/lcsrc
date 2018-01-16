/*
 * [368] Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (33.79%)
 * Total Accepted:    31.3K
 * Total Submissions: 92.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj
 * % Si = 0.
 * 
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * 
 * Example 1:
 * 
 * nums: [1,2,3]
 * 
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * 
 * 
 * Example 2:
 * 
 * nums: [1,2,4,8]
 * 
 * Result: [1,2,4,8]
 * 
 * 
 * 
 * Credits:Special thanks to @Stomach_ache for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) return res;
		
		Arrays.sort(nums);
		int length = nums.length;
		int[] dp = new int[length];

		for(int i=1; i<length; i++){
			for(int j=i-1; j>=0; j--){
				if(nums[i] % nums[j] == 0)
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		int maxIdx = 0;
		for(int i=1; i<nums.length; i++)
			maxIdx = dp[i] > dp[maxIdx] ? i : maxIdx;
		
		int temp = nums[maxIdx];
		int cur = dp[maxIdx];
		for(int i=maxIdx; i>=0; i--){
			if(temp%nums[i] == 0 && dp[i] == cur){
				res.add(nums[i]);
				temp = nums[i];
				cur--;
			}
		}
		Collections.sort(res);
		return res;
    }
}
