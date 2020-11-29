package algorithm.sort;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 89, 10, 90, 100, 80};

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        performMergeSort(arr, leftIndex, rightIndex);


        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void performMergeSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            performMergeSort(arr, leftIndex, mid);
            performMergeSort(arr, mid + 1, rightIndex);
            merge(arr, leftIndex, rightIndex, mid);
        }


    }

    private static void merge(int[] arr, int leftIndex, int rightIndex, int mid) {

        int n1 = mid - leftIndex + 1;
        int n2 = rightIndex - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        int i = 0, j = 0;
        while (i < n1) {
            leftArr[i] = arr[leftIndex + i];
            i++;
        }
        while (j < n2) {
            rightArr[j] = arr[mid + 1 + j];
            j++;
        }


        i = 0;
        j = 0;
        int k = leftIndex;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}


/*
Time complexity
best case: O(nlogn)
average case: O(nlogn)
worst case: O(nlogn)

Space complexity: n
*/