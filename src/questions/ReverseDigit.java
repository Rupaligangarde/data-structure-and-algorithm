package questions;

public class ReverseDigit {
    public static void main(String[] args) {

        System.out.println(reverseDigit(456));
    }

    private static int reverseDigit(int num) {
        int reverse_num = 0;

        while (num != 0) {
            int rem = num % 10;
            num = num / 10;
            reverse_num = reverse_num * 10 + rem;
        }

        return reverse_num;
    }
}
