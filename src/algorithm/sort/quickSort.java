package algorithm.sort;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 89, 10, 90, 100, 80};

        int low = 0;
        int length = arr.length;
        int high = length - 1;
        performQuickSort(arr, low, high);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void performQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = doPartition(arr, low, high);
            performQuickSort(arr, low, pivot - 1);
            performQuickSort(arr, pivot + 1, high);
        }
    }

    private static int doPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

/*
Time Complexity:
best case: O(nlogn)
average case: O(nlogn)
worst case: O(n*n)
*/
