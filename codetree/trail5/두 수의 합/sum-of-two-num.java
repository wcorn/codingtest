import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> m = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            int g = K-num;
            cnt+=m.getOrDefault(g,0);
            m.put(num,m.getOrDefault(num,0)+1);
        }
        System.out.println(cnt);
    }
}