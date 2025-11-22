package Arrays;

import java.util.Arrays;

/*
   LeetCode Problem 75: Sort Colors
   https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

    //Brute Force Approach: Using inbuilt sort function
    // Time Complexity: O(n log n) and Space Complexity: O(1)
    private static void sortColorsBrute(int[] nums) {
        Arrays.sort(nums);
    }

    //Better Approach: Counting Sort
    // Time Complexity: O(2*n) and Space Complexity: O(1)
    private static void sortColorsBetter(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else if (num == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }

        int index = 0;
        while (zeroCount > 0) {
            nums[index++] = 0;
            zeroCount--;
        }

        while (oneCount > 0) {
            nums[index++] = 1;
            oneCount--;
        }

        while (twoCount > 0) {
            nums[index++] = 2;
            twoCount--;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //Optimal Approach: Dutch National Flag Algorithm
    // Time Complexity: O(n) and Space Complexity: O(1)
    private static void sortColorsOptimal(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, k = n - 1;

        while (j <= k) {
            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColorsOptimal(nums);
        for (int color : nums) {
            System.out.print(color + " ");
        }
    }

}
