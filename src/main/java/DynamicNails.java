import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DynamicNails {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            int nailCount = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int[] nails = new int[nailCount + 1];
            int i = 1;
            for (String ch: line.split(" ")) {
                nails[i] = Integer.parseInt(ch);
                i++;
            }
            nails = Arrays.stream(nails).sorted().toArray();
            if (nailCount == 2) {
                System.out.println(nails[2] - nails[1]);
                return;
            } else if (nailCount == 3) {
                System.out.println(nails[3] - nails[1]);
                return;
            }
            int[] dp = new int[nailCount + 1];
            dp[2] = nails[2] - nails[1];
            dp[3] = nails[3] - nails[1];
            for (int j = 4; j <= nailCount; j++) {
                dp[j] = Math.min(dp[j - 2], dp[j - 1]) + nails[j] - nails[j - 1];
            }
            System.out.println(dp[nailCount]);
         }
    }
}
