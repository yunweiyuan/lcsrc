/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (33.04%)
 * Total Accepted:    126.8K
 * Total Submissions: 381.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return helper(preorder, inorder, 0, 0, inorder.length -1);
	}

	public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
		if(preStart > preorder.length-1 || inStart > inEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIdx = 0; //idx of current root in inorder array
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == root.val) inIdx = i;			
		}
		root.left = helper(preorder, inorder, preStart+1, inStart, inIdx-1);
		root.right = helper(preorder, inorder, preStart+inIdx-inStart+1, inIdx+1, inEnd);
		return root;
	}
}
