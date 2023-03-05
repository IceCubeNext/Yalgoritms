import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BracketSequence {
    public void brackets () throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Stack<Character> stack = new Stack<>();
        char[] brackets = br.readLine().toCharArray();
        if (brackets.length == 0) {
            System.out.println("yes");
            return;
        }
        for (char bracket: brackets) {
            if (bracket == '{' || bracket =='(' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("no");
                    return;
                } else if (stack.peek() == '(' && bracket == ')'
                        || stack.peek() == '{' && bracket == '}'
                        || stack.peek() == '[' && bracket == ']') {
                    stack.pop();
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
