package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/21608"> 상어 초등학교 </a>
 */
public class BOJ21608 {

    private static int N;
    private static int[][] map;
    private static Set<Integer>[] s;
    private static final int[] dx = new int[]{-1, 1, 0, 0};
    private static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int size = N * N;
        s = new HashSet[size + 1];
        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            s[num] = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                s[num].add(Integer.parseInt(st.nextToken()));
            }
            int[] arr = find(s[num]);
            map[arr[0]][arr[1]] = num;
        }
        System.out.println(check());
    }

    private static int[] find(Set<Integer> s) {
        int maxSize = -1;
        int maxEmpty = -1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    continue;
                }
                int size = 0;
                int empty = 0;
                for (int t = 0; t < 4; t++) {
                    int nextX = i + dx[t];
                    int nextY = j + dy[t];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }
                    if (s.contains(map[nextX][nextY])) {
                        size++;
                    }
                    if (map[nextX][nextY] == 0) {
                        empty++;
                    }
                }
                if (size > maxSize) {
                    maxSize = size;
                    maxEmpty = empty;
                    x = i;
                    y = j;
                } else if (size == maxSize && empty > maxEmpty) {
                    maxEmpty = empty;
                    x = i;
                    y = j;
                } else if (size == maxSize && empty == maxEmpty && (x > i || x == i && y > j)) {
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y};
    }

    private static int check() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int t = 0; t < 4; t++) {
                    int nextX = i + dx[t];
                    int nextY = j + dy[t];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }
                    if (s[map[i][j]].contains(map[nextX][nextY])) {
                        cnt++;
                    }
                }
                result += (int) Math.pow(10, cnt-1);
            }
        }
        return result;
    }
}