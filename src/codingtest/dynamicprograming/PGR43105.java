package codingtest.dynamicprograming;

public class PGR43105 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    public static int solution(int[][] triangle) {
        int answer = 0;
        int left;
        int right;
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<i+1;j++){
                left = j-1;
                right = j;
                if(left<0)
                    triangle[i][j] = triangle[i][j]+triangle[i-1][right];
                else if(right>=i)
                    triangle[i][j] = triangle[i][j]+triangle[i-1][left];
                else
                    triangle[i][j]  = triangle[i][j]+Math.max(triangle[i-1][right],triangle[i-1][left]);
            }
        }
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            answer = Math.max(answer,triangle[triangle.length-1][i]);
        }
        return answer;
    }
}
