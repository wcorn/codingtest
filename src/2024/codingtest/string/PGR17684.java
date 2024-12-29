package codingtest.string;

import java.util.*;

public class PGR17684 {
    public static void main(String[] args) {
        String s = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(solution(s));
    }

    public static List<Integer> solution(String msg) {
        List<Integer> list = new ArrayList<>();
        List<String> str = new ArrayList<>();
        str.add("");
        for (int i = 0; i < 26; i++) {
            str.add(String.valueOf((char) (i + 65)));
        }
        while (!msg.isEmpty()) {
            String now = "";
            String next = "";
            for (int i = str.size() - 1; i > 0; i--) {
                if (msg.indexOf(str.get(i)) == 0) {
                    now = str.get(i);
                    if(msg.length()!=now.length())
                        next = msg.substring(now.length()).substring(0,1);
                    list.add(i);
                    break;
                }
            }
            msg = msg.substring(now.length());
            if(!next.isEmpty())
                str.add(now+next);
        }
        System.out.println(str);
        return list;
    }
}
