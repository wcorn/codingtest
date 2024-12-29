package codingtest.math;

import java.io.*;
import java.util.*;

public class BOJ1629 {
    private static long A,B,C;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(solve()%C);
    }
    private static long solve(){
        return calculate(B);
    }
    private static long calculate(long index){
        if(index==1)
            return A;
        long temp = calculate(index/2);
        if(index%2==1)
            return temp*temp%C*A%C;
        return temp*temp%C;
    }
}
