import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;

public class GraphHorse {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int S = Integer.parseInt(line[2]);
            int T = Integer.parseInt(line[3]);
            int Q = Integer.parseInt(line[4]);
            int[][] desk = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    desk[i][j] = -1;
                }
            }
            int[][] fleas = new int[Q + 1][2];
            for (int i = 1; i <= Q; i++) {
                line = br.readLine().split(" ");
                fleas[i][0] = Integer.parseInt(line[0]);
                fleas[i][1] = Integer.parseInt(line[1]);
            }
            bfs(desk, S, T);
            int length = 0;
            for (int i = 1; i <= Q; i++) {
                if (desk[fleas[i][0]][fleas[i][1]] == -1) {
                    System.out.println(-1);
                    return;
                } else {
                    length += desk[fleas[i][0]][fleas[i][1]];
                }
            }
            System.out.println(length);
        }
    }

    public static void bfs (int[][] desk, int feederX, int feederY) {
        int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
        int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
        class Point {
            public final int x;
            public final int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        desk[feederX][feederY] = 0;
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(feederX, feederY));
        int x;
        int y;
        while (queue.size() > 0) {
            Point point = queue.pop();
            for (int i = 0; i < 8; i++) {
                x = point.x + row[i];
                y = point.y + col[i];
                if (x > 0 && y > 0 && x < desk.length && y < desk[0].length && desk[x][y] == -1) {
                    queue.addLast(new Point(x, y));
                    desk[x][y] = desk[point.x][point.y] + 1;
                }
            }
        }
    }
}

