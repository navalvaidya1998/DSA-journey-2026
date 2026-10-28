import java.util.*;
public class PascalsTriangle{
    /*
 * Day 37: Pascal's Triangle
 * Approach: Brute Force
 * 
 * Problem:Generate the first n rows of Pascal's Triangle.
 *
 * 1. Iterate through each row from 0 to n-1.
 * 2. Iterate through each column from 0 to the current row number.
 * 3. Calculate each element using the combination formula:
 *    nCr = n! / (r! * (n-r)!)
 * 4. Calculate factorials using a separate factorial method.
 * 5. Print each element and move to the next row.
 *
 * Technique:
 * Combinatorics, Nested Loops
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(1) auxiliary space
 */
    public static void bruteForce(int n){
        for(int row=0;row<n;row++){
            for(int col=0;col<=row;col++){
                System.out.print(factorial(row)/(factorial(col)*factorial(row-col)) +" ");
            }
            System.out.println();
        }
    }
    public static int factorial(int n){
        int fact = 1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
/*
 * Approach: Optimal (Mathematical Formula)
 *
 * Problem:
 * Generate the first n rows of Pascal's Triangle.
 *
 * Technique:
 * Combinatorics, Mathematical Formula, Nested Loops
 *
 * Logic:
 * 1. Iterate through each row from 0 to n-1.
 * 2. Initialize val = 1 at the beginning of each row.
 * 3. Iterate through each column from 0 to the current row index.
 * 4. Print the current value.
 * 5. Calculate the next value using:
 *    val = val * (row - col) / (col + 1)
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) auxiliary space
 */
    public static void optimal(int n){
        for(int row=0;row<n;row++){
            int val=1;
            for(int col=0;col<=row;col++){
                System.out.print(val+" ");
                val=(val*(row-col))/(col+1);
            }
            System.out.println();
        }
        
    }

/*
 Approach: Optimal Approach (Previous Row)
 *
 * Problem:
 * Generate the first n rows of Pascal's Triangle.
 *
 * Technique:
 * Nested Lists
 *
 * Logic:
 * 1. Create a list to store all rows of Pascal's Triangle.
 * 2. Iterate through each row and create a list for the current row.
 * 3. Add 1 at the first and last positions of each row.
 * 4. Calculate middle elements by adding the two adjacent elements
 *    from the previous row.
 * 5. Add the current row to the main list.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
    public static void optimal2(int n){
        List<List<Integer>> arrList = new ArrayList<>();
        for(int row=0; row<n; row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col=0; col<=row; col++){
                if(col==0 || col==row){
                    currRow.add(1);
                }else{
                    currRow.add(arrList.get(row-1).get(col-1)+arrList.get(row-1).get(col));
                }
            }
            arrList.add(currRow);
        }
        System.out.println(arrList);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        optimal2(n);
    }
}