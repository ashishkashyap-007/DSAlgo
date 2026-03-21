package potd;

/*
    LeetCode problem Link: https://leetcode.com/problems/flip-square-submatrix-vertically/?envType=daily-question&envId=2026-03-21
    3643. Flip Square Submatrix Vertically
 */

public class ReverseSubmatrix {
    private static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int r1 = x + i;
            int r2 = (x + k - 1) - i;
            for (int j = y; j < y + k; j++) {
                int temp = grid[r1][j];
                grid[r1][j] = grid[r2][j];
                grid[r2][j] = temp;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2;
        int x = 0;
        int y = 0;
        int[][] result = reverseSubmatrix(matrix, x, y, k);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


}
