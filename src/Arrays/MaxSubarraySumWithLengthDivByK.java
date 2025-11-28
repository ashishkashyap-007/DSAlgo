package Arrays;

/*
   LeetCode problem 3381. Maximum Subarray Sum With Length Divisible by K
   https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/
*/

public class MaxSubarraySumWithLengthDivByK {

    //Brute Force Approach (O(n^2)) - Not efficient for large inputs
    private static long maxSubarraySumDivByKBrute(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long currSum = 0;
            int length = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                length++;
                if (length % k == 0) {
                    maxSum = Math.max(maxSum, currSum);
                }
            }
        }
        return maxSum;
    }

    //Better Approach using prefixSum (O(n^2)) time complexity and O(n) space complexity - still not optimal
    private static long maxSubarraySumDivByKBetter(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;
        long[] prefixSum = new long[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + k - 1; j < n; j += k) {
                long currSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    //Optimal Approach using prefixSum and kadane's algorithm (O(n) time complexity and O(k) space complexity)
    private static long maxSubarraySumDivByKOptimal(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long maxSum = Long.MIN_VALUE;

        for (int start = 0; start < k; start++) {
            long currSum = 0;
            int i = start;
            while (i < n && i + k - 1 < n) {
                int j = i + k - 1;
                long subSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                currSum = Math.max(subSum, currSum + subSum);
                maxSum = Math.max(maxSum, currSum);
                i += k;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 4;
        System.out.println(maxSubarraySumDivByKOptimal(nums, k));
    }


}
