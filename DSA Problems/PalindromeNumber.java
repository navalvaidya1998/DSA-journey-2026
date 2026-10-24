import java.util.*;
public class PalindromeNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(bruteForce(n));

    }

/*
 * Day 33 - Palindrome Number
 *
 * Problem: Check whether a given integer is a palindrome.
 * A palindrome number reads the same forward and backward.
 *
 * 🔹 Approach 1: Brute Force (Reverse the Entire Number)
 * -------------------------------------------------------
 * Idea:
 * Reverse the complete number and compare it with the original number.
 *
 * How it works:
 * 1. Store the original number.
 * 2. Extract the last digit using num % 10.
 * 3. Build the reversed number using rev = rev * 10 + lastDigit.
 * 4. Remove the last digit using num /= 10.
 * 5. Compare the reversed number with the original number.
 *
 * Time Complexity: O(log10(n))
 * Space Complexity: O(1)
 *
 * Why this is not optimal:
 * The entire number is reversed, and the reversed integer may overflow
 * for sufficiently large inputs.
 */ 

    public static boolean bruteForce(int num){
        int originalNumber = num;
        int rev=0;
        while(num>0){
            int lastDigit = num%10;
            rev=rev*10+lastDigit;
            num/=10;
        }
        return originalNumber == rev;
    }

/* 🔹 Approach 2: Optimal (Reverse Half of the Number)
 * ----------------------------------------------------
 * Idea:
 * Reverse only the second half of the number and compare it with
 * the remaining first half.
 *
 * How it works:
 * 1. Handle negative numbers and numbers ending in zero (except zero itself).
 * 2. Extract the last digit and add it to the reversed half.
 * 3. Remove the last digit from the original number.
 * 4. Stop when the remaining half is less than or equal to the reversed half.
 * 5. For even-digit numbers, compare num == rev.
 * 6. For odd-digit numbers, ignore the middle digit using rev / 10.
 *
 * Time Complexity: O(log10(n))
 * Space Complexity: O(1)
 *
 * Why this is optimal:
 * Only approximately half of the digits are processed, reducing the
 * number of iterations and avoiding the need to reverse the entire number.
 *
 * 📌 Key Learning:
 * - Number reversal using % and / operators.
 * - Difference between brute-force and optimized approaches.
 * - Handling even and odd numbers of digits.
 * - Avoiding integer overflow by reversing only half the number.
 */
    public static boolean optimal(int num){
        int rev=0;
        while(num>rev){
            int lastDigit = num%10;
            rev=rev*10+lastDigit;
            num/=10;
        }
        return (num==rev || num==rev/10);
    }
}
