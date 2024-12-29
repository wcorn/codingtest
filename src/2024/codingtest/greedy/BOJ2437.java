package codingtest.greedy;

import java.io.*;
import java.util.*;

public class BOJ2437 {
    private static int N;
    private static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(solve());
    }

    private static int solve() {
        int sum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (sum < arr[i])
                break;
            sum += arr[i];
        }
        return sum;
    }
}
