import java.util.*;
public class ReverseString {
/*
 * Day 36: Reverse String
 *
 * Problem:
 * Reverse the given character array in-place.
 *
 * Approach:
 * 1. Use two pointers: start at the beginning and end at the last index.
 * 2. Swap the characters at start and end.
 * 3. Move start one step forward and end one step backward.
 * 4. Continue until the two pointers meet.
 *
 * Technique:
 * Two Pointers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * The array is reversed in-place without creating another array.
 */
    public static void main(String args[]){
        char arr[] = {'H','a','p','p','y'};
        reverseArray(arr);
    }
    public static void reverseArray(char arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.print(Arrays.toString(arr));
    }
}
