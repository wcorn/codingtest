package codingtest.string;

import java.util.*;
import java.util.stream.*;

public class PGR12939 {
    public static void main(String[] args){
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        List<Integer> list = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return Collections.min(list)+" "+Collections.max(list);
    }
}
