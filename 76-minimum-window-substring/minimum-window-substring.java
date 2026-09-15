import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size(); // number of unique chars that must be fully matched
        int formed = 0; // number of unique chars currently satisfying required frequency

        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && windowCounts.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window from the left while it's still valid
            while (left <= right && formed == required) {
                // Update result if this window is smaller
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (need.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}