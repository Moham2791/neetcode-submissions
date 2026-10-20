class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[]arr = new int[n];

        int zeroCount =0;
        int zeroIndex = -1;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCount++;
                zeroIndex=i;
            }
        }

        if(zeroCount>1){
            return arr;
        }
        if(zeroCount==1){
            int product=1;
            for(int num: nums){

                if(num!=0){
                    product*=num;
                }
            }
            arr[zeroIndex]=product;
            return arr;
        }
        int suffixP =1;
        int prefixP = nums[0];

        for(int i=1;i<n;i++){
            suffixP*=nums[i];
        }
        arr[0]=suffixP;

        for(int j=1;j<n;j++){

            suffixP /=nums[j];
            arr[j]=suffixP* prefixP;
            prefixP *=nums[j];
        }
        return arr;
    }
}  
