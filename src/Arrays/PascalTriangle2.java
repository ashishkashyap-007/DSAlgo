package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    LeetCode Problem 119: Pascal's Triangle II
    https://leetcode.com/problems/pascals-triangle-ii/description/
*/

public class PascalTriangle2 {

    // Helper function to generate Pascal's Triangle up to numRows
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(List.of(1));
        int rowIndex = 1;

        while (rowIndex <= numRows) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int colIndex = 1;

            while (colIndex < rowIndex) {
                List<Integer> prevRow = pascal.get(rowIndex - 1);
                row.add(prevRow.get(colIndex - 1) + prevRow.get(colIndex));
                colIndex++;
            }

            row.add(1);
            pascal.add(row);
            rowIndex++;
        }
        return pascal;
    }

    //Brute Force approach
    // Time Complexity: O(n^2) and Space Complexity: O(n^2)
    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        List<List<Integer>> pascalTriangle = generate(rowIndex);
        return pascalTriangle.get(rowIndex);
    }

    // Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
    // Time Complexity: O(n^2) and Space Complexity: O(n)
    private static List<Integer> getRowOptimized(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        int rowNum = 1;
        while (rowNum <= rowIndex) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            int colNum = 1;

            while (colNum < rowNum) {
                curr.add(prev.get(colNum) + prev.get(colNum - 1));
                colNum++;
            }

            curr.add(1);
            prev = curr;
            rowNum++;
        }
        return prev;
    }

    public static void main(String[] args) {
        int rowIndex = 7;
        List<Integer> ans = getRowOptimized(rowIndex);

        System.out.println(Arrays.toString(ans.toArray()));
    }
}
