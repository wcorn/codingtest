package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] map = new int[str1.length()][str2.length()];
        if (str1.charAt(0) == str2.charAt(0)) {
            map[0][0] = 1;
        }
        for (int i = 1; i < str1.length(); i++) {
            map[i][0] = map[i - 1][0];
            if (str1.charAt(i) == str2.charAt(0)) {
                map[i][0] = 1;
            }
        }
        for (int i = 1; i < str2.length(); i++) {
            map[0][i] = map[0][i - 1];
            if (str1.charAt(0) == str2.charAt(i)) {
                map[0][i] = 1;
            }
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if(str1.charAt(i)==str2.charAt(j)){
                    map[i][j] = map[i-1][j-1]+1;
                }
                else {
                    map[i][j] = Math.max(map[i-1][j],map[i][j-1]);
                }
            }
        }
        System.out.println(map[map.length-1][map[0].length-1]);
    }
}
