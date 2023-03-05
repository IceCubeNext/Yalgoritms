import java.util.Scanner;

public class DynamicTicketQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N + 1];
        int[] b = new int[N + 1];
        int[] c = new int[N + 1];
        int[] t = new int[N + 1];

        for (int i = 1; i <= N; i++){
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        if (N == 1) {
            System.out.println(a[1]);
            return;
        }
        if (N == 2) {
            System.out.println(Math.min(a[1] + a[2], b[1]));
            return;
        }
        t[0] = 0;
        t[1] = a[1];
        t[2] = Math.min(a[1] + a[2], b[1]);
        for (int i = 3; i <= N; i++) {
            t[i] = Math.min(Math.min(t[i - 1] + a[i], t[i - 2] + b[i - 1]), t[i - 3] + c[i - 2]);
        }
        System.out.println(t[N]);
    }
}
