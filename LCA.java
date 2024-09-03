/**
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Lowest Common Ancestor of a Binary Tree

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null){            
            if(root.val == p.val || root.val == q.val){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left != null && right != null){
                return root;
            }else if(left != null){
                return left;
            }else if(right != null){
                return right;
            }else{
                return null;
            }

        }else{
            return null;
        }
    }
}
