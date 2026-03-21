package basics;

public class PerfectNumber {
    private boolean isPerfect(int num) {
        int sum = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        int n = 6;
        PerfectNumber perfectNumber = new PerfectNumber();
        if (perfectNumber.isPerfect(n)) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
    }
}
