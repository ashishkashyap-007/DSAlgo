package Arrays;

/*
   LeetCode Problem 118: Pascal's Triangle
   https://leetcode.com/problems/pascals-triangle/description/
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle1 {

    // Time Complexity: O(numRows^2) and Space Complexity: O(numRows^2)
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        int rowIndex=1;

        while(rowIndex<numRows) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            int colIndex=1;

            while(colIndex<rowIndex) {
                List<Integer> prevRow = result.get(rowIndex-1);
                currRow.add(prevRow.get(colIndex-1) + prevRow.get(colIndex));
                colIndex++;
            }

            currRow.add(1);
            result.add(currRow);
            rowIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 10;
        System.out.println(generate(numRows));
    }
}
