//1235. Maximum Profit in Job Scheduling

//TLE Basic Solution

class Node {
    int startTime;
    int endTime;
    int profit;

    public Node(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    public int helper(ArrayList<Node> arrayList, int index, int busyTill) {
        if(index < arrayList.size()) {
            int profit1 = 0;
            int profit2 = 0;

            //Take index
            if(arrayList.get(index).startTime >=  busyTill) 
                profit1 = arrayList.get(index).profit + helper(arrayList, index + 1, arrayList.get(index).endTime);
                

            //Dont take index
            profit2 = helper(arrayList, index + 1, busyTill);

            return Math.max(profit1, profit2);
        } else{
            return 0;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        
        for(int i = 0;i < startTime.length;i++){
            arrayList.add(new Node(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(arrayList, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.startTime >= b.startTime){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        return helper(arrayList, 0, 0);
    }
}


// Optimized Solution
class Node {
    int startTime;
    int endTime;
    int profit;

    public Node(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    public int search(ArrayList<Node> arrayList, int index){
        int low = index + 1;
        int high = arrayList.size() - 1;
        int result = arrayList.size();

        while(low <= high){
            int mid = (low + high)/2;
            if(arrayList.get(mid).startTime >= arrayList.get(index).endTime){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
    public int helper(ArrayList<Node> arrayList, int index, int[] dp) {
        if(index < arrayList.size()) {
            if(dp[index] == -1){
                int profit1 = 0;
                int profit2 = 0;

                //Take index
                int j = search(arrayList, index);
                // while(j < arrayList.size() && arrayList.get(j).startTime < arrayList.get(index).endTime){
                //     j = j + 1;
                // }
                profit1 = arrayList.get(index).profit + helper(arrayList, j, dp);
                    

                //Dont take index
                profit2 = helper(arrayList, index + 1, dp);

                dp[index] = Math.max(profit1, profit2);

                return dp[index];
            }else{
                return dp[index];
            }
        } else{
            return 0;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        
        for(int i = 0;i < startTime.length;i++){
            arrayList.add(new Node(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(arrayList, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.startTime > b.startTime){
                    return 1;
                }else{
                    return -1;
                }
            }
        });


        int dp[] = new int[startTime.length + 1];
        Arrays.fill(dp, -1);
        return helper(arrayList, 0, dp);
    }
}
