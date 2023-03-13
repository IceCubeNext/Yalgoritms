import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Contest1 {
    static class Railway {
        Railway(int count, String name) {
            this.name = name;
            this.count = count;
        }
        String name;
        int count;
    }
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)) {
            ArrayDeque<Railway> train = new ArrayDeque<>();
            long N = Integer.parseInt(br.readLine());
            for (long i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                switch (line[0]) {
                    case "add":
                        train.addLast(new Railway(Integer.parseInt(line[1]), line[2]));
                        break;
                    case "delete":
                        int count = Integer.parseInt(line[1]);
                        while (count > 0 && !train.isEmpty()) {
                            if (count > train.getLast().count) {
                                count -= train.getLast().count;
                                train.removeLast();
                            } else if (count == train.getLast().count) {
                                count = 0;
                                train.removeLast();
                            } else {
                                train.getLast().count -= count;
                                count = 0;
                            }
                        }
                        break;
                    case "get":
                        long goodCount = 0;
                        for (Railway rw : train) {
                            if (rw.name.equals(line[1])) {
                                goodCount += rw.count;
                            }
                        }
                        System.out.println(goodCount);
                        break;
                }
            }
        }
    }
}
