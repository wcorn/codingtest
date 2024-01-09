package codingtest.geometry;

import java.io.*;
import java.util.*;

public class BOJ11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x1, y1;
        int x2, y2;
        int x3, y3;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());
        int ans = (x2-x1)*(y3-y2)-(x3-x2)*(y2-y1);
        if(ans>0)
            System.out.println(1);
        else if(ans<0)
            System.out.println(-1);
        else
            System.out.println(0);
    }
}
