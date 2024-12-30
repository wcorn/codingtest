package codingtest.boj;

import java.io.*;
import java.util.*;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if(set.contains(temp)){
                list.add(temp);
            }
        }
        Collections.sort(list);
        for(String str : list)
            sb.append(str).append("\n");
        System.out.println(list.size());
        System.out.println(sb);
    }
}
