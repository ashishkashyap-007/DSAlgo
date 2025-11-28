package Arrays;

/*
   LeetCode Problem 974: Subarray Sums Divisible by K
   https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivByK {

    // Brute Force Approach O(N^3) Time Complexity and O(1) Space Complexity
    private static int subarraysDivByKBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long currSum = 0;
                for (int m = i; m <= j; m++) {
                    currSum += nums[m];
                }
                if (currSum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    //Better Approach O(N^2) Time Complexity and O(1) Space Complexity
    private static int subarraysDivByKBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            long currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                if (currSum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal Approach O(N) Time Complexity and O(N) Space Complexity using HashMap
    private static int subarraysDivByKOptimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> modSumFreq = new HashMap<>();
        modSumFreq.put(0, 1); // For the case when the subarray itself is divisible by k
        long currSum = 0;

        for (int num : nums) {
            currSum += num;
            int rem = (int) currSum % k;
            if (rem < 0) {
                rem += k;
            }

            if (modSumFreq.containsKey(rem)) {
                count += modSumFreq.get(rem);
            }
            modSumFreq.put(rem, modSumFreq.getOrDefault(rem, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByKOptimal(nums, k));
    }


}
