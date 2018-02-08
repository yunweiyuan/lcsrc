/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (26.41%)
 * Total Accepted:    129.2K
 * Total Submissions: 486.3K
 * Testcase Example:  '[-2]'
 *
 * 
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest product.
 * 
 * 
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
/* TLE
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++){
			int cur = 1;
			for(int j=i; j<nums.length; j++){
				cur = cur*nums[j];
				max = Math.max(cur, max);
			}
		}
		return max;
*/	
		int curMax = nums[0];
		int curMin = nums[0];
		int max = nums[0];
		int tempMax, tempMin;

		for(int i=1; i<nums.length; i++){
			tempMax = Math.max(Math.max(curMax*nums[i], curMin*nums[i]), nums[i]);
			tempMin = Math.min(Math.min(curMax*nums[i], curMin*nums[i]), nums[i]);
			max = Math.max(max, tempMax);
			curMax = tempMax;
			curMin = tempMin;
		}
		return max;
	}
}
