/*

https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

*/

class Solution
{
    HashMap<Integer, Integer> hashMap;
    
    //Function to return a list containing the bottom view of the given tree.
    public void helper(Node root) {
        
        Queue<Node> queue = new LinkedList<Node>();
        root.hd = 0;
        queue.add(root);
        
        while(queue.size() > 0 ) {
            Node curr = queue.remove();
            this.hashMap.put(curr.hd, curr.data);
            int index = curr.hd;
            
            if(curr.left != null) {
                Node left = curr.left;
                left.hd = index - 1;
                queue.add(left);
            }
            if(curr.right != null) {
                Node right = curr.right;
                right.hd = index + 1;
                queue.add(right);
            }
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        this.hashMap = new HashMap<Integer, Integer>();
        
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        //System.out.println(root.data);
        this.helper(root);
        
        for(Map.Entry<Integer,Integer> entry : this.hashMap.entrySet()){
            arrayList1.add((Integer)entry.getKey());
        }
        
        Collections.sort(arrayList1);
        
        for(int i = 0;i < arrayList1.size();i++){
            arrayList2.add((Integer)this.hashMap.get(arrayList1.get(i)));
        }
        
        return arrayList2;
    }
}
