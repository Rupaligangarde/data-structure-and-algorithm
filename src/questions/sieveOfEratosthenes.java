package questions;

public class sieveOfEratosthenes {
    public static void main(String[] args) {

        int limit = 10;

        for (int i = 2; i <= limit; i++) {
            int flag = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(i);
            }
        }
    }
}
