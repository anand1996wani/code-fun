/**
*   Count Inversions https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
*/

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    
    static long merge(long arr[], int start, int mid, int end) {
        long count = 0;
        
        long temp[] = new long[end - start + 1];
        int t = 0;
    
        int left = start;
        int right = mid + 1;
    
        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[t++] = arr[left++];
            }else{
                count = count + (mid - left + 1);
                temp[t++] = arr[right++];
            }
        }
        
        while(left <= mid) {
            temp[t++] = arr[left++];
        }
        
        while(right <= end) {
            temp[t++] = arr[right++];
        }
        
        int p = start;
        for(int i = 0;i < temp.length;i++)
            arr[p++] = temp[i];
        
        return count;
    }
    
    static long mergeSort(long arr[], int start, int end) {
        if(start < end){
            long count = 0;
            int mid = (start + end)/2;
            count = count + mergeSort(arr, start, mid);
            count = count + mergeSort(arr, mid + 1, end);
            count = count + merge(arr, start, mid, end);
            return count;
        }else{
            return 0;
        }
    }
    
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        return mergeSort(arr, 0, n - 1);
    }
}
