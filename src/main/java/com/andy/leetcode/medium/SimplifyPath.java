package com.andy.leetcode.medium;

import java.util.Stack;

/**
 * Created by andy on 2019/7/13.
 */
public class SimplifyPath {
    /**
     * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
     * <p>
     * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
     * <p>
     * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "/home/"
     * Output: "/home"
     * Explanation: Note that there is no trailing slash after the last directory name.
     * Example 2:
     * <p>
     * Input: "/../"
     * Output: "/"
     * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
     * Example 3:
     * <p>
     * Input: "/home//foo/"
     * Output: "/home/foo"
     * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
     * Example 4:
     * <p>
     * Input: "/a/./b/../../c/"
     * Output: "/c"
     * Example 5:
     * <p>
     * Input: "/a/../../b/../c//.//"
     * Output: "/c"
     * Example 6:
     * <p>
     * Input: "/a//b////c/d//././/.."
     * Output: "/a/b/c"
     *
     * @link https://leetcode.com/problems/simplify-path/
     */
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException("null path");
        }
        Stack<String> pathStack = buildPathStack(path);
        return reconstructPath(pathStack);
    }

    private Stack<String> buildPathStack(String path) {
        Stack<String> pathStack = new Stack<>();
        for (int i = 0, preIndex = -1; i <= path.length(); i++) {
            if (i != path.length() && path.charAt(i) != '/') {
                continue;
            }
            if (preIndex == i - 1) {
                preIndex = i;
                continue;
            }
            String dir = path.substring(preIndex + 1, i);
            if (".".equals(dir)) {
                preIndex = i;
                continue;
            }
            if ("..".equals(dir)) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(dir);
            }
            preIndex = i;
        }
        return pathStack;
    }

    private String reconstructPath(Stack<String> pathStack) {
        String result = "";
        while (!pathStack.isEmpty()) {
            result = pathStack.pop() + ("".equals(result) ? "" : "/" + result);
        }
        return "/" + result;
    }

    public static void main(String[] args) {
        String path = "/a/../../b/../c//.//";
        path = new SimplifyPath().simplifyPath(path);
        System.out.println(path);
    }
}
