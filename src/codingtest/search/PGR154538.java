package codingtest.search;

import java.util.*;

public class PGR154538 {

    public static void main(String[] args) {
        System.out.println(solution(10,40,5));
    }
    static boolean[] visited = new boolean[1000_001];
    static Queue<Integer> q;
    public static int solution(int x, int y, int n) {
        q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        int count = 0;
        int now;
        int size;
        while(!q.isEmpty()){
            size = q.size();
            for(int i=0; i< size;i++){
                now = q.poll();
                if(now==y)
                    return count;
                if(now+n<=y&&!visited[now+n]){
                    q.add(now+n);
                    visited[now+n] = true;
                }
                if(now*2<=y&&!visited[now*2]){
                    q.add(now*2);
                    visited[now*2] = true;
                }
                if(now*3<=y&&!visited[now*3]){
                    q.add(now*3);
                    visited[now*3] = true;
                }
            }
            count++;
        }
        return -1;
    }
}
