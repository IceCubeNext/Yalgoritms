import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiegoCollector {
    public static void main(String[] args) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            OutputStream out = new BufferedOutputStream(System.out)){
            long diegoSticker = Long.parseLong(br.readLine());
            long count = 0;
            List<Long> stickers = Arrays.stream(br.readLine().split(" "))
                    .map(Long::valueOf)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            long collectors = Long.parseLong(br.readLine());
            String[] stickersForChange = br.readLine().split(" ");
            for (String collector: stickersForChange) {
                count = next(stickers, Long.parseLong(collector));
                if (count == -1) {
                    out.write((0 + "\n").getBytes());
                } else {
                    out.write((count + 1 + "\n").getBytes());
                }
            }
            out.flush();
        }
    }

    private static int next(List<Long> arr, long target)
    {
        int start = 0, end = arr.size() - 1;
        if(end == 0 && arr.get(end) < target) {
            return 0;
        } else if (end == 0 && arr.get(end) > target){
            return -1;
        }
        if (target > arr.get(end)) return end;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) >= target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
