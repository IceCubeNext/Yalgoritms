import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PolishNotation {
    public void notation() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[] line = br.readLine().trim().split(" ");
        if (line.length == 0) return;
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> priority = new HashMap<>();
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        for (String item: line) {
            if (!priority.containsKey(item)) {
                int value = Integer.parseInt(item);
                stack.push(value);
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (item) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }

}
