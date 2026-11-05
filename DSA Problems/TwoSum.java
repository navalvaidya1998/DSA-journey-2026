import java.util.*;
public class TwoSum {
    /*
Day: 43
Problem: Two Sum

Approach: Brute Force

Idea:
Find all pairs of elements in the array whose sum is equal to the given target.
Use nested loops to check every possible pair.

How:
1. Initialize the outer loop from index 0 to arr.length-2 to select the first element.
2. Initialize the inner loop from i+1 to arr.length-1 to select the second element.
3. Calculate the sum of the elements at indices i and j.
4. If the sum equals the target, print both elements.
5. Continue checking all remaining pairs to find every possible match.

Time Complexity:
O(n²) - Nested loops check all possible pairs in the array.

Space Complexity:
O(1) - No additional data structure is used.

*/
    public static int[] bruteforce(int arr[],int target){
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j<arr.length;j++){
            if(target==arr[i]+arr[j]){
                return new int[]{i,j};
            }
        }
    }
    return new int[]{-1,-1};
}
/*
Problem: Two Sum

Approach: Optimal - HashMap

Idea:
Use a HashMap to store the elements we have already visited along with their indices.
For each element, calculate its complement (target - current element).
If the complement already exists in the HashMap, we have found the required pair.

How:
1. Create a HashMap to store array elements as keys and their indices as values.
2. Traverse the array using a loop.
3. Calculate the complement by subtracting the current element from the target.
4. Check whether the complement exists in the HashMap.
5. If it exists, return the stored index of the complement and the current index.
6. Otherwise, store the current element and its index in the HashMap.
7. If no pair is found, return {-1, -1}.

Time Complexity:
O(n) - We traverse the array once, and HashMap lookup and insertion take O(1) average time.

Space Complexity:
O(n) - The HashMap can store up to n elements.
*/
    public static int[] optimal(int arr[],int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement=target-arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int arr[]={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(bruteforce(arr,target)));
        System.out.println(Arrays.toString(optimal(arr,target)));
    }
}
