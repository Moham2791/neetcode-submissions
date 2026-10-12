class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] backup = Arrays.copyOf(strs, strs.length);

        lexSort(strs);

        int group_location = 0;
        ArrayList<String> group = new ArrayList<>();
        ArrayList<List<String>> arr = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int idx = 0; idx <= strs.length - 1; idx++) {
            if (!map.containsKey(strs[idx])) {
                arr.add(new ArrayList<String>());
                arr.get(arr.size() - 1).add(backup[idx]);
                map.put(strs[idx], arr.size() - 1);

            } else {
                group_location = map.get(strs[idx]);
                arr.get(group_location).add(backup[idx]);
            }
        }
        return arr;
    }

    public void lexSort(String[] strs) {
        for (int j = 0; j < strs.length; j++) {

            int[] counts = new int[26];

            for (int i = 0; i < strs[j].length(); i++) {
                counts[strs[j].charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                while (counts[i]-- > 0) sb.append((char) (i + 'a'));
            }
            strs[j] = sb.toString();
        }
    }
}
