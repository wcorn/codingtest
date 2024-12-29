package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ10815 {
    private static int N;
    private static int M;
    private static int[] cards;
    private static int[] list;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        list = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        Arrays.sort(cards);
        System.out.println(Arrays.toString(cards));
        for (int i = 0; i < M; i++) {
            System.out.println(list[i]);
            if (binarySearch(list[i]))
                sb.append(1);
            else
                sb.append(0);
            sb.append(" ");
        }
    }

    private static boolean binarySearch(int num) {
        int left = 0;
        int right = N - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (cards[mid] == num)
                return true;
            else if (cards[mid] < num)
                left = mid + 1;
            else if (cards[mid] > num)
                right = mid - 1;
        }
        return false;
    }
}
