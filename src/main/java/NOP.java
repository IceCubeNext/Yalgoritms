import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NOP {
    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            int N = Integer.parseInt(br.readLine().trim());
            int[] first = new int[N + 1];
            String line = br.readLine();
            int i = 1;
            for (String item: line.split(" ")) {
                first[i] = Integer.parseInt(item);
                i++;
            }

            int M = Integer.parseInt(br.readLine().trim());
            int[] second = new int[M + 1];
            line = br.readLine();
            i = 1;
            for (String item: line.split(" ")) {
                second[i] = Integer.parseInt(item);
                i++;
            }
            int[][] dp = new int[N + 1][M + 1];
            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    if (first[n] == second[m]) {
                        dp[n][m] = dp[n - 1][m - 1] + 1;
                    } else {
                        dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                    }
                }
            }
            int n = N;
            int m = M;
            int[] ans = new int[dp[N][M]];
            i = dp[N][M] - 1;
            while (n >= 1 && m >= 1) {
                if (first[n] == second[m]) {
                    ans[i] = first[n];
                    n--;
                    m--;
                    i--;
                } else {
                    if (dp[n - 1][m] > dp[n][m - 1]) {
                        n--;
                    } else {
                        m--;
                    }
                }
            }
            for (int item: ans) {
                System.out.print(item + " ");
            }
        }
    }
}

