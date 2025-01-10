package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/5525"> IOIOI </a>
 */
public class BOJ5525 {

    private static int N;
    private static int S;
    private static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = Integer.parseInt(br.readLine());
        str = br.readLine();
        boolean flag = true;
        int answer = 0;
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (flag) {
                if (str.charAt(i) == 'I') {
                    flag = false;
                    count = 0;
                }
            } else {
                if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                    count++;
                    i++;
                    if (count >= N) {
                        answer++;
                    }
                } else {
                    flag = true;
                    i--;
                }
            }
        }
        System.out.println(answer);
    }
}
