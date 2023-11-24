package codingtest.recursion;

public class PGR150365 {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        System.out.println(solution(n, m, x, y, r, c, k));
    }

    static int startX, startY;
    static int endX, endY;
    static String answer = null;
    static int num;
    static int a, b;
    static final int[] dx = {1, 0, 0, -1};
    static final int[] dy = {0, -1, 1, 0};
    static final String[] str = {"d", "l", "r", "u"};
    static String[] dist;
    static StringBuilder sb;

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        a = n;
        b = m;
        dist = new String[k];
        sb = new StringBuilder();
        startX = x - 1;
        startY = y - 1;
        endX = r - 1;
        endY = c - 1;
        num = k;
        int length = distance(x, y, r, c);
        if ((k - length) % 2 == 1 || k < length)
            return "impossible";
        dfs(startX, startY, 0);
        return answer == null ? "impossible" : answer;
    }

    private static void dfs(int x, int y, int depth) {
        if (answer != null) return;
        if (depth + distance(x, y, endX, endY) > num) return;
        if (depth == num) {
            if (x == endX && y == endY) {
                answer = sb.toString();
            }
            return;
        }
        int nextX;
        int nextY;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= a || nextY >= b)
                continue;
            sb.append(str[i]);
            dfs(nextX, nextY, depth + 1);
            sb.delete(depth, depth + 1);
        }
    }

    private static int distance(int x, int y, int r, int c) {
        return (int) Math.abs(x - r) + (int) Math.abs(y - c);
    }
}