class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}