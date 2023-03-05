import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopologicalSort {
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
            }
            List<Integer> ans = new ArrayList<>();
            for (int vertex = 1; vertex <= N; vertex++) {
                if (color[vertex] == 0) {
                    dfs(vertex, color, connectivityList, ans, 1);
                }
            }
            for (int i = ans.size() - 1; i >= 0; i-- ) {
                System.out.print(ans.get(i) + " ");
            }
        }
    }
    public static void dfs(int vertex, int[] color, List<List<Integer>> graph, List<Integer> ans, int c) {
        color[vertex] = c;
        for (int item: graph.get(vertex)) {
            if (color[item] == 0) {
                dfs(item, color, graph, ans, 1);
            } else if (color[item] == 1) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        color[vertex] = 2;
        ans.add(vertex);
    }
}