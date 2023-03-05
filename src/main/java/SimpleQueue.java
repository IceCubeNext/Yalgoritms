import java.io.*;
import java.util.ArrayDeque;

public class SimpleQueue {
    public void queue() throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            OutputStream out = new BufferedOutputStream(System.out)) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            while (true) {
                out.flush();
                int value = 0;
                String[] input = br.readLine().trim().split(" ");
                if (input.length > 1) {
                   value = Integer.parseInt(input[1]);
                }
                String command = input[0];
                switch (command) {
                    case "push":
                        queue.offer(value);
                        out.write(("ok\n").getBytes());
                        break;
                    case "pop":
                        if (queue.isEmpty()) {
                            out.write(("error\n").getBytes());
                        } else {
                            out.write((queue.poll() + "\n").getBytes());
                        }
                        break;
                    case "front":
                        if (queue.isEmpty()) {
                            out.write(("error\n").getBytes());
                        } else {
                            out.write((queue.peek() + "\n").getBytes());
                        }
                        break;
                    case "size":
                        out.write((queue.size() + "\n").getBytes());
                        break;
                    case "clear":
                        queue.clear();
                        out.write(("ok\n").getBytes());
                        break;
                    case "exit":
                        out.write(("bye\n").getBytes());
                        return;
                }
            }
        }
    }
}
