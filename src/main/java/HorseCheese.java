import java.util.Scanner;

public class HorseCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[][] dp = new long[N + 1][M + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++){
            for (int j = 2; j <= M; j++) {
                dp[i][j] = dp[i - 2][j - 1] + dp[i - 1][j - 2];
            }
        }
        System.out.println(dp[N][M]);
    }
}
