package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1744"> 수 묶기 </a>
 */
public class BOJ1744 {

    private static int N;
    private static List<Integer> positive;
    private static List<Integer> negative;
    private static boolean zero;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        positive = new ArrayList<>();
        negative = new ArrayList<>();
        zero = false;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                result++;
            } else if (num == 0) {
                zero = true;
            } else if (num > 1) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            }
        }
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);
        Queue<Integer> positiveQ = new LinkedList<>(positive);
        Queue<Integer> negativeQ = new LinkedList<>(negative);
        while (positiveQ.size() > 1) {
            result += positiveQ.poll() * positiveQ.poll();
        }
        while (negativeQ.size() > 1) {
            result += negativeQ.poll() * negativeQ.poll();
        }
        if (positiveQ.size() == 1) {
            result += positiveQ.poll();
        }
        if (negativeQ.size() == 1 && !zero) {
            result += negativeQ.poll();
        }
        System.out.println(result);
    }
}
