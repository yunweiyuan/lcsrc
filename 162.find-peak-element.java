/*
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (38.36%)
 * Total Accepted:    146.1K
 * Total Submissions: 376.6K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 * 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
class Solution {
    public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] > nums[mid + 1]) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if(nums[start] > nums[end]) {
			return start;
		} else {
			return end;
		}
    }
}
