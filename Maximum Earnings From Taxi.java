/**

2008. Maximum Earnings From Taxi

https://leetcode.com/problems/maximum-earnings-from-taxi/description/

*/

class Solution {
    public long helper1(int n, int[][] rides, int index, int lastEndTime) {
        if(index < rides.length){
            long profit1 = 0;
            long profit2 = 0;

            //Take Index
            if(rides[index][0] >= lastEndTime) {
                profit1 = (rides[index][1] - rides[index][0] + rides[index][2]) + helper1(n, rides, index + 1, rides[index][1]);
            }

            //Dont Take Index
            profit2 = helper1(n, rides, index + 1, lastEndTime);

            return Math.max(profit1, profit2);
        }else
            return 0;
    }

    public long maxTaxiEarnings1(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                if(a[0] > b[0]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        return helper1(n, rides, 0, 0);
    }


    public long helper2(int n, int[][] rides, int index, int lastEndTime, long dp[][]) {
        if(index < rides.length){
            if(dp[index][lastEndTime] == -1){
                long profit1 = 0;
                long profit2 = 0;

                //Take Index
                if(rides[index][0] >= lastEndTime) {
                    profit1 = (rides[index][1] - rides[index][0] + rides[index][2]) + helper2(n, rides, index + 1, rides[index][1], dp);
                }

                //Dont Take Index
                profit2 = helper2(n, rides, index + 1, lastEndTime, dp);
                dp[index][lastEndTime] = Math.max(profit1, profit2);
            }
            return dp[index][lastEndTime];
        }else
            return 0;
    }

    public long maxTaxiEarnings2(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                if(a[0] > b[0]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        long dp[][] = new long[n + 1][n + 1];

        for(long a[] : dp){
            Arrays.fill(a, -1);
        }

        return helper2(n, rides, 0, 0, dp);
    }

    public int customBinarySearch(int [][]rides, int low, int high, int lookup) {
        int result = 0;
        while(low <= high) {
            int mid = (low + high)/2;
            if(rides[mid][0] >= lookup){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high + 1;
    }

    public long helper(int n, int[][] rides, int index, long dp[]) {
        if(index < rides.length){
            if(dp[index] == -1){
                long profit1 = 0;
                long profit2 = 0;

                //Take Index
                // int next = index + 1;
                // while(next < rides.length && rides[next][0] < rides[index][1]){
                //     next = next + 1;
                // }
                int next = customBinarySearch(rides, index + 1, rides.length - 1, rides[index][1]);

                profit1 = (rides[index][1] - rides[index][0] + rides[index][2]) + helper(n, rides, next, dp);
                
                //Dont Take Index
                profit2 = helper(n, rides, index + 1, dp);
                dp[index] = Math.max(profit1, profit2);
            }
            return dp[index];
        }else
            return 0;
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>(){
            @Override
            public int compare(int a[], int b[]){
                if(a[0] > b[0]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        long dp[] = new long[rides.length + 1];
        Arrays.fill(dp, -1);
        return helper(n, rides, 0, dp);
    }
}
