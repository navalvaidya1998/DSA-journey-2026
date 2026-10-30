import java.util.*;
public class TrappingRainWater {
    /*
Day 39
Problem: Trapping Rain Water
Approach: Auxiliary Arrays
Technique:
1. Create leftMax and rightMax arrays to store the maximum height
   from the left and right side of every index.
2. Build leftMax from left to right. For each index, store the
   maximum of the current height and the maximum height at the
   previous index.
3. Build rightMax from right to left using the same logic.
4. For every inner index, the water level is determined by the
   smaller of the maximum height on the left and the maximum
   height on the right.
5. Calculate the trapped water at each index using:
   min(leftMax[i], rightMax[i]) - arr[i]
6. Add the trapped water at every index to get the total amount.

Time Complexity: O(n)
Space Complexity: O(n)
*/
    public static void auxiliary(int arr[]){
        int len = arr.length;
        int sum = 0;
        int leftMax[]=new int[len];
        int rightMax[]=new int[len];
        leftMax[0]=arr[0];
        rightMax[len-1]=arr[len-1];
        for(int i=1;i<len;i++){
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        for(int i=len-2;i>=0;i--){
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        System.out.println(Arrays.toString(rightMax));
        for(int i=1; i<len-1; i++){
            sum=sum+(Math.min(leftMax[i],rightMax[i])-arr[i]);        
        }
        System.out.println(sum);
    }
    /*
Problem: Trapping Rain Water
Approach: Two Pointers
Technique:
1. Initialize two pointers, startInd and endInd, at the beginning and
   end of the array.
2. Maintain leftMaxHeight and rightMaxHeight to store the maximum
   height encountered from the left and right sides.
3. Compare the heights at startInd and endInd.
4. If arr[startInd] <= arr[endInd], process the left side because the
   left height is the limiting boundary.
5. Update leftMaxHeight if the current left height is greater.
   Otherwise, add leftMaxHeight - arr[startInd] to the total water.
6. If arr[startInd] > arr[endInd], process the right side similarly
   using rightMaxHeight.
7. Move the corresponding pointer inward after processing.
8. Continue until startInd and endInd meet.
9. The final value of water represents the total trapped rain water.

Time Complexity: O(n)
Space Complexity: O(1)
*/
    public static void optimal(int arr[]){
        int len=arr.length;
        int leftMaxHeight=0;
        int rightMaxHeight=0;
        int startInd=0;
        int endInd=len-1;
        int water=0;
        while(startInd<endInd){
            if(arr[startInd]<=arr[endInd]){
                if(leftMaxHeight<arr[startInd]){
                    leftMaxHeight=arr[startInd];
                }else{
                    water=water+leftMaxHeight-arr[startInd];
                }
                startInd++;
            }else{
                if(rightMaxHeight<arr[endInd]){
                    rightMaxHeight=arr[endInd];
                }else{
                    water=water+rightMaxHeight-arr[endInd];
                }
                endInd--;

            }
        }
        System.out.println(water);
    }
    public static void main(String args[]){
        int height[]={4,2,0,6,3,2,5};
        auxiliary(height);
        optimal(height);
    }
}
