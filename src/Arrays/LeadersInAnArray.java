package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Leaders in an Array
    Problem Link: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
 */

public class LeadersInAnArray {

    // Brute Force Approach O(n^2) time complexity and O(1) space complexity
    private static List<Integer> getLeadersBruteForce(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++) {
            boolean isLeader = true;
            for(int j=i+1;j<n;j++) {
                if(nums[j]>=nums[i]) {
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    // Optimal Approach O(n) time complexity and O(1) space complexity
    private static List<Integer> getLeadersInAnArray(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int currentLeader = nums[n-1];
        res.add(currentLeader);

        for(int i=n-2;i>=0;i--) {
            if(nums[i]>nums[i+1] && nums[i]>currentLeader) {
                currentLeader = nums[i];
                res.add(currentLeader);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> res = getLeadersInAnArray(arr);
        Collections.reverse(res);
        System.out.println(res);
    }
}
