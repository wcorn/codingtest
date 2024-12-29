package codingtest.search;

import java.util.*;

public class PGR1844 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

    public static int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        Point point;
        while (!q.isEmpty()) {
            point = q.poll();
            if (point.x == maps.length - 1 && point.y == maps[0].length - 1) {
                return point.count;
            }
            int nextX;
            int nextY;
            for (int i = 0; i < 4; i++) {
                nextX = point.x + dx[i];
                nextY = point.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (maps[nextX][nextY] == 0) {
                    continue;
                }
                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY, point.count + 1));
            }
        }
        return -1;
    }

    static class Point {

        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
