import java.util.Scanner;

public class SchoolDesks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int variants = scanner.nextInt();
        int row = scanner.nextInt();
        byte side = scanner.nextByte();

        int petDesk = side == 1 ? row * 2 - 1 : row * 2;
        int petVar = petDesk <= variants ? petDesk: petDesk - ((petDesk / variants) * variants);
        petVar = petVar == 0 ? variants: petVar;

        int beforeDesk = petDesk - variants;
        boolean isBefore = petDesk - variants > 0;
        int afterDesk = variants - petVar + petVar + petDesk;
        boolean isAfter = students >= afterDesk;
        int beforeRow = beforeDesk % 2 == 0 ? beforeDesk / 2 : beforeDesk / 2 + 1;
        beforeRow = beforeDesk == 1 ? 1 : beforeRow;
        int afterRow = afterDesk % 2 == 0 ? afterDesk / 2 : afterDesk / 2 + 1;
        int beforeSide = beforeDesk % 2 == 0 ? 2 : 1;
        int afterSide = afterDesk % 2 == 0 ? 2 : 1;
        if (!isAfter && !isBefore) {
            System.out.println(-1);
        } else if (isAfter && isBefore) {
            if (row - beforeRow < afterRow - row) {
                System.out.println(beforeRow + " " + beforeSide);
            } else {
                System.out.println(afterRow + " " + afterSide);
            }
        } else if (isBefore) {
            System.out.println(beforeRow + " " + beforeSide);
        } else {
            System.out.println(afterRow + " " + afterSide);
        }
    }
}
