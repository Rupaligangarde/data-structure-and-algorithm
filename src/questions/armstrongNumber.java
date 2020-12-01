package questions;

public class armstrongNumber {
    public static void main(String[] args) {

        int number = 153;
        int numberCopy = number;

        int noOfDigits = 0;
        while (number != 0) {
            number = number / 10;
            noOfDigits++;
        }

        number = numberCopy;
        int sum = 0;
        while (number != 0) {
            int rem = number % 10;
            int power = power(rem, noOfDigits);
            sum += power;
            number = number / 10;
        }

        boolean isArmStrong = numberCopy == sum;
        System.out.println(isArmStrong);
    }

    private static int power(int number1, int number2) {

        int result = 1;
        while (number2 > 0) {
            result = result * number1;
            number2--;
        }
        return result;
    }
}
