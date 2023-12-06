package codingtest.math;

import java.util.*;
import java.io.*;

public class BOJ1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n];
        st = new StringTokenizer(br.readLine());
        int result = Integer.MAX_VALUE;
        int value = 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            if (value >= s) {
                result = Math.min(result, end - start);
                value -= sequence[start];
                start++;
            } else if (end == n) {
                break;
            } else {
                sequence[end] = Integer.parseInt(st.nextToken());
                value += sequence[end];
                end++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}