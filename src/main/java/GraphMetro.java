import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GraphMetro {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            Map<Integer, Set<Integer>> underground = new HashMap<>();    // line:stations
            Map<Integer, ArrayList<Integer>> stations = new HashMap<>();  // station:lines
            ArrayList<ArrayList<Integer>> transfers = new ArrayList<>(); // index - line, values - transfers from line
            for (int i = 0; i < M; i++) {
                transfers.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().split(" ");
                Set<Integer> stations_temp = new HashSet<>();
                for (int item = 1; item < line.length; item++) {
                    int station = Integer.parseInt(line[item]);
                    stations_temp.add(station);
                    if (stations.containsKey(station)) {
                        for (int lineNumber: stations.get(station)) {
                            transfers.get(i).add(lineNumber);
                            transfers.get(lineNumber).add(i);
                        }
                        stations.get(station).add(i);
                    } else {
                        stations.put(station, new ArrayList<>());
                        stations.get(station).add(i);
                    }
                }
                underground.put(i, stations_temp);
            }
            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            if (!stations.containsKey(A) || !stations.containsKey(B)) {
                System.out.println(-1);
                return;
            }
            System.out.println(bfs(underground, A, B, transfers, stations));
        }
    }

    public static int bfs (Map<Integer, Set<Integer>> graph, int lineNumber, int stationB, ArrayList<ArrayList<Integer>> connections, Map<Integer, ArrayList<Integer>> stations) {
        class Line {
            Line(Set<Integer> stations, int lineNumber, int transfer) {
                this.stations = stations;
                this.lineNumber = lineNumber;
                this.transfer = transfer;
            }
            Set<Integer> stations;
            int lineNumber;
            int transfer;
        }
        int min = 2_147_483_647;
        ArrayDeque<Line> queue = new ArrayDeque<>();
        int[] visited = new int[graph.size()];
        Arrays.fill(visited, -1);
        int transfer = 0;
        for (int item: stations.get(lineNumber)) {
            queue.addLast(new Line(graph.get(item), item, transfer));
        }
        while (queue.size() > 0) {
            Line line = queue.pop();
            if (line.stations.contains(stationB)) min = Math.min(line.transfer, min);
            for (int neighbor: connections.get(line.lineNumber)) {
                if (visited[neighbor] != -1) continue;
                queue.addLast(new Line(graph.get(neighbor), neighbor, line.transfer + 1));
            }
            visited[line.lineNumber] = 1;
        }
        if (min == 2_147_483_647) return -1;
        return min;
    }
}
