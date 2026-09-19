import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                m.put(key,value);
            }
            else if(str.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                m.remove(key);
            }
            else if(str.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if(m.containsKey(key)) {
                    sb.append(m.get(key)).append("\n");
                }
                else{
                    sb.append("None").append("\n");
                }
            }
            else if(m.size()!=0) {
                for(int j : m.keySet()){
                    sb.append(m.get(j)).append(" ");
                }
                sb.append("\n");
            }
            else {
                sb.append("None").append("\n");
            }
        }
        System.out.println(sb);
    }
}