import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSearchCycle {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int[] color = new int[N + 1];
            int [][] visited = new int[N + 1][N + 1];
            List<List<Integer>> connectivityList = new ArrayList<>(N + 1);
            for (int i = 0; i <= N; i++) {
                connectivityList.add(new ArrayList<>());
            }
            for (int i = 1; i <= N; i++) {
                String[] vert = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (!vert[j].equals("0")) {
                        connectivityList.get(i).add(j + 1);
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int vertex = 1; vertex <= N; vertex++) {
                if (color[vertex] == 0) {
                    ans.clear();
                    dfs(vertex, color, connectivityList, ans, 1, visited, vertex);
                }
            }
            System.out.println("NO");
        }
    }
    public static void dfs(int vertex, int[] color, List<List<Integer>> graph, List<Integer> ans, int c, int[][] visited, int last) {
        color[vertex] = c;
        visited[vertex][last] = 1;
        visited[last][vertex] = 1;
        for (int item: graph.get(vertex)) {
            if (color[item] == 0) {
                dfs(item, color, graph, ans, 1, visited, vertex);
            } else if (color[item] == 1) {
                System.out.println("YES");
                System.out.println(ans.size());
                for (int i = ans.size() - 1; i >= 0; i-- ) {
                    System.out.print(ans.get(i) + " ");
                }
                System.exit(0);
            }
        }
        color[vertex] = 2;
    }
}
