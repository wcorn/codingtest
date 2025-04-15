package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1292"> 쉽게 푸는 문제 </a>
 */
public class BOJ1292 {

    private static int A;
    private static int B;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[1000];
        cal();
        int answer = 0;
        for (int i = A - 1; i <= B - 1; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }

    private static void cal() {
        int now = 1;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            arr[i] = now;
            count++;
            if (count == now) {
                now++;
                count = 0;
            }
        }
    }
}
