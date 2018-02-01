/*
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (40.50%)
 * Total Accepted:    181.2K
 * Total Submissions: 446.2K
 * Testcase Example:  '[1]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
class Solution {
    public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while(lo < hi){
			int mid = lo + (hi - lo)/2;
			if(nums[mid] < nums[hi]) hi = mid;
			else lo = mid+1;
		}
		return nums[lo];
    }
}
