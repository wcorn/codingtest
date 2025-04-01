package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/2501"> 약수 구하기</a>
 */
public class BOJ2501 {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int size = (int) Math.sqrt(N) + 1;
        for (int i = 1; i < size; i++) {
            if (N % i == 0) {
                list1.add(i);
                if (i != N / i) {
                    list2.add(N / i);
                }
            }
        }
        Collections.reverse(list2);
        list1.addAll(list2);
        if (K>= list1.size()) {
            System.out.println(0);
        } else {
            System.out.println(list1.get(K));
        }
    }
}
