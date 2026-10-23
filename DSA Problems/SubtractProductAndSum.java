import java.util.*;
public class SubtractProductAndSum{
/*
 * Day 32 - Subtract the Product and Sum of Digits of an Integer
 *
 * Problem:
 * Given an integer n, calculate the difference between the product
 * of its digits and the sum of its digits.
 *
 * Approach: Mathematical Digit Manipulation
 *
 * Idea:
 * Extract each digit using the modulo operator (% 10) and remove
 * the last digit using integer division (/ 10).
 * Calculate the sum and product of all digits in a single loop.
 *
 * Example:
 * Input: 234
 *
 * Product = 2 * 3 * 4 = 24
 * Sum = 2 + 3 + 4 = 9
 *
 * Output: 24 - 9 = 15
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int prod = 1;
        while(n>0){
            int lastnumber=n%10;
            sum=sum+lastnumber;
            prod=prod*lastnumber;
            n=n/10;
        }
        int result = prod-sum;
        System.out.println("Result is : "+result);
    }
}