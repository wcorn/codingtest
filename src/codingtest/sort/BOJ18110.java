package codingtest.sort;

import java.io.*;

public class BOJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        result = solve(n, arr);
        System.out.println(result);
    }

    public static int solve(int n, int[] arr) {
        int level = 0;
        int except = Math.round((float) (n * 15) / 100);
        int start = except;
        int end = n - except;
        if (arr.length > 0) {
            dualPivotQuickSort(0, n - 1, arr);

            for (int i = start; i < end; i++) {
                level += arr[i];
            }
            return Math.round((float) level / (n - except * 2));
        } else {
            return level;
        }
    }

    private static void dualPivotQuickSort(int left, int right, int[] arr) {
        if (left < right) {
            int[] pivot = partition(left, right, arr);
            dualPivotQuickSort(left, pivot[0] - 1, arr);
            dualPivotQuickSort(pivot[0] + 1, pivot[1] - 1, arr);
            dualPivotQuickSort(pivot[1] + 1, right, arr);
        }
    }

    private static int[] partition(int left, int right, int[] arr) {
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        int k = left + 1;
        int leftPivot = left + 1;
        int rightPivot = right - 1;
        while (k <= rightPivot) {
            if (arr[k] < arr[left]) {
                swap(arr, leftPivot++, k);
            } else if (arr[k] >= arr[right]) {
                while (arr[rightPivot] > arr[right] && k < rightPivot) {
                    rightPivot--;
                }
                swap(arr, rightPivot--, k);
                if (arr[k] < arr[left]) {
                    swap(arr, k, leftPivot++);
                }
            }
            k++;
        }
        swap(arr, left, --leftPivot);
        swap(arr, right, ++rightPivot);
        return new int[]{leftPivot, rightPivot};
    }

    private static void swap(int[] arr, int a, int b) {
        int k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
    }
}
