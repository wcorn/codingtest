package codingtest.string;

import java.util.*;

public class PGR64065 {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(solution(s));
    }

    public static List<Integer> solution(String s) {
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] str = s.split("},\\{");
        Arrays.sort(str, Comparator.comparing(String::length));
        int token;
        for (int i = 0; i < str.length; i++) {
            st = new StringTokenizer(str[i], ",");
            while (st.hasMoreTokens()) {
                token = Integer.parseInt(st.nextToken());
                if (!list.contains(token)) {
                    list.add(token);
                }
            }
        }
        return list;
    }
}
