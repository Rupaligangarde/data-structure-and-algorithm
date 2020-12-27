package algorithm.sort;

public class insertionSort {
    public static void main(String[] args) {

        int n = 3;

        int[] a = {3, 1, 2};

        for (int i: a)
            System.out.println(i);

        for (int i = 0; i < n - 1; i = i + 1) {
            for (int j = n - 1; j != i; j = j - 1) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println("==============");
        for (int i: a)
            System.out.println(i);
    }
}
