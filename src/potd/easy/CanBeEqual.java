package potd.easy;

/*
   LeetCode problem: 2839. Check if Strings Can be Made Equal With Operations I
   https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/?envType=daily-question&envId=2026-03-29
 */

import java.util.Arrays;

public class CanBeEqual {

    private boolean canBeEqual(String s1, String s2) {
        //index 0 and 2
        boolean c1 = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        //index 1 and 3
        boolean c2 = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return c1 && c2;
    }

    private boolean canBeEqualAppraoch2(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];

        Arrays.fill(even, 0);
        Arrays.fill(odd, 0);

        for (int i = 0; i < 4; i++) {
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
        CanBeEqual canBeEqual = new CanBeEqual();
        System.out.println(canBeEqual.canBeEqual("abcd", "cdab"));
        System.out.println(canBeEqual.canBeEqual("abcd", "dacb"));
        System.out.println(canBeEqual.canBeEqual("abcd", "abdc"));

        System.out.println(canBeEqual.canBeEqualAppraoch2("abcd", "cdab"));
        System.out.println(canBeEqual.canBeEqualAppraoch2("abcd", "dacb"));
        System.out.println(canBeEqual.canBeEqualAppraoch2("abcd", "abdc"));
    }
}
