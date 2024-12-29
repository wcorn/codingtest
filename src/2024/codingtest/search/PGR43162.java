package codingtest.search;

public class PGR43162 {
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,n,computers);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int x,int n, int[][] computers){
        visited[x] = true;
        for(int i=0;i<n;i++){
            if(visited[i]||computers[x][i]==0)
                continue;
            dfs(i,n,computers);
        }
    }
}
