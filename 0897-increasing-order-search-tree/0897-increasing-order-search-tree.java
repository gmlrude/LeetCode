/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode n = new TreeNode();
        prev = n;
        dfs(root);
        return n.right;
    }

    public void dfs (TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        prev.right = node; // 이전 노드의 오른쪽
        node.left = null;
        prev = node;
        dfs(node.right);
    }
}
