package Arrays;

import java.util.*;

/*
   LeetCode Problem 18: 4Sum
   https://leetcode.com/problems/4sum/description/
*/
public class FourSum {

    //Brute Force Approach: O(n^4) time complexity and O(m) space complexity
    private static List<List<Integer>> fourSumBrute(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[k]);
                            quad.add(nums[l]);
                            quad.sort(Integer::compareTo);
                            ans.add(quad);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    //Better Approach: O(n^3) time complexity and O(m) space complexity
    private static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                Set<Long> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long complement = (long) target - sum;
                    if (seen.contains(complement)) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add((int) complement);
                        quad.sort(Integer::compareTo);
                        ans.add(quad);
                    } else {
                        seen.add((long) nums[k]);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    //Optimal Approach: O(n^3) time complexity and O(1) space complexity with sorting and two pointers technique
    private static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) return new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicates for i

            long minPossibleI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minPossibleI > target) break; //break since further values will only be larger
            long maxPossibleI = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxPossibleI < target) continue; //continue to next i since current i is small

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //skip duplicates for j

                long minPossibleJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minPossibleJ > target) break; //break since further values will only be larger

                long maxPossibleJ = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxPossibleJ < target) continue; //continue to next j since current j is small

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        //skip duplicates for left and right
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSumOptimal(nums, target));
    }


}
