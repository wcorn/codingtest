package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2138"> 전구와 스위치 </a>
 */
public class BOJ2138 {

    private static int N;
    private static boolean[] arr1;
    private static boolean[] arr2;
    private static boolean[] want;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        arr1 = new boolean[N];
        arr2 = new boolean[N];
        want = new boolean[N];
        for (int i = 0; i < N; i++) {
            boolean flag = str.charAt(i) == '0';
            arr1[i] = flag;
            arr2[i] = flag;
        }
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            want[i] = str.charAt(i) == '0';
        }
        int count1 = 0;
        int count2 = 1;
        arr2[0] = !arr2[0];
        arr2[1] = !arr2[1];
        for (int i = 1; i < N; i++) {
            if (arr1[i - 1] != want[i - 1]) {
                onSwitch(i, arr1);
                count1++;
            }
            if (arr2[i - 1] != want[i - 1]) {
                onSwitch(i, arr2);
                count2++;
            }
        }
        int ans = -1;
        if (arr1[N - 1] == want[N - 1]) {
            ans = count1;
        }
        if (arr2[N - 1] == want[N - 1] && ans == -1) {
            ans = count2;
        }
        else if (arr2[N - 1] == want[N - 1] && ans != -1 && ans > count2) {
            ans = count2;
        }
        System.out.println(ans);
    }

    private static void onSwitch(int index, boolean[] arr) {
        arr[index - 1] = !arr[index - 1];
        arr[index] = !arr[index];
        if (index + 1 < N) {
            arr[index + 1] = !arr[index + 1];
        }
    }
}
