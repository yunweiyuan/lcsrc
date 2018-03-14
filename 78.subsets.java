/*
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (43.19%)
 * Total Accepted:    222.8K
 * Total Submissions: 502.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * 
 * 
 * [
 * ⁠ [3],
 * ⁠ [1],
 * ⁠ [2],
 * ⁠ [1,2,3],
 * ⁠ [1,3],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if( nums == null || nums.length == 0) {
			return result;
		}
		dfsHelper(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfsHelper(int[] nums,
						   int startIdx,
						   ArrayList<Integer> subset,
						   List<List<Integer>> result) {
		
		result.add(new ArrayList<Integer>(subset));
		
		for(int i = startIdx; i < nums.length; i++) {
			subset.add(nums[i]);
			dfsHelper(nums, i + 1, subset, result);
			subset.remove(subset.size() -1);
		}
	}

}
