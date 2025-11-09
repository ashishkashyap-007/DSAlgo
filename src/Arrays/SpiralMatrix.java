package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
   LeetCode Problem: 54. Spiral Matrix
   Link: https://leetcode.com/problems/spiral-matrix/
 */

public class SpiralMatrix {

    //Time Complexity: O(n*m) and Space auxiliary Complexity: O(1)
    private static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            //move left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //move top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //move right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                //move bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = spiralOrder(matrix);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
