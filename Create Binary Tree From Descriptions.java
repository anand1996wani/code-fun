//Create Binary Tree From Descriptions

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
    class Node {
        int value;
        boolean isRoot;

        public Node(int v, boolean b){
            this.value = v;
            this.isRoot = b;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hashMap = new HashMap<Integer, TreeNode>();
        HashMap<Integer, Node> hashSet = new HashMap<Integer, Node>();

        for(int i = 0;i < descriptions.length;i++){
            int root = descriptions[i][0];
            //hashSet.put(root, new Node(root, true));
            if(hashMap.get(root) != null) {
                TreeNode currNode = hashMap.get(root);
                if(descriptions[i][2] == 1){
                    if(hashMap.get(descriptions[i][1]) == null){
                        TreeNode leftNode = new TreeNode(descriptions[i][1]);
                        currNode.left = leftNode;
                        hashMap.put(descriptions[i][1], leftNode);
                    }else{
                        TreeNode leftNode = hashMap.get(descriptions[i][1]);
                        currNode.left = leftNode;
                    }
                }else{
                    if(hashMap.get(descriptions[i][1]) == null){
                        TreeNode rightNode = new TreeNode(descriptions[i][1]);
                        currNode.right = rightNode;
                        hashMap.put(descriptions[i][1], rightNode);
                    }else{
                        TreeNode rightNode = hashMap.get(descriptions[i][1]);
                        currNode.right = rightNode;
                    }
                }
                hashMap.put(root, currNode);
            }else {
                TreeNode newNode = new TreeNode(root);
                if(descriptions[i][2] == 1){
                    if(hashMap.get(descriptions[i][1]) == null){
                        TreeNode leftNode = new TreeNode(descriptions[i][1]);
                        newNode.left = leftNode;
                        hashMap.put(descriptions[i][1], leftNode);
                    }else{
                        TreeNode leftNode = hashMap.get(descriptions[i][1]);
                        newNode.left = leftNode;
                    }
                }else{
                    if(hashMap.get(descriptions[i][1]) == null){
                        TreeNode rightNode = new TreeNode(descriptions[i][1]);
                        newNode.right = rightNode;
                        hashMap.put(descriptions[i][1], rightNode);
                    }else{
                        TreeNode rightNode = hashMap.get(descriptions[i][1]);
                        newNode.right = rightNode;
                    }
                }
                hashMap.put(root, newNode);
            }
            if(hashSet.get(descriptions[i][1]) != null){
                Node curr = hashSet.get(descriptions[i][1]);
                curr.isRoot = false;
                hashSet.put(descriptions[i][1], curr);
            }else{
                Node curr = new Node(descriptions[i][1], false);
                hashSet.put(descriptions[i][1], curr);
            }
        }

        for (Map.Entry<Integer,TreeNode> mapElement : hashMap.entrySet()) {
            Integer key = mapElement.getKey();
            if(hashSet.get(key) == null){
                return (TreeNode)mapElement.getValue();
            }
        }
        return null;
    }
}
  
