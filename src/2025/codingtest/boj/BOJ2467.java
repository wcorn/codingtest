package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2467"> 용액 </a>
 */
public class BOJ2467 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N - 1;
        int l = 0;
        int r = 0;
        int sum = Integer.MAX_VALUE;
        while (left < right) {
            int temp = arr[left] + arr[right];
            if (Math.abs(sum) > Math.abs(temp)) {
                l = left;
                r = right;
                sum = temp;
            }
            if (temp > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(arr[l] + " " + arr[r]);
    }
}
