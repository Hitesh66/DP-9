//Time Complexity O(N Log N)
//Space Complexity O(N)
//Leetcode tested

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int n = envelopes.length;
        int len = 1;
        int[] arr = new int[n];
        arr[0] = envelopes[0][0];
        for (int i = 1; i < n; i++) {
            if (envelopes[i][0] > arr[len-1]){
                arr[len] = envelopes[i][0];
                len++;
            }else{
                int bsIndex = binarySearchNextBigger(arr,0,len-1,envelopes[i][0]);
                arr[bsIndex] = envelopes[i][0];
            }
        }
        return len;
    }
    private int binarySearchNextBigger(int[] arr,int low,int high,int target){
        while (low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid]<target){
                low = mid+1;
            }else high = mid-1;
        }
        return low;
    }
}
