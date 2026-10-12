class Solution {
    public boolean isAnagram(String s, String t) {
        int count = 0;
        if (s.length() != t.length()) {
            return false;
        } else if (s.equalsIgnoreCase(t)) {
            return true;
        }

        else {
            HashMap<Character, Integer> freq = new HashMap<>();

            for (int i = 0; i <= s.length() - 1; i++) {
                if (freq.containsKey(s.charAt(i))) {
                    freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
                } else {
                    freq.put(s.charAt(i), 1);
                }
            }

            for (int j = 0; j <= t.length() - 1; j++) {
                if (freq.containsKey(t.charAt(j))) {
                    freq.put(t.charAt(j), freq.get(t.charAt(j)) - 1);
                    if (freq.get(t.charAt(j)) == 0) {
                        freq.remove(t.charAt(j));
                    }
                }
            }
            if (freq.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
