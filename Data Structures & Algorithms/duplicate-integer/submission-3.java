class Solution {
    public boolean hasDuplicate(int[] nums) {
       
        if (nums.length == 0) {
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        Arrays.sort(nums);
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else {


                if(!map.containsKey(nums[i])){

                    map.put(nums[i],nums[i]);
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}