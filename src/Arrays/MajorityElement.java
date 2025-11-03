package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Brute Force Approach
    private static int majorityElementBruteForce(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>n/2) return nums[i];
        }
        return -1;
    }

    // Better Approach using HashMap
    private static int majorityElementBetter(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            if(entry.getValue()>n/2) return entry.getKey();
        }
        return -1;
    }

    // Optimal Approach using Boyer-Moore Voting Algorithm
    private static int majorityElementOptimal(int[] nums) {
        int n = nums.length;

        int element=-1;
        int count=0;

        for(int num:nums){
            if(count==0){
                count=1;
                element=num;
            }
            else if(num==element) {
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("Majority Element : " + majorityElementBruteForce(nums));
        System.out.println("Majority Element : " + majorityElementBetter(nums));
        System.out.println("Majority Element : " + majorityElementOptimal(nums));
    }
}
