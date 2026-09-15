class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Normalize the string
        s = s.toLowerCase();
        
        // Step 2: Remove non-alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        
        // Step 3: Two-pointer check
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
