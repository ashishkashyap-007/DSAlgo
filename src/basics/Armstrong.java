package basics;

public class Armstrong {

    private boolean isArmstrong(int num) {
        int sum = 0;
        int numOfDigits = (int) Math.log10(num) + 1;
        int temp = num;

        while (temp > 0) {
            int lastDigit = temp % 10;
            sum += (int) Math.pow(lastDigit, numOfDigits);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        int num = 153;
        Armstrong armstrong = new Armstrong();
        if (armstrong.isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }

}
