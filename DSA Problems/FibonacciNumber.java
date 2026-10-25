import java.util.*;
public class FibonacciNumber {
/*
 * Day 34 - Fibonacci Number
 *
 * Problem:
 * Given a number n, return the nth Fibonacci number.
 *
 * Fibonacci sequence:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)
 *
 * Example:
 * Input:  n = 7
 * Output: 13
 *
 * Approach: Iterative
 * -------------------
 * Instead of using recursion, we store only the previous two
 * Fibonacci numbers and calculate the next number iteratively.
 *
 * Steps:
 * 1. Handle the base cases n = 0 and n = 1.
 * 2. Initialize the first two Fibonacci numbers:
 *      first = 0
 *      second = 1
 * 3. Starting from the 2nd index, calculate the next Fibonacci number.
 * 4. Shift the values:
 *      first = second
 *      second = next
 * 5. Return the value stored in second.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Key Learning:
 * We don't need to store the complete Fibonacci sequence.
 * Only the previous two values are required to calculate the next value,
 * allowing us to solve the problem using constant extra space.
 */
    public static int fib(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        if(n<=1){
            return n;
        }
        int result = 0;
        for(int i=2; i<=n;i++){
            result = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = result;
        }
        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }
    
}
