package questions;

import java.util.Arrays;

public class EggDrop {

    public static void main(String[] args) {
        int noOfEggDrops = superEggDrop(2, 10);

        System.out.println(noOfEggDrops);

    }

    public static int superEggDrop(int K, int N) {
        int dp[] = new int[K + 1], m = 0;
        for (m = 0; dp[K] < N; m++)
            for (int k = K; k > 0; k--)
                dp[k] += dp[k - 1] + 1;
        return m;
    }
}
