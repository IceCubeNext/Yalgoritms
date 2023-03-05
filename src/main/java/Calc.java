import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N+1];
        a[1]= 0;

        int min;
        for(int i = 2; i < N + 1; i++){
            min = a[i - 1] + 1;
            if(i % 2 == 0) min = Math.min(min, a[i / 2] + 1);
            if(i % 3 == 0) min = Math.min(min, a[i / 3] + 1);

            a[i] = min;
        }
        List<String> nums = new ArrayList<>();
        nums.add(N + "");
        int i = N;
        System.out.println(a[N]);
        while (i > 1) {
            if (a[i] == (a[i - 1] + 1)) {
                N = N - 1;
                nums.add(N + "");
                i--;
            }
            if (i % 2 == 0 && a[i] == a[i / 2] + 1) {
                N = N / 2;
                nums.add(N + "");
                i = i / 2;
            }
            if (i % 3 == 0 && a[i] == a[i / 3] + 1) {
                N = N / 3;
                nums.add(N + "");
                i = i / 3;
            }
        }

        for (int n = nums.size() - 1; n >= 0; n--) {
            System.out.print(nums.get(n) + " ");
        }
    }
}
