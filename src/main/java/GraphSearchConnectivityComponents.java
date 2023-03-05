import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphSearchConnectivityComponents {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            OutputStream out = new BufferedOutputStream(System.out)) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            if (N==0) {
                System.out.println(0);
                return;
            }
            if (M == 0) {
                System.out.println(N);
                for (int i = 1; i <= N; i++) {
                    System.out.println("1\n" + i);
                }
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
            List<List<Integer>> res = new ArrayList<>();
            for (int vertex = 1; vertex < visited.length; vertex++) {
                if (!visited[vertex]) {
                    List<Integer> ans = new ArrayList<>();
                    dfs(vertex, visited, connectivityList, ans);
                    res.add(ans.stream().sorted().collect(Collectors.toList()));
                }
            }

            out.write((res.size() + "\n").getBytes());
            for (List<Integer> l: res) {
                out.write((l.size() + "\n").getBytes());
                for (int i : l) {
                    out.write((i + " ").getBytes());
                }
                out.write(("\n").getBytes());
                out.flush();
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
