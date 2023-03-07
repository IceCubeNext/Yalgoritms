import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GraphLengthAndRoute {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> graph = new ArrayList<>(N + 1);
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 1; i <= N; i++) {
                String[] vert = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (!vert[j].equals("0")) {
                        graph.get(i).add(j + 1);
                    }
                }
            }
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int[] visited = new int[N + 1];
            int[] prev = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                visited[i] = -1;
            }
            int length = bfs(graph, A, B, visited, prev);
            System.out.println(length);
            if (length == -1 || length == 0) {
                return;
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(B);
            while(prev[B] != 0) {
                ans.add(prev[B]);
                B = prev[B];
            }
            if (ans.size() > 1) {
                for (int i = ans.size() - 1; i >= 0; i--) {
                    System.out.print(ans.get(i) + " ");
                }
            } else {
                System.out.println(0);
            }
        }
    }

    public static int bfs (List<List<Integer>> graph, int A, int B, int[] visited, int[] prev) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(A);
        visited[A] = 0;
        while (queue.size() > 0) {
            int vertex = queue.pop();
            for (int neighbor: graph.get(vertex)) {
                if (neighbor == vertex) continue;
                if (visited[neighbor] == -1) {
                    queue.addLast(neighbor);
                    prev[neighbor] = vertex;
                    visited[neighbor] = visited[vertex] + 1;
                }
            }
        }
        return visited[B];
    }
}