public class SearchInRotatedSortedArray {
    /*
Day: 42
Problem: Search in Rotated Sorted Array
Approach: Modified Binary Search

Idea:
The array was originally sorted but then rotated at some point.
Because of the rotation, the complete array is not sorted, but at
every step, at least one half of the current search range will be sorted.

How:
1. Use Binary Search with start, end, and mid pointers.
2. If arr[mid] is equal to the target, return mid.
3. Check whether the left half is sorted:
   arr[start] <= arr[mid]
4. If the left half is sorted, check whether the target lies between
   arr[start] and arr[mid].
   - If yes, search in the left half.
   - If no, search in the right half.
5. If the left half is not sorted, the right half must be sorted.
6. Check whether the target lies between arr[mid] and arr[end].
   - If yes, search in the right half.
   - If no, search in the left half.
7. Continue until the target is found or start becomes greater than end.

Why does this work?
Even though the array is rotated, one of the two halves around mid
will always remain sorted. We can use that sorted half to determine
whether the target can exist there. This allows us to discard half
of the search space in every iteration, just like Binary Search.

Time Complexity: O(log n)
Space Complexity: O(1)
*/
    public static int optimal(int arr[], int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[start]<=arr[mid]){
                if(target<arr[mid]&& target>=arr[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(arr[mid]<target&&target<=arr[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[]={4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(optimal(arr,target));
    }
}
