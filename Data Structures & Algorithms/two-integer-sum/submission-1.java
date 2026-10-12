class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        int diff = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            checked.put(nums[i], i);
        }

        for (int i = 0; i <= nums.length; i++) {
            diff = target - nums[i];
            if (checked.containsKey(diff) && checked.get(diff)!=i) {
                return new int[] {i, checked.get(diff)};
            }
        }
        return new int[] {0, 0};
    }
}
