import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> tr = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!tr.containsKey(num)){
                tr.put(num,i+1);
            }
        }
        for(int i : tr.keySet()){
            sb.append(i).append(' ').append(tr.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}