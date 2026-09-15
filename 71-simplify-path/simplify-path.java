import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue; // skip empty segments and current-dir markers
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // go to parent directory
                }
            } else {
                stack.push(part); // valid directory/file name
            }
        }

        // Build the canonical path from the bottom of the stack up
        StringBuilder sb = new StringBuilder();
        List<String> dirs = new ArrayList<>(stack);
        Collections.reverse(dirs);
        for (String dir : dirs) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}