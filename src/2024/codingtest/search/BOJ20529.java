package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        char[][] arr;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][4];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j] = st.nextToken().toCharArray();
            }
            sb.append(solve(N, arr)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int N, char[][] mbtiList) {
        int result = Integer.MAX_VALUE;
        int mindDistance;
        if (N > 32)
            return 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                for (int k = j+1; k < N; k++) {
                    mindDistance = 0;
                    mindDistance += getMindDistance(mbtiList[i], mbtiList[j]);
                    mindDistance += getMindDistance(mbtiList[j], mbtiList[k]);
                    mindDistance += getMindDistance(mbtiList[i], mbtiList[k]);
                    result = Math.min(result, mindDistance);
                }
            }
        }
        return result;
    }

    private static int getMindDistance(char[] mbti1, char[] mbti2) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1[i] != mbti2[i])
                distance++;
        }
        return distance;
    }
}