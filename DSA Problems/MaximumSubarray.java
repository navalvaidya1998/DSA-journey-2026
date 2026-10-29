import java.util.*;
public class MaximumSubarray {

    /*
Day 38
Problem: Maximum Subarray
Approach: Brute Force
Algorithm:
1. Initialize maxSum with the first array element to handle all-negative arrays.
2. Use the outer loop (i) to select the starting index of a subarray.
3. Use the middle loop (j) to select the ending index of the subarray.
4. Initialize currSum to 0 for each new subarray.
5. Use the inner loop (k) to calculate the sum of elements from index i to j.
6. Update maxSum by comparing it with each calculated subarray sum.
7. Print maxSum after checking all possible subarrays.
Time Complexity: O(n^3)
Space Complexity: O(1)
*/
    public static void bruteforce(int arr[]){
        int maxSum = arr[0];
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int currSum=0;
                for(int k=i; k<=j; k++){
                    currSum = currSum+arr[k];
                }
                maxSum=Math.max(currSum,maxSum);
            }
        }
        System.out.println(maxSum);
    }

    /*
Problem: Maximum Subarray
Approach: Prefix Sum
Technique:
1. Build a prefix sum array where each element stores the sum of all
   elements from index 0 up to the current index.
2. Use two loops to generate every possible subarray using i as the
   starting index and j as the ending index.
3. If i is 0, the subarray sum is directly prefixArr[j].
4. Otherwise, subtract prefixArr[i-1] from prefixArr[j] to remove the
   elements before the starting index i.
5. Compare each subarray sum with maxSum and keep the maximum value.

Time Complexity: O(n^2)
Space Complexity: O(n)
*/
    public static void optimal_prefix(int arr[]){
        int prefixArr[]=new int[arr.length];
        int maxSum = arr[0];
        prefixArr[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixArr[i]=prefixArr[i-1]+arr[i];
        }
        System.out.println(Arrays.toString(prefixArr));
        for(int i=0;i<prefixArr.length;i++){
            int currSum=0;
            for(int j=i;j<prefixArr.length;j++){
                if(i==0){
                    currSum=prefixArr[j];
                }else{
                    currSum=prefixArr[j]-prefixArr[i-1];
                }
                maxSum = Math.max(maxSum,currSum);
            }
        }
        System.out.println(maxSum);
    }

    /*
Problem: Maximum Subarray
Approach: Kadane's Algorithm
Technique:
1. Initialize currSum and maxSum with the first array element.
2. Traverse the array from the second element.
3. At each index, decide whether to start a new subarray from arr[i]
   or extend the previous subarray by adding arr[i] to currSum.
4. Store the larger of these two choices in currSum.
5. Compare currSum with maxSum and update maxSum if currSum is larger.
6. After traversing the complete array, maxSum contains the maximum
   sum of any contiguous subarray.

Time Complexity: O(n)
Space Complexity: O(1)
*/
    public static void optimal_kadanes(int arr[]){
        int maxSum=arr[0];
        int currSum=arr[0];
        for(int i=1;i<arr.length;i++){
            currSum=Math.max(arr[i],currSum+arr[i]);
            maxSum=Math.max(currSum,maxSum);
        }
        System.out.println(maxSum);
    }
    public static void main(String args[]){
        int arrNum[] = {-1,-2,-6,-1,-3};
        int arrNum1[] = {1,-2,6,-1,3};
        int arrNum2[] = {10,20,30,40};
        optimal_kadanes(arrNum1);
    }
}
