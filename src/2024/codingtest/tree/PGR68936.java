package codingtest.tree;

import java.util.*;

public class PGR68936 {
    static int a=0;
    static int b=0;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
    public static int[] solution(int[][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        recursion(0,x,0,y,arr);
        return new int[]{b,a};
    }
    public static void recursion(int lx,int rx,int ly,int ry,int[][] arr){
        int x=0, y=0;
        for(int i = lx;i<rx;i++){
            for(int j=ly;j<ry;j++){
                if(arr[i][j]==1)
                    x++;
                else
                    y++;
            }
        }
        if(x==0)
            b++;
        else if(y==0)
            a++;
        else {
            int mx = (lx+rx)/2;
            int my = (ly+ry)/2;
            recursion(lx,mx,ly,my,arr);
            recursion(mx,rx,ly,my,arr);
            recursion(lx,mx,my,ry,arr);
            recursion(mx,rx,my,ry,arr);
        }
    }
}
