package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2304"> 창고 다각형 </a>
 */
public class BOJ2304 {

    private static int N;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        int min = 1001;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        int[] arr = new int[max - min + 1];
        for (int i : map.keySet()) {
            arr[i - min] = map.get(i);
        }
        int[] arr1 = new int[arr.length];
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = Math.max(arr[i], value);
            arr1[i] = value;
        }
        int[] arr2 = new int[arr.length];
        value = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            value = Math.max(arr[i], value);
            arr2[i] = value;
        }
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            result+=Math.min(arr1[i],arr2[i]);
        }
        System.out.println(result);
    }

}
