import java.util.*;
public class FizzBuzz {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution1(n);
        solution2(n);
    }
/*
 * Day 31 - Fizz Buzz
 *
 * 🔹 Approach 1: Iteration + Conditional Checks using modulo
 * -----------------------------------------------------------
 *
 * Idea:
 * - Iterate through every number from 1 to n
 * - Check whether each number is divisible by 3, 5, or both
 * - Store the corresponding result in a List<String>
 *
 * How it works:
 * - Create an empty List<String> to store the results
 *
 * - Iterate from i = 1 to i = n
 *
 * - If i is divisible by both 3 and 5:
 *     → Add "FizzBuzz"
 *
 * - Else if i is divisible by 5:
 *     → Add "Buzz"
 *
 * - Else if i is divisible by 3:
 *     → Add "Fizz"
 *
 * - Otherwise:
 *     → Convert i to String and add it to the list
 *
 * - Return the result list
 *
 * Important:
 * - Check divisibility by both 3 and 5 first
 * - Otherwise, numbers such as 15 would match
 *   the condition for 3 or 5 before reaching FizzBuzz
 *
 * Time Complexity:
 * - O(n)
 * - Each number from 1 to n is checked once
 *
 * Space Complexity:
 * - O(n)
 * - The result list stores n strings
 *
 * Why this is a brute-force approach:
 * - Every number is checked individually
 * - No mathematical shortcut or precomputation is used
 * - This is already an optimal asymptotic solution
 *   for producing all n required outputs
 */
    
    public static void solution1(int n){
        for(int i=1;i<=n;i++){
            if(i%15==0){
                System.out.println("FizzBuzz");
            }else if(i%5==0){
                System.out.println("Buzz");
            }else if(i%3==0){
                System.out.println("Fizz");
            }else{
                System.out.println(i);
            }
            
        }
    }


/*
 * Approach 2: Counter-Based Approach (Without Modulo)
 *
 * Idea:
 * Instead of using the modulo operator (%) to check divisibility by 3 and 5,
 * we maintain two counters:
 * - fizzCounter: Tracks numbers for the Fizz condition (every 3 numbers).
 * - buzzCounter: Tracks numbers for the Buzz condition (every 5 numbers).
 *
 * How it works:
 * 1. Initialize both counters to 0.
 * 2. For every number from 1 to n, increment both counters.
 * 3. If fizzCounter == 3 and buzzCounter == 5:
 *    - Print "FizzBuzz".
 *    - Reset both counters to 0.
 * 4. Else if buzzCounter == 5:
 *    - Print "Buzz".
 *    - Reset buzzCounter to 0.
 * 5. Else if fizzCounter == 3:
 *    - Print "Fizz".
 *    - Reset fizzCounter to 0.
 * 6. Otherwise, print the current number.
 *
 * Why check FizzBuzz first?
 * A number divisible by both 3 and 5 must print "FizzBuzz".
 * Therefore, we check both counter conditions before checking them individually.
 *
 * Time Complexity: O(n)
 * - The loop executes n times, and each iteration performs a constant
 *   amount of work.
 *
 * Space Complexity: O(1)
 * - Only two integer counters are used, regardless of the value of n.
 *
 * Note:
 * This approach avoids the modulo operator, but it does not improve the
 * time complexity compared to the modulo-based approach.
 */

    public static void solution2(int n){
        int fizzCounter = 0;
        int buzzCounter = 0;
        for(int i=1;i<=n;i++){
            fizzCounter++;
            buzzCounter++;
            if(fizzCounter == 3 && buzzCounter == 5){
                System.out.println("FizzBuzz");
                fizzCounter=0;
                buzzCounter=0;
            }else if(buzzCounter == 5){
                System.out.println("Buzz");
                buzzCounter=0;
            }
            else if(fizzCounter == 3){
                System.out.println("Fizz");
                fizzCounter=0;
            }else{
                System.out.println(i);
            }
        }
    }  
}
