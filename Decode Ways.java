/*

Decode Ways.java





*/


class Solution {
    public int helper1(char[] array, int index) {
        int one = 0;
        int two = 0;
        if(index < array.length){
            if(array[index] > '0' && array[index] <= '9'){
                one =  this.helper1(array, index + 1);
            }

            if( array[index] > '0' &&
                array[index] <= '2' &&
                index < (array.length - 1) &&
                ((array[index] == '1' && array[index + 1] >= '0' && array[index + 1] <= '9') ||
                (array[index] == '2' && array[index + 1] >= '0' && array[index + 1] <= '6' ))){
                two =  this.helper1(array, index + 2);  
            }
        }else{
            return 1;
        }

        return one + two;
    }
    public int helper(char[] array, int index, int a[], int b[]) {
        if(index < array.length){
            if(array[index] > '0' && array[index] <= '9'){
                if(a[index] == -1)
                    a[index] =  this.helper(array, index + 1, a, b);
            }
        }else{
            return 1;
        }

        if( index < array.length ){
            if( array[index] > '0' &&
                array[index] <= '2' &&
                index < (array.length - 1) &&
                ((array[index] == '1' && array[index + 1] >= '0' && array[index + 1] <= '9') ||
                (array[index] == '2' && array[index + 1] >= '0' && array[index + 1] <= '6' ))){
                if(b[index] == -1)
                    b[index] =  this.helper(array, index + 2, a, b);  
            }
        }else{
            return 1;
        }

        if(a[index] == -1)a[index] = 0;
        if(b[index] == -1)b[index] = 0;
        return a[index] + b[index];
    }

    public int numDecodings(String s) {
        int array1[] = new int[s.length()];
        int array2[] = new int[s.length()];

        for(int i = 0;i < s.length();i++){
            array1[i] = -1;
            array2[i] = -1;
        }
        
        return this.helper(s.toCharArray(), 0, array1, array2) != -1 ? this.helper(s.toCharArray(), 0, array1, array2) : 0 ;
    }
}
