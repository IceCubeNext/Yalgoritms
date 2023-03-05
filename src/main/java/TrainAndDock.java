import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TrainAndDock {
    public void train() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int trainLength = Integer.parseInt(br.readLine().trim());
        String[] carriages = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int currentValue = 1;
        if (trainLength < 2) {
            System.out.println("YES");
            return;
        } else {
            for (String item: carriages) {
                int carriageNumber = Integer.parseInt(item);
                stack.push(carriageNumber);
                while (!stack.isEmpty() && stack.peek() == currentValue) {
                    stack.pop();
                    currentValue++;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
