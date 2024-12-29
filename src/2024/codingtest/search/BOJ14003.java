package codingtest.search;

import java.io.*;
import java.util.*;

public class BOJ14003 {

    private static int N;
    private static int[] arr;
    private static List<Integer> list;
    private static int[] index;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new ArrayList<>();
        index = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(list.size());
        System.out.println(sb);
    }

    private static void solve() {
        int left, right, mid;
        list.add(arr[0]);
        index[0] = 0;
        for (int i = 1; i < N; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
                index[i] = list.size() - 1;
            } else if (list.get(list.size() - 1) > arr[i]) {
                left = 0;
                right = list.size() - 1;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (list.get(mid) < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, arr[i]);
                index[i] = right;
            }
            else
                index[i] = list.size()-1;
        }
        Stack<Integer> stack = new Stack<>();
        int count = list.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (index[i] == count) {
                stack.add(arr[i]);
                count--;
            }
        }
        System.out.println(Arrays.toString(index));
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
    }
}
