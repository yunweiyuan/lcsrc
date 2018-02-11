/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (49.07%)
 * Total Accepted:    92.5K
 * Total Submissions: 187.2K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * 
 * Note: 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for(int num : nums)
			freq.put(num, freq.getOrDefault(num, 0)+1);
    	
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
				return e2.getValue() - e1.getValue();
			}
		});

		for(Map.Entry<Integer, Integer> e : freq.entrySet()){
			maxHeap.add(e);
		}

		List<Integer> res = new ArrayList<Integer>();
		while(res.size() < k){
			res.add(maxHeap.poll().getKey());	
		}
		return res;
	}
}
