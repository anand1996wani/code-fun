class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        /*
        for(int i = 0; i < prices.length;i++) {
            int curr = prices[i];

            for(int j = i + 1;j < prices.length;j++) {
                int next = prices[j];
                if(next >= curr){
                    maxProfit = Math.max(next - curr, maxProfit);
                }
            }
        }*/

        int maxNextArray[] = new int[prices.length];
        maxNextArray[maxNextArray.length - 1] = prices[maxNextArray.length - 1];
        int maxTillNow = maxNextArray[maxNextArray.length - 1];

        for(int i = maxNextArray.length - 2; i >= 0;i--){
            
            maxTillNow = Math.max(maxTillNow, prices[i]);
            maxNextArray[i] = maxTillNow;

        }

        // for(int i = 0;i < prices.length;i++){
        //     System.out.print(maxNextArray[i] + " ");
        // }


        // System.out.println();

        for(int i = 0;i < prices.length;i++){
            maxProfit = Math.max(maxProfit, maxNextArray[i] - prices[i]);
        }

        return maxProfit;
    }
}
