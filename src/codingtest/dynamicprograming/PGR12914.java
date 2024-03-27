package codingtest.dynamicprograming;

import java.util.*;

public class PGR12914 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static long solution(int n) {
        int[] arr = new int[n + 2];
        arr[1] = 1;
        for (int i = 1; i < n; i++) {
            arr[i + 1] = (arr[i + 1] + arr[i]) % 1234567;
            arr[i + 2] = (arr[i + 2] + arr[i]) % 1234567;
        }
        return (arr[n] + arr[n - 1]) % 1234567;
    }
}
