import java.util.*;

public class OperationSystems {
    public void system() {
        class OS {
            OS (int start, int end) {
                this.start = start;
                this.end = end;
            }
            public int start;
            public  int end;

            @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj == null || obj.getClass() != this.getClass()) return false;
                OS os = (OS) obj;
                return os.start == this.start
                        && os.end == this.end;
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.start, this.end);
            }
        }
        Scanner scanner = new Scanner(System.in);
        int sectorsAmount = scanner.nextInt();
        int partition = scanner.nextInt();
        HashMap<Integer, OS> os = new HashMap<>();
        for (int i = 0; i < partition; i++) {
            List<Integer> badOs = new ArrayList<>();
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for (Map.Entry<Integer, OS> system : os.entrySet()) {
                if ((start >= system.getValue().start && start <= system.getValue().end)
                        || (end <= system.getValue().end && end >= system.getValue().start)
                || start <= system.getValue().start && end >= system.getValue().end) {
                    badOs.add(system.getKey());
                }
            }
            for (int item : badOs) {
                os.remove(item);
            }
            if (end <= sectorsAmount) {
                os.put(i, new OS(start, end));
            }
        }
        System.out.println(os.size());
     }
}
