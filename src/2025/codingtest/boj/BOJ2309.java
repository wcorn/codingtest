package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2309"> 일곱 난쟁이 </a>
 */
public class BOJ2309 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        sum -= 100;
        boolean flag = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i] + arr[j] == sum) {
                    flag = true;
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (arr[i] == 0) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
