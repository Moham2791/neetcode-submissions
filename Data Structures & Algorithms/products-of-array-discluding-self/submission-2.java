class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];


        // Build prefix and suffix products simultaneously
        for(int i=0; i<n;i++){
            prefix[i] = (i==0)? nums[i] : prefix[i-1]* nums[i];
            int j = n-1-i;
            suffix[j] = (j==n-1) ? nums[j]: suffix[j+1]*nums[j];

        }

        for(int i=0;i<=n-1;i++){

            if(i==0){
                result[i] = suffix[i+1];

            }
            else if(i==n-1){
                result[i]= prefix[i-1];
            }
            else{
                result[i]= prefix[i-1]* suffix[i+1];
            }
        }
        return result;




    }
}  
