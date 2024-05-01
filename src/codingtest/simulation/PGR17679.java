package codingtest.simulation;

import java.util.*;

public class PGR17679 {

    public static void main(String[] args) {
        System.out.println(solution(4,	5,	new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }
    static int answer;
    static List<Character>[] list;
    static boolean[][] map;
    public static int solution(int m, int n, String[] board) {
        answer = 0;
        list = new ArrayList[n];
        char[][] temp = new char[m][n];
        for(int i=0;i<m;i++){
            temp[i] = board[i].toCharArray();
        }
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list[n-1-i].add(temp[m-1-j][n-1-i]);
            }
        }

        while(delete(m,n)){
            down(m,n);
        }
        return answer;
    }
    public static boolean delete(int m, int n){
        map = new boolean[n][m];
        boolean flag = false;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                if(list[i].get(j)=='0')
                    continue;
                if(list[i].get(j)==list[i].get(j+1)&&
                    list[i].get(j)==list[i+1].get(j)&&
                    list[i].get(j)==list[i+1].get(j+1)
                ){
                    map[i][j] = true;
                    map[i+1][j] = true;
                    map[i][j+1] = true;
                    map[i+1][j+1] = true;
                    flag = true;
                }
            }
        }
        return flag;
    }
    public static void down(int m, int n){
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(map[i][j]){
                    answer++;
                    list[i].remove(j);
                    list[i].add('0');
                }
            }
        }
    }
}
