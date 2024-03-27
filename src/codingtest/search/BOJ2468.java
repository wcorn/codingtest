package codingtest.search;
import java.io.*;
import java.util.*;
public class BOJ2468 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int answer;
    private static int max;
    private static int now;
    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        max=0;
        answer=1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }
        solve();
        System.out.print(answer);
    }
    private static void solve(){
        for(int k=0;k<max;k++){
            visited = new boolean[N][N];
            now = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]&&map[i][j]>k){
                        now++;
                        dfs(i,j,k);
                    }
                }
            }
            answer = Math.max(answer,now);
        }
    }
    private static void dfs(int x,int y,int k){
        visited[x][y] = true;
        int nextX, nextY;
        for(int i=0;i<4;i++){
            nextX = x+dx[i];
            nextY = y+dy[i];
            if(nextX<0||nextY<0||nextX>=N||nextY>=N)
                continue;
            if(visited[nextX][nextY]||map[nextX][nextY]<=k)
                continue;
            dfs(nextX,nextY,k);
        }
    }
}
