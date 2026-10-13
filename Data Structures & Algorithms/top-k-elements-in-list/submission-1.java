class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step1: Map each number to its occurrence indices
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            map.putIfAbsent(nums[idx], new HashSet<>());
            map.get(nums[idx]).add(idx);
        }
        // Step 2: Build unique sets and their sizes
        ArrayList<HashSet<Integer>> sets = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        for (HashSet<Integer> set : map.values()) {
            sets.add(set);
            sizes.add(set.size());
        }
        // Step 3: Coutning sort the sizes
        int[] sortedSizes = countingSort(sizes);
        // Step 4: Select the top k Sizes
        HashMap<Integer, Integer> requiredSizes = new HashMap<>();

        for (int idx = sortedSizes.length - k; idx < sortedSizes.length; idx++) {
            requiredSizes.merge(sortedSizes[idx], 1, Integer::sum);
        }
        // Step 5: Match sets to the selected sizes
        int[] answer = new int[k];
        int count = 0;

        for (HashSet<Integer> set : sets) {
            int size = set.size();
            int remaining = requiredSizes.getOrDefault(size, 0);

            if (remaining > 0) {
                int firstIndex = set.iterator().next();
                answer[count++] = nums[firstIndex];
                if (remaining == 1) {
                    requiredSizes.remove(size);
                } else {
                    requiredSizes.put(size, remaining - 1);
                }
                if (count == k) {
                    break;
                }
            }
        }
        return answer;
    }
    // Counting Sort: Sorts only sizes list
    private int[] countingSort(ArrayList<Integer> sizes) {
        if (sizes.isEmpty()) {
            return new int[0];
        }
        int max = Collections.max(sizes);
        int[] frequency = new int[max + 1];
        for (int size : sizes) {
            frequency[size]++;
        }
        int[] sorted = new int[sizes.size()];
        int index = 0;

        for (int value = 0; value <= max; value++) {
            while (frequency[value] > 0) {
                sorted[index++] = value;
                frequency[value]--;
            }
        }
        return sorted;
    }
}
