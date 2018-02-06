/*
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (41.12%)
 * Total Accepted:    166.4K
 * Total Submissions: 402K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree [1,null,2,3],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 
 * 
 * 
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
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
    public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<Integer> result = new LinkedList<Integer>();

		while(root != null || !stack.empty()){
			if(root != null){
				stack.push(root.left);
				result.addFirst(root.val);
				root = root.right;
			}else{
				root = stack.pop();
			}
		}
		return result;
    }
}
