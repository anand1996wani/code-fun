/**
* https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
*/

class Solution
{
    long sum;
    long array[];
   
    //Nci
    public long helper(int n) {
        if(this.array[n] == 0){
            if(n <= 2){
                this.array[n] = n;
                return n;
            }else{
                long part1 = this.helper(n - 1);
                long part2 = ((n - 1)*this.helper(n - 2))%(long)(Math.pow(10,9) + 7);
                long ans = (part1 + part2)%(long)(Math.pow(10,9) + 7);
                this.array[n] = ans;
                return ans;
            }
        }else{
            return this.array[n];
        }
    } 
    
    public long countFriendsPairings(int n) 
    { 
       //code here
       this.array = new long[n + 1];
       this.sum = 0;
       this.sum = this.helper(n);
       
       return this.array[n];
    }
}
