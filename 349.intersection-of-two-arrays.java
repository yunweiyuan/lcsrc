/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (47.78%)
 * Total Accepted:    121.5K
 * Total Submissions: 252.8K
 * Testcase Example:  '[]\n[]'
 *
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * 
 * Note:
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> pool = new HashSet<>();
		Set<Integer> intersec = new HashSet<>();
		for(int num : nums1) pool.add(num);

		for(int num : nums2){
			if(pool.contains(num)) intersec.add(num);
		}

		int[] res = new int[intersec.size()];
		int i = 0;
		for(Integer num : intersec){
			res[i++] = num;
		}
		return res;
	}
}
