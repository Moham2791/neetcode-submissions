class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 != p2 && p1<=s.length()-1 && p2>=0) {

            if (p1 == p2) {
                break;
            }
            if (!Character.isLetterOrDigit(s.charAt(p1))) {
                p1 += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(p2))) {
                p2 -= 1;
            } else if (Character.toLowerCase(s.charAt(p1))!= Character.toLowerCase
            (s.charAt(p2))) {
                return false;
            } else {
                p2 -= 1;
                p1 += 1;
            }
        }
        return true;
    }
}
