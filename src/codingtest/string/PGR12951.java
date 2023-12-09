package codingtest.string;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PGR12951 {
    public static void main(String[] args) {
        String s = "3people  unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                isFirst = true;
            } else if (isFirst) {
                answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                isFirst = false;
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}