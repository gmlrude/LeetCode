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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        bfs(root, result);
        return result;
    }

    public void bfs(TreeNode point, List<Double> res) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(point);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;				
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) 
                    queue.offer(node.left);
                if(node.right != null) 
                    queue.offer(node.right);

                sum += node.val;		
            }
            res.add(sum/size);
        }
    }
}