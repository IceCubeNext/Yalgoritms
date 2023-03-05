import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class BoringLection {
    public void lection() throws IOException {
        Map<Character, Long> letters = new TreeMap<>(Comparator.naturalOrder());
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder line = new StringBuilder(br.readLine());
        int size = line.length();
        char[] chars = new char[size];
        line.getChars(0, size, chars, 0);
        for (int i = 0; i < size; i++) {
            if (!letters.containsKey(chars[i])) {
                letters.put(chars[i], (long) (size - i) * (i + 1));
            } else {
                letters.put(chars[i], letters.get(chars[i]) + (long) (size - i) * (i + 1));
            }
        }
        for (Character ch: letters.keySet()) {
            System.out.println(ch + ": " + letters.get(ch));
        }

    }
}
