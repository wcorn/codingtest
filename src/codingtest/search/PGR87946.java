package codingtest.search;

public class PGR87946 {
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(80,new int[][]{{80,20},{50,40},{30,10}}));
    }
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        answer = 0;
        dfs(0, k, dungeons);
        return answer;
    }
    public static void dfs(int depth, int k,int[][] dungeons){
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]||k<dungeons[i][0])
                continue;
            visited[i] = true;
            dfs(depth+1,k-dungeons[i][1],dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer,depth);
    }
}
