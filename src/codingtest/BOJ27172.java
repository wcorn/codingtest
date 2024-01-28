package codingtest;

import java.io.*;
import java.util.*;

public class BOJ27172 {
    private static int N;
    private static int[] player;
    private static int[] score;
    private static boolean[] isExist;
    private static StringBuilder sb;
    private final static int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        player = new int[N];
        score = new int[SIZE];
        isExist = new boolean[SIZE];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            isExist[player[i]] = true;
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        for (int i : player) {
            for (int j = i * 2; j < SIZE; j += i) {
                if(isExist[j]){
                    score[i]++;
                    score[j]--;
                }
            }
        }
        for (int i : player) {
            sb.append(score[i]).append(" ");
        }
    }

}
