import java.io.*;
import java.util.*;

public class GoodString {
    public void good() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStream out = new BufferedOutputStream(System.out);
        BufferedReader br = new BufferedReader(isr);
        long symbolAmount = Long.parseLong(br.readLine());
        long iterations = 0;
        long count = 0;
        ArrayList<Long> chars = new ArrayList<>();
        for (long i = 0; i < symbolAmount; i++) {
            long letterAmount = Long.parseLong(br.readLine());
            chars.add(letterAmount);
            iterations += letterAmount;
        }
        while (iterations > 0) {
            for (int i = 0; i < chars.size(); i++){
                if (chars.get(i) == 0) continue;
                int start = i;
                int length = 0;
                int end = i;
                long min = chars.get(i);
                for (int j = start; j < chars.size(); j++) {
                    if (chars.get(j) != 0) {
                        length++;
                        end = j;
                        min = Math.min(min, chars.get(j));
                    } else {
                        break;
                    }
                }
                if (length == 1) {
                    iterations -= chars.get(start);
                    chars.set(start, 0L);
                } else {
                    count += min * (length - 1);
                    iterations -= min * length;
                    while (length > 0) {
                        chars.set(end, chars.get(end) - min);
                        length--;
                        end--;
                    }
                }
                break;
            }
        }


        out.write((count + "").getBytes());
        out.flush();
    }
}
