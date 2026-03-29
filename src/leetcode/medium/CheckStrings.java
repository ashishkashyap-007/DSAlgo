package leetcode.medium;

/*
   LeetCode Problem: 2840. Check if Strings Can be Made Equal With Operations II
    https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/description/
 */

import java.util.Arrays;

public class CheckStrings {

    private boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        Arrays.fill(even, 0);
        Arrays.fill(odd, 0);

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckStrings checkStrings = new CheckStrings();
        System.out.println(checkStrings.checkStrings("abcd", "cdab"));
        System.out.println(checkStrings.checkStrings("abcd", "dacb"));
        System.out.println(checkStrings.checkStrings("abcd", "abdc"));

    }
}
