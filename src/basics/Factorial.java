package basics;

public class Factorial {

    // Time Complexity: O(n) and Space Complexity: O(1)
    private int getFactorialIterative(int n) {
        if (n == 0 || n == 1) return 1;
        int res = 1;

        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    // Time Complexity: O(n) and Space Complexity: O(n)
    private int getFactorialRecursive(int n) {
        if (n == 0 || n == 1) return 1;

        return n * getFactorialIterative(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        Factorial factorial = new Factorial();
        System.out.println("Factorial of " + n + " is: " + factorial.getFactorialIterative(n));
        System.out.println("Factorial of " + n + " is: " + factorial.getFactorialRecursive(n));
    }

}
