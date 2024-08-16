/**
* Find-all-lonely-numbers-in-the-array  
*
*/

class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for(int n : nums){
            if(hashMap.get(n) == null) {
                hashMap.put(n, 1);
            } else {
                hashMap.put(n, (int)hashMap.get(n) + 1);
            }
        }

        for(Map.Entry entry : hashMap.entrySet()) {
            if((int)entry.getValue() == 1){
                int t = (int)entry.getKey() - 1;
                int q = (int)entry.getKey() + 1;

                if(hashMap.get(t) == null && hashMap.get(q) == null) {
                    arrayList.add((int)entry.getKey());
                } 
            }  
        }

        return arrayList;
    }
}
