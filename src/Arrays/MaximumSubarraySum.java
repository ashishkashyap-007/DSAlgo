package Arrays;

/*
   LeetCode Problem 53: Maximum Subarray
   https://leetcode.com/problems/maximum-subarray/description/
 */

public class MaximumSubarraySum {

    //Brute Force Approach: O(n^2) time complexity and O(1) space complexity
    //will give TLE for large inputs
    private static int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }

    //Optimal Approach: Kadane's Algorithm: O(n) time complexity and O(1) space complexity
    private static int maxSubArrayOptimal(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArrayOptimal(nums));
    }

}
