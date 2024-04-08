package codingtest.search;

import java.util.*;

public class PGR84512 {

    public static void main(String[] args) {
        System.out.println(solution("EIO"));
    }
    static List<String> list;
    static String[] arr = new String[]{"A","E","I","O","U"};
    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        create("", 0);
        return list.indexOf(word);
    }
    public static void create(String str,int depth){
        list.add(str);

        if(depth == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            create(str + arr[i], depth + 1);
        }
    }
}
