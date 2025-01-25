package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1074"> Z </a>
 */
public class BOJ1074 {

    private static int N;
    private static int r;
    private static int c;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        count = 0;
        recursion((int) Math.pow(2, N), r, c);
        System.out.println(count);
    }

    private static void recursion(int size, int x, int y) {
        if (size == 1) {
            return;
        }
        int temp = size / 2;
        int temp2 = (int) Math.pow(temp, 2);
        if (x < temp && y < temp) {
            recursion(temp, x, y);
        } else if (x < temp && y >= temp) {
            count += temp2;
            recursion(temp, x, y - temp);
        } else if (x >= temp && y < temp) {
            count += temp2 * 2;
            recursion(temp, x - temp, y);
        } else if (x >= temp && y >= temp) {
            count += temp2 * 3;
            recursion(temp, x - temp, y - temp);
        }
    }
}
