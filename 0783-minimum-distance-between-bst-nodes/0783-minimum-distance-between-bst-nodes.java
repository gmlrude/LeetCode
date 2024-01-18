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
    public int minDiffInBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < nodes.size()-1; i++) {
            minDiff = Math.min(minDiff, nodes.get(i+1)-nodes.get(i));
        }
        return minDiff;
    }

    void inorder(TreeNode root, List<Integer> nodes) {
        if(root == null) return;

        if(root.left != null) {
            inorder(root.left, nodes);
        }
        nodes.add(root.val);
        if(root.right != null) {
            inorder(root.right, nodes);
        }        
    }
}