/**
*
* Reverse array in groups  https://www.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
*/  

class Solution {

    // Function to reverse every sub-array group of size k.
    void helper(ArrayList<Long> arr, int start, int end) {
        if(start < end){
            long temp = arr.get(end);
            arr.set(end, arr.get(start));
            arr.set(start, temp);
            //System.out.println("Start " + start + " end " + end);
            helper(arr, start + 1, end - 1);
        }else{
            return;
        }
    }
    
    void reverseInGroups(ArrayList<Long> arr, int k) {
        //System.out.println(arr.size() + " " + k);
        for(int i = 0;i < arr.size();i++) {
            //System.out.println("i = " + i);
            if(i%k == 0){
                int start = i;
                int end = Math.min(arr.size() - 1, i + k - 1);
                //System.out.println("Start " + start + " end " + end);
                helper(arr, start, end);
            }else{
                continue;
            }
        }
    }
}
