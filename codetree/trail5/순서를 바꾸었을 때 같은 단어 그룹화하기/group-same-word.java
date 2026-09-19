import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> m = new HashMap<>();
        for(int i = 0; i < N; i++){
            char[] ch = br.readLine().toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            m.put(str,m.getOrDefault(str,0)+1);
        }
        int ans = 0;
        for(String s : m.keySet()){
            ans = Math.max(ans,m.get(s));
        }
        System.out.println(ans);
    }
}