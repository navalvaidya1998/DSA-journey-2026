import java.util.*;
public class BinarySearch{
    
/*
 * Day 35: Binary Search
 *
 * Problem: Search for a target element in a sorted array.
 *
 * Approach:
 * 1. Initialize start = 0 and end = arr.length - 1.
 * 2. Calculate the middle index using:
 *    mid = start + (end - start) / 2
 * 3. If arr[mid] equals the target, return mid.
 * 4. If the target is greater than arr[mid], search the right half.
 * 5. If the target is smaller than arr[mid], search the left half.
 * 6. Repeat until the target is found or start exceeds end.
 * 7. Return -1 if the target is not present.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Note: The input array must already be sorted in ascending order.
 */

    public static void main(String args[]){
        int arr[] = {2,8,4,5,1,9,6};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = binarySearch(n,arr);
        System.out.println(result!=-1?result:"Not found");
    }
    public static int binarySearch(int n, int arr[]){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(n==arr[mid]){
                return mid;
            }
            if(n>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}