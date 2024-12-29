package codingtest.hash;

import java.io.*;
import java.util.*;

public class BOJ14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            if(set.contains(br.readLine()))
                answer++;
        }
        System.out.println(answer);
    }
}
