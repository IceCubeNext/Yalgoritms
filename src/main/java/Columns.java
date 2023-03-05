import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Columns {

    public void columns() throws IOException {
        int peak = 0;
        Map<Character, Integer> symbols = new TreeMap<>(Character::compare);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] chars = line.toCharArray();
                for(Character ch: chars) {
                    if (!ch.equals(' ')) {
                        if (!symbols.containsKey(ch)) {
                            symbols.put(ch, 1);
                        } else {
                            symbols.put(ch, symbols.get(ch) + 1);
                        }
                        peak = Math.max(peak, symbols.get(ch));
                    }
                }
            }
        }
        int iteration = peak * symbols.size();
        while(iteration > 0) {
            for(Character ch: symbols.keySet()) {
                if(symbols.get(ch) >= peak) {
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
                iteration -= 1;
            }
            System.out.println();
            peak -= 1;
        }
        for(Character ch: symbols.keySet()) {
            System.out.print(ch);
        }
    }

}
