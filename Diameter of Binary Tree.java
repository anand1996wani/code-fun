/**
* 543. Diameter of Binary Tree
* https://leetcode.com/problems/diameter-of-binary-tree/description/ 
*/  

class Solution {
    int max;

    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }else{
            int left = helper(root.left);
            int right = helper(root.right);

            this.max = Math.max(this.max, left + right);

            return Math.max(left, right) + 1;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        helper(root);
        return this.max;
    }
}
