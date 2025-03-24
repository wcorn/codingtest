package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/20055"> 컨베이어 벨트 위의 로봇 </a>
 */
public class BOJ20055 {

    private static int N;
    private static int K;
    private static int[] A;
    private static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int step = 0;
        while (K > 0) {
            step++;
            rotation();
            move();
            in();
        }
        System.out.println(step);
    }

    private static void rotation() {
        int temp1 = A[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = temp1;
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    private static void move() {
        for (int i = N - 1; i > 0; i--) {
            if (A[i] > 0 && !robot[i] && robot[i - 1]) {
                robot[i] = true;
                robot[i - 1] = false;
                A[i]--;
                if (A[i] == 0) {
                    K--;
                }
            }
        }
        robot[N - 1] = false;
    }

    private static void in() {
        if (A[0] > 0 && !robot[0]) {
            robot[0] = true;
            A[0]--;
            if (A[0] == 0) {
                K--;
            }
        }
    }
}
