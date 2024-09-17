/**

1985. Find the Kth Largest Integer in the Array

https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

*/

import java.math.BigInteger;  
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        //Create Max Heap
        PriorityQueue<BigInteger> pq = new PriorityQueue<BigInteger>(new Comparator<BigInteger>(){
            @Override
            public int compare(BigInteger a, BigInteger b) {
                return b.compareTo(a);
            }
        });

        for(String s : nums){
            pq.add(new BigInteger(s));
        }

        BigInteger ans = new BigInteger("0");
        while(k > 0 && pq.size() > 0){
            ans = pq.remove();
            k = k - 1;
        }
        
        return ans.toString();
    }
}
