/*
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (41.91%)
 * Total Accepted:    100.5K
 * Total Submissions: 238.5K
 * Testcase Example:  '[]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * 
 * For example:
 * Given the following binary tree,
 * 
 * ⁠  1            
 * 
 * 
 * You should return [1, 3, 4].
 * 
 * 
 * Credits:Special thanks to @amrsaqr for adding this problem and creating all
 * test cases.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
		// reverse level traversal
		List<Integer> result = new ArrayList();
		Queue<TreeNode> queue = new LinkedList();
		if (root == null) return result;
								        
		queue.offer(root);
		while (queue.size() != 0) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode cur = queue.poll();
				if (i == 0) result.add(cur.val);
				if (cur.right != null) queue.offer(cur.right);
				if (cur.left != null) queue.offer(cur.left);
			}
		}
		return result;
    }
}
