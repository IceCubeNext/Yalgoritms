import java.util.Scanner;

public class minimalSquare {
    public void square() {
        Scanner scanner = new Scanner(System.in);
        int dotCount = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int minx1 = x;
        int miny1 = y;
        int maxx2 = x;
        int maxy2 = y;
        for (int i = 1; i < dotCount; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (x < minx1) {
                minx1 = x;
            } else if (x > maxx2) {
                maxx2 = x;
            }

            if (y < miny1) {
                miny1 = y;
            } else if (y > maxy2) {
                maxy2 = y;
            }
        }
        System.out.println(minx1 + " " + miny1 + " " + maxx2 + " " + maxy2);

    }
}
