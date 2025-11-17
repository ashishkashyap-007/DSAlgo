package Arrays;

import java.util.*;

/*
   LeetCode Problem 15: 3Sum
   https://leetcode.com/problems/3sum/
*/

public class ThreeSum {

    //Brute Force Approach
    // Time Complexity: O(n^3) and Space Complexity: O(1)
    private static List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    //Better Approach using HashSet and HashMap
    // Time Complexity: O(n^2) and Space Complexity: O(n)
    public static List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -(nums[i] + nums[j]);
                if (map.containsKey(complement)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(complement);
                    Collections.sort(triplet);
                    result.add(triplet);
                } else {
                    map.put(nums[j], j);
                }
            }
        }

        return new ArrayList<>(result);
    }

    // Optimal Approach using Two Pointers and Sorting
    // Time Complexity: O(n^2) + O(nlog n) and Space Complexity: O(log n) due to sorting, depending on the sorting algorithm implementation.
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicates for i
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++; //skip duplicates for left
                    while (left < right && nums[right] == nums[right + 1]) right--; //skip duplicates for right
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumOptimal(nums));
    }


}
