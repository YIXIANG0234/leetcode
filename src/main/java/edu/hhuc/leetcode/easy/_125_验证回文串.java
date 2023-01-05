package edu.hhuc.leetcode.easy;

public class _125_验证回文串 {

    public static void main(String[] args) {
        _125_验证回文串 instance = new _125_验证回文串();
        System.out.println(instance.solution1("A man, a plan, a canal: Panama"));
    }

    /**
     * 如果第一个字符和最后一个字符相等，递归判断除第一个和最后一个字符以外的字串是否是回文串
     *
     * @param s
     * @return
     */
    public boolean solution1(String s) {
        s = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return recursive(s);
    }

    /**
     * 在原字符串的基础上判断
     *
     * @param s
     * @return
     */
    public boolean solution2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean recursive(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return recursive(s.substring(1, s.length() - 1));
        }
        return false;
    }
}