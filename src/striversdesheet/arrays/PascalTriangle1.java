package striversdesheet.arrays;

/*
   LeetCode Link: https://leetcode.com/problems/pascals-triangle/
   Striver's SDE Sheet Link: https://takeuforward.org/data-structure/pascal-triangle/
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle1 {

    // Time Complexity: O(r^2) where r is the number of rows in the Pascal's triangle.
    // Space Complexity: O(r^2) where r is the number of rows in the Pascal's triangle.
    private static List<List<Integer>> generatePascalTriangle(int r) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < r; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int col = i - 1;
            for (int j = 1; j <= col; j++) {
                int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.add(sum);
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    //optimal approach to get the value at r, c in pascal triangle is to use the formula nCr = n! / (r! * (n - r)!)
    // Time Complexity: O(r) where r is the value of r in nCr.
    // Space Complexity: O(1)
    private static int getPascalValue(int n, int r) {
        int res = 1;

        if (r == 1) {
            return n;
        }

        if (n > n - r) {
            r = n - r;
        }

        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int r = 5, c = 2;
        List<List<Integer>> pascalTriangle = generatePascalTriangle(r);

        System.out.println(pascalTriangle.get(r - 1).get(c - 1));

        System.out.println(getPascalValue(r - 1, c - 1));
    }
}
