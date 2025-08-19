package codingtest.boj;

import java.io.*;
import java.util.*;

/**
 * <a href="https://www.acmicpc.net/problem/1339"> 단어 수학 </a>
 */
public class BOJ1339 {

    private static int N;
    private static Map<Character, Integer> score;
    private static Map<Character, Integer> sum;
    private static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new HashMap<>();
        sum = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            list.add(str);
            for (int j = 0; j < str.length(); j++) {
                sum.put(str.charAt(j),
                    sum.getOrDefault(str.charAt(j), 0) + (int) Math.pow(10, str.length() - j));
            }
        }
        List<Character> priority = new ArrayList<>(sum.keySet());
        Collections.sort(priority, Comparator.comparingInt(a -> -sum.get(a)));
        int count = 9;
        for (char c : priority) {
            score.put(c, count--);
        }
        int result = 0;
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                result += score.get(s.charAt(i)) * Math.pow(10, s.length() - 1 - i);
            }
        }
        System.out.println(result);
    }
}
