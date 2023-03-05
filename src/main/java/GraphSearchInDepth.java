import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSearchInDepth {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            if (M == 0) {
                System.out.println("1\n1");
                return;
            }
            boolean[] visited = new boolean[N + 1];
            List<List<Integer>> connectivityList = new ArrayList<>(M + 1);
            for (int i = 0; i <= N; i++) {
                connectivityList.add(new ArrayList<>());
            }
            for (int i = 1; i <= M; i++) {
                line = br.readLine().split(" ");
                connectivityList.get(Integer.parseInt(line[0])).add(Integer.parseInt(line[1]));
                connectivityList.get(Integer.parseInt(line[1])).add(Integer.parseInt(line[0]));
            }
            List<Integer> ans = new ArrayList<>();
            dfs(1, visited, connectivityList, ans);
            System.out.println(ans.size());
            for (int item: ans.stream().sorted().collect(Collectors.toList())) {
                System.out.print(item + " ");
            }

        }
    }

    public static void dfs(int vertex, boolean[] visited, List<List<Integer>> graph, List<Integer> ans) {
        visited[vertex] = true;
        ans.add(vertex);
        for (int item: graph.get(vertex)) {
            if (!visited[item]) {
                dfs(item, visited, graph, ans);
            }
        }
    }

}
