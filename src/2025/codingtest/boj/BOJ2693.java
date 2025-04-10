package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2693"> N번째 큰 수 </a>
 */
public class BOJ2693 {

    private static int N;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            Arrays.sort(arr);
            sb.append(arr[arr.length-3]).append("\n");
        }
        System.out.println(sb);
    }
}
