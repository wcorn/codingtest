import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        Map<Integer,Integer> m = new HashMap<>();
        int[] num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N-1;i++){
            for(int j = i+1; j < N; j++){
                int diff = K-num[i]-num[j];
                cnt+=m.getOrDefault(diff,0);
            }
            m.put(num[i],m.getOrDefault(num[i],0)+1);
        }
        System.out.println(cnt);
    }
}