import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicCheapestWay {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            String[] parameters = br.readLine().split(" ");
            int N = Integer.parseInt(parameters[0]);
            int M = Integer.parseInt(parameters[1]);
            int [][] table = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    table[i][j] = Integer.parseInt(line[j]);
                }
            }
            for (int i = 1; i < N; i++) {
                table[i][0] += table[i - 1][0];
            }

            for (int j = 1; j < M; j++) {
                table[0][j] += table[0][j - 1];
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    table[i][j] += Math.min(table[i - 1][j], table[i][j - 1]);
                }
            }
            System.out.println(table[N - 1][M - 1]);
        }
    }
}
