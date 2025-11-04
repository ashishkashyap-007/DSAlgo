package Arrays;

import java.util.*;

/*
   LeetCode Problem 229: Majority Element II
   https://leetcode.com/problems/majority-element-ii/description/
 */

public class MajorityElement2 {
    private static List<Integer> getMajorityElementsBruteForce(int[] nums) {
        // Brute Force approach O(nlogn) time complexity and O(1) space complexity
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int element = nums[i];
            int count=1;

            while(i<n-1 && element == nums[i+1]) {
                count++;
                i++;
            }

            if(count>n/3) {
                res.add(element);
            }
        }
        return res;
    }

    private static List<Integer> getMajorityElementsBetter(int[] nums) {
        //using HashMap O(n) time complexity and O(n) space complexity
        int n = nums.length;
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()) {
            if(entry.getValue()>n/3) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    private static List<Integer> getMajorityElementsOptimal(int[] nums) {
        //using Boyer-Moore Voting Algorithm O(n) time complexity and O(1) space complexity
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for(int num:nums) {
            if(count1==0 && num!=element2){
                element1 = num;
                count1=1;
            }
            else if(count2==0 && num!=element1){
                element2 = num;
                count2=1;
            }
            else if(num==element1) {
                count1++;
            }
            else if(num==element2) {
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        int count_el1 = 0, count_el2 = 0;
        for(int num:nums) {
            if(num==element1) count_el1++;
            if(num==element2) count_el2++;
        }
        if(count_el1>n/3) res.add(element1);
        if(count_el2>n/3) res.add(element2);

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3, 2, 2};
        List<Integer> result = getMajorityElementsOptimal(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
