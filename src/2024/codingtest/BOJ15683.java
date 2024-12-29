package codingtest;

import java.io.*;
import java.util.*;

public class BOJ15683 {
    private static int N, M;
    private static int[][] map;
    private static int[][] virtual;
    private static int cnt;
    private static int min;
    private static List<CCTV> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new int[N][M];
        virtual = new int[N][M];
        list = new ArrayList<>();
        int now;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if (now >= 1 && now < 5) {
                    cnt++;
                    virtual[i][j]++;
                    list.add(new CCTV(i, j, now));
                }
                if (now == 6) {
                    virtual[i][j]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 5) {
                    for (int k = j; k >= 0; k--) {
                        if (map[i][k] == 6) break;
                        virtual[i][k]++;
                    }
                    for (int k = i; k >= 0; k--) {
                        if (map[k][j] == 6) break;
                        virtual[k][j]++;
                    }
                    for (int k = j; k < M; k++) {
                        if (map[i][k] == 6) break;
                        virtual[i][k]++;
                    }

                    for (int k = i; k < N; k++) {
                        if (map[k][j] == 6) break;
                        virtual[k][j]++;
                    }
                }
            }
        }
        min = 64;
        solve(0);
        System.out.println(min);
    }

    private static void solve(int depth) {
        if (depth == cnt) {
            min = Math.min(min, getSpot());
            return;
        }
        CCTV now = list.get(depth);
        for (int i = 0; i < 4; i++) {
            now.removeMap(i);
            solve(depth + 1);
            now.addMap(i);
        }
    }

    private static int getSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virtual[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    private static class CCTV {
        int x;
        int y;
        int version;

        public CCTV(int x, int y, int version) {
            this.x = x;
            this.y = y;
            this.version = version;
        }

        public void removeMap(int direction) {
            if (version == 1) {
                remove(direction);
            } else if (version == 2) {
                remove(direction);
                remove((direction + 2) % 4);
            } else if (version == 3) {
                remove(direction);
                remove((direction + 1) % 4);
            } else if (version == 4) {
                remove(direction);
                remove((direction + 1) % 4);
                remove((direction + 2) % 4);
            }
        }

        private void remove(int i) {
            if (i == 0) {
                for (int k = y; k >= 0; k--) {
                    if (map[x][k] == 6) break;
                    virtual[x][k]++;
                }
            } else if (i == 1) {
                for (int k = x; k >= 0; k--) {
                    if (map[k][y] == 6) break;
                    virtual[k][y]++;
                }
            } else if (i == 2) {
                for (int k = y; k < M; k++) {
                    if (map[x][k] == 6) break;
                    virtual[x][k]++;
                }
            } else if (i == 3) {
                for (int k = x; k < N; k++) {
                    if (map[k][y] == 6) break;
                    virtual[k][y]++;
                }
            }
        }

        public void addMap(int direction) {
            if (version == 1) {
                add(direction);
            } else if (version == 2) {
                add(direction);
                add((direction + 2) % 4);
            } else if (version == 3) {
                add(direction);
                add((direction + 1) % 4);
            } else if (version == 4) {
                add(direction);
                add((direction + 1) % 4);
                add((direction + 2) % 4);
            }
        }

        private void add(int i) {
            if (i == 0) {
                for (int k = y; k >= 0; k--) {
                    if (map[x][k] == 6) break;
                    virtual[x][k]--;
                }
            } else if (i == 1) {
                for (int k = x; k >= 0; k--) {
                    if (map[k][y] == 6) break;
                    virtual[k][y]--;
                }
            } else if (i == 2) {
                for (int k = y; k < M; k++) {
                    if (map[x][k] == 6) break;
                    virtual[x][k]--;
                }
            } else if (i == 3) {
                for (int k = x; k < N; k++) {
                    if (map[k][y] == 6) break;
                    virtual[k][y]--;
                }
            }
        }

        @Override
        public String toString() {
            return String.valueOf(version);
        }
    }
}
