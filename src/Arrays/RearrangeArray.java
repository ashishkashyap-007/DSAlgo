package Arrays;
/*
    LeetCode problem: 2149. Rearrange Array Elements by Sign
    Problem Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {

    //Brute force approach O(2*n) time complexity and O(n) space complexity
    private static int[] rearrangeArrayBruteForce(int[] nums) {
        int n = nums.length;
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        int[] res = new int[n];

        for (int num : nums) {
            if (num > 0) {
                positiveList.add(num);
            } else {
                negativeList.add(num);
            }
        }

        int index = 0;
        for (int i = 0, j = 0; i < positiveList.size() && j < negativeList.size(); i++, j++) {
            res[index++] = positiveList.get(i);
            res[index++] = negativeList.get(j);
        }
        return res;
    }

    //Optimal approach O(n) time complexity and O(1) auxiliary space complexity
    private static int[] rearrangeArrayOptimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int positiveNumber = 0;
        int negativeNumber = 0;
        int index = 0;

        while (positiveNumber < n && negativeNumber < n) {
            while (positiveNumber < n && nums[positiveNumber] < 0) {
                positiveNumber++;
            }
            if (positiveNumber < n && nums[positiveNumber] > 0) {
                res[index++] = nums[positiveNumber++];
            }

            while (negativeNumber < n && nums[negativeNumber] > 0) {
                negativeNumber++;
            }

            if (negativeNumber < n && nums[negativeNumber] < 0) {
                res[index++] = nums[negativeNumber++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, -3, -4, 2, 3};
        int[] res = rearrangeArrayOptimal(arr);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }
}
