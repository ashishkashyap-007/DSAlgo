package Arrays;

/*
   LeetCode Problem 1749: Maximum Absolute Sum of Any Subarray
   https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/
 */
public class MaxAbsoluteSum {

    //Brute Force Approach O(n^2) Time Complexity and O(1) Space Complexity
    // will give TLE for large inputs
    private static int maxAbsoluteSumBrute(int[] nums) {
        int n = nums.length;
        int maxAbsSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxAbsSum = Math.max(Math.abs(currentSum), maxAbsSum);
            }
        }
        return maxAbsSum;
    }

    //Better Approach O(2n) Time Complexity and O(1) Space Complexity
    // Two pass Kadane's Algorithm to find max subarray sum and min subarray sum
    private static int maxAbsoluteSumBetter(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        //find max subarray sum
        int currentMax = 0;
        for (int num : nums) {
            currentMax += num;
            maxSum = Math.max(currentMax, maxSum);
            if (currentMax < 0) {
                currentMax = 0;
            }
        }

        //find min subarray sum
        int currentMin = 0;
        for (int num : nums) {
            currentMin += num;
            minSum = Math.min(currentMin, minSum);
            if (currentMin > 0) {
                currentMin = 0;
            }
        }

        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }

    //Optimized Approach O(n) Time Complexity and O(1) Space Complexity
    // Single pass Kadane's Algorithm to find max subarray sum and min subarray sum
    private static int maxAbsoluteSumOptimized(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            //find max subarray sum
            currentMax += num;
            maxSum = Math.max(currentMax, maxSum);
            if (currentMax < 0) {
                currentMax = 0;
            }
            //find min subarray sum
            currentMin += num;
            minSum = Math.min(currentMin, minSum);
            if (currentMin > 0) {
                currentMin = 0;
            }
        }
        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }

    public static void main(String[] args) {
        int[] nums = {2, -5, 1, -4, 3, -2};
        System.out.println("Maximum Absolute Sum of Any Subarray: " + maxAbsoluteSumOptimized(nums));
    }

}
