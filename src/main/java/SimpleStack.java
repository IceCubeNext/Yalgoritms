import java.util.Scanner;
import java.util.Stack;

public class SimpleStack {
    public void stack() {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String commands = scanner.nextLine();
            String[] parameters = commands.split(" ");
            String command;
            int value = 0;
            if (parameters.length > 1) {
                command = parameters[0];
                value = Integer.parseInt(parameters[1]);
            } else {
                command = parameters[0];
            }
            switch (command) {
                case "push":
                    stack.push(value);
                    System.out.println("ok");
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "back":
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "clear":
                    stack.clear();
                    System.out.println("ok");
                    break;
                case "exit":
                    System.out.println("bye");
                    return;
            }

        }
    }
}
