import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GraphSpeleologist {
    public static class Point {
        public final int x;
        public final int y;
        public final int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            int N = Integer.parseInt(br.readLine());
            int[][][] cube = new int[N + 1][N + 1][N + 1];
            Point start = new Point(0, 0, 0);
            List<Point> exits = new ArrayList<>();
            for (int z = 1; z <= N; z++) {
                br.readLine();
                for (int x = 1; x <= N; x++) {
                    String[] line = br.readLine().split("");
                    for (int y = 1; y <= N; y++) {
                        switch (line[y - 1]) {
                            case "S":
                                start = new Point(x, y, z);
                                cube[z][x][y] = 0;
                                break;
                            case ".":
                                if (z == 1) {
                                    exits.add(new Point(x, y, z));
                                }
                                cube[z][x][y] = -1;
                                break;
                            case "#":
                                cube[z][x][y] = -2;
                                break;
                        }
                    }
                }
            }
            bfs(cube, start);
            int min = 2_147_483_647;
            for (Point point: exits) {
                if (cube[point.z][point.x][point.y] != -1) {
                    min = Math.min(min, cube[point.z][point.x][point.y]);
                }
            }
            System.out.println(min);
        }
    }

    public static void bfs (int[][][] cube, Point start) {
        int[] moveX = {0 ,0, 0, 0, -1, 1};
        int[] moveY = {0 ,0, -1, 1, 0, 0};
        int[] moveZ = {-1, 1, 0, 0, 0, 0};
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(start);
        while (queue.size() > 0) {
            Point point = queue.pop();
            for (int i = 0; i < 6; i++) {
                int x = point.x + moveX[i];
                int y = point.y + moveY[i];
                int z = point.z + moveZ[i];
                if (z > 0 && z < cube.length && x > 0 && x < cube.length && y > 0 && y < cube.length && cube[z][x][y] == -1) {
                    queue.addLast(new Point(x, y, z));
                    cube[z][x][y] = cube[point.z][point.x][point.y] + 1;
                }
            }
        }
    }
}
