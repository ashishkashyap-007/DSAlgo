package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
    LeetCode Problem 1: Two Sum
    https://leetcode.com/problems/two-sum/
*/

public class TwoSum {

    //Brute Force Approach
    // Time Complexity: O(n^2) and Space Complexity: O(1)
    private static int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        for (int i = 0; i < n - 1; i++) {
            int firstNum = nums[i];
            for (int j = i + 1; j < n; j++) {
                int secondNum = nums[j];
                if (firstNum + secondNum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;
    }

    //Optimized Approach using HashMap
    // Time Complexity: O(n) and Space Complexity: O(n)
    private static int[] twoSumOptimized(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            int firstNum = nums[i];
            int requiredNum = target - firstNum;
            if (map.containsKey(requiredNum)) {
                int j = map.get(requiredNum);
                ans[0] = i;
                ans[1] = j;
                break;
            }
            map.put(firstNum, i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumOptimized(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);

    }

}
