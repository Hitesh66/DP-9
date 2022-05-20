//Time Complexity O(N Log N)
//Space Complexity O(N)
//Leetcode tested

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int len =1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            }else{
                int bsIndex = binarySearchNextBigger(arr,0,len-1,nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len;
    }
    private int binarySearchNextBigger(int[] arr,int low,int high,int target){
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid]<=target){
                low = mid+1;
            }else high = mid-1;
        }
        return low;
    }
}
