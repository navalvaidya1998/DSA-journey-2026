public class BestTimetoBuyandSellStock {

    /*
Day 40
Problem: Best Time to Buy and Sell Stock
Approach: Brute Force
Technique:
1. Initialize maxProfit as 0 because if no profitable transaction is
   possible, the maximum profit should remain 0.
2. Use the outer loop (i) to select each possible buying day.
3. Store the buying price in currentBuy.
4. Use the inner loop (j) to check every possible selling day after
   the selected buying day.
5. Calculate the profit by subtracting the buying price from the
   selling price.
6. Update maxProfit if the current profit is greater than the
   previously calculated maximum profit.
7. After checking all possible buy and sell combinations, print
   maxProfit.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
    public static void bruteforce(int arr[]){
        int maxProfit=0;
        for(int i=0;i<arr.length;i++){
            int currentBuy=arr[i];
            for(int j=i+1;j<arr.length;j++){
                int currentSell = arr[j];
                maxProfit=Math.max(currentSell-currentBuy,maxProfit);
            }

        }
        System.out.println(maxProfit);
    }

    /*
Problem: Best Time to Buy and Sell Stock
Approach: Optimal
Technique:
1. Initialize minPrice with the first element because it represents
   the lowest buying price seen so far.
2. Initialize maxProfit as 0 because we cannot have negative profit.
3. Traverse the array from the second element.
4. If the current price is greater than minPrice, calculate the
   possible profit by subtracting minPrice from the current price.
5. Update maxProfit if the current profit is greater than the
   previously recorded maximum profit.
6. If the current price is lower than minPrice, update minPrice
   because it is a better price to buy the stock.
7. After traversing the array, maxProfit contains the maximum
   possible profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/
    public static void optimal(int arr[]){
        int minPrice=arr[0];
        int maxProfit=0;
        for(int i=1;i<arr.length;i++){
            if(minPrice<arr[i]){
                maxProfit=Math.max(maxProfit,arr[i]-minPrice);
            }else{
                minPrice=arr[i];
            }
        }
        System.out.println(maxProfit);

    }
    public static void main(String args[]){
        int price[]={7,1,5,3,6,4};
        bruteforce(price);
        optimal(price);
    }
}
