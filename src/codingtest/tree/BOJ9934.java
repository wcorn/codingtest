package codingtest.tree;

import java.io.*;
import java.util.*;

public class BOJ9934 {
    private static int[] nums;
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        nums = new int[(int) Math.pow(2, k) - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }
        solve();
        list.get(k-1).add(nums[nums.length-1]);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        divide(0, nums.length - 1, 0);

    }

    private static void divide(int low, int high, int depth) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            list.get(depth).add(nums[mid]);
            divide(low, mid, depth + 1);
            divide(mid + 1, high, depth + 1);
        }
    }
}