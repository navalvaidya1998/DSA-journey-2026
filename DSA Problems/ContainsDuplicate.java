import java.util.*;
public class ContainsDuplicate {
    /*
Day 41
Problem: Contains Duplicate
Approach: Brute Force
Technique:
1. Use the outer loop (i) to select each element of the array.
2. Use the inner loop (j) to compare the selected element with every
   element that appears after it.
3. Start j from i + 1 to avoid comparing an element with itself and
   to avoid checking the same pair multiple times.
4. If arr[i] and arr[j] are equal, a duplicate exists, so return true.
5. If all possible pairs are checked without finding a duplicate,
   return false.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
    public static boolean bruteforce(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /*
Problem: Contains Duplicate
Approach: HashSet
Technique:
1. Create a HashSet to store the elements that have already been seen.
2. Traverse the array from the first element.
3. For each element, check whether it already exists in the HashSet.
4. If the element is already present, a duplicate has been found,
   so return true.
5. If the element is not present, add it to the HashSet.
6. If the complete array is traversed without finding a duplicate,
   return false.

Time Complexity: O(n) Average
Space Complexity: O(n)
*/
    public static boolean optimal(int arr[]){
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
    public static void  main(String args[]){
        int arr[]={1,3,4,2,1};
        System.out.println(bruteforce(arr));

    }
}
