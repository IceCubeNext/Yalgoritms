import java.util.Scanner;

public class DynamicGrasshopper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] dp = new long[n + k + 1];
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 1;
        int i;
        for(i = 3; i <= k; i++) {
            dp[i] = 2 * dp[i-1];
        }
        for(; i <= n; i++){
            dp[i] = 2 * dp[i-1] - dp[i-k-1];
        }
        System.out.println(dp[n]);
    }
}
