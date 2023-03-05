import java.util.Scanner;

public class DynamicOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] answers = new int[n + 1];
        if (n == 1) {
            System.out.println(2);
            return;
        } else if (n == 2) {
            System.out.println(4);
            return;
        } else if (n == 3) {
            System.out.println(7);
            return;
        }
        answers[1] = 2;
        answers[2] = 4;
        answers[3] = 7;
        for (int i = 4; i <= n; i++) {
            answers[i] = answers[i - 1] + answers[i - 2] + answers[i - 3];
        }
        System.out.println(answers[n]);
    }
}
