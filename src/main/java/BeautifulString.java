import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulString {
    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            int k = Integer.parseInt(br.readLine());
            String s = br.readLine();
            System.out.println(characterReplacement(s, k));
        }
    }

    private static boolean ok(char[] ch, int k, int len) {
        int[] cnt = new int[26];
        for (int i = 0; i < ch.length; i++) {
            if (i >= len) cnt[ch[i - len] - 'a']--;
            cnt[ch[i] - 'a']++;
            if (i >= len - 1) {
                int max = 0;
                for (int j : cnt) max = Math.max(max, j);
                if (len - max <= k) return true;
            }
        }
        return false;
    }

    public static int characterReplacement(String s, int k) {
        if (s.length() == 0 || k >= s.length() - 1) return s.length();
        int left = 1, right = s.length() + 1;
        char[] ch = s.toCharArray();
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (ok(ch, k, mid)) left = mid;
            else right = mid;
        }
        return left;
    }

}
