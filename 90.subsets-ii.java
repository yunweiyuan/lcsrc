/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (37.53%)
 * Total Accepted:    141K
 * Total Submissions: 370.2K
 * Testcase Example:  '[1,2,2]'
 *
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * 
 * 
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		dfsHelper(nums, 0, new ArrayList<Integer>(), result);
		return result;
    }

	private void dfsHelper(int[] nums,
						   int startIdx,
						   List<Integer> subset,
						   List<List<Integer>> result) {
		result.add(new ArrayList<>(subset));

		for(int i = startIdx; i < nums.length; i++) {
			if(i > startIdx && nums[i] == nums[i-1]) {
				continue;
			}
			subset.add(nums[i]);
			dfsHelper(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
	}
}
