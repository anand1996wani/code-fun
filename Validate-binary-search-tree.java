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
    boolean flag;
    int prevVal;
    boolean isPrevVal; 

    public void isValidBSTDFS(TreeNode root) {
        if(root != null) { 
            isValidBSTDFS(root.left);

            if(this.isPrevVal == false){
                this.isPrevVal = true;
            }else{
                if(root.val <= this.prevVal) {
                    this.flag = false;
                }
            }
            this.prevVal = root.val;
            System.out.println(root.val);
            isValidBSTDFS(root.right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        this.isPrevVal = false;
        this.flag = true;
        isValidBSTDFS(root);
        return this.flag;
    }
}
