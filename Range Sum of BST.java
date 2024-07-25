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
    int sum;

    public void inOrder(TreeNode root, int low, int high) {
        if(root != null){
            this.inOrder(root.left, low, high);
            if(root.val >= low && root.val <= high){
                this.sum = this.sum + root.val;
            }
            //System.out.println(root.val);
            this.inOrder(root.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum = 0;

        //with recurssion
        //this.inOrder(root, low, high);

        //without recurssion
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(stack.size() > 0 || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int data = curr.val;

            if(data >= low && data <= high){
                this.sum = this.sum + curr.val;
            }

            curr = curr.right;
        }

        return this.sum;
    }
}
