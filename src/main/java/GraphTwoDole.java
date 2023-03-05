import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphTwoDole {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int[] color = new int[N + 1];
            List<List<Integer>> connectivityList = new ArrayList<>(M + 1);
            for (int i = 0; i <= N; i++) {
                connectivityList.add(new ArrayList<>());
            }
            for (int i = 1; i <= M; i++) {
                line = br.readLine().split(" ");
                connectivityList.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
                connectivityList.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
            }
            for (int vertex = 1; vertex < color.length; vertex++) {
                if (color[vertex] == 0) {
                    dfs(vertex, color, connectivityList, 1);
                }
            }
            System.out.println("YES");
        }
    }
    public static void dfs(int vertex, int[] color, List<List<Integer>> graph, int c) {
        color[vertex] = c;
        for (int item: graph.get(vertex)) {
            if (color[item] == 0) {
                dfs(item, color, graph, 3 - c);
            } else if (color[item] == c) {
                System.out.println("NO");
                System.exit(0);
            }
        }
    }
}
