import java.io.*;
import java.util.Stack;

public class LainLandia {
    public void lainlandia() throws IOException {
        class Pair {
            Pair(int cost, int index) {
                this.cost = cost;
                this.index = index;
            }
            int cost;
            int index;
        }
        Stack<Pair> stack = new Stack<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int cityAmount = Integer.parseInt(br.readLine());
        String[] citiesStr = br.readLine().trim().split(" ");
        int[] citiesCost = new int[citiesStr.length];
        int[] newCityIndex = new int[citiesStr.length];
        for (int i = 0; i < cityAmount; i++) {
            citiesCost[i] = Integer.parseInt(citiesStr[i]);
        }
        for (int i = 0; i < cityAmount; i++) {
            if (stack.isEmpty() || stack.peek().cost < citiesCost[i]) {
                stack.push(new Pair(citiesCost[i], i));
            } else {
                while(!stack.isEmpty() && citiesCost[i] < stack.peek().cost) {
                    Pair current = stack.pop();
                    newCityIndex[current.index] = i;
                }
                stack.push(new Pair(citiesCost[i], i));
            }
        }
        OutputStream out = new BufferedOutputStream(System.out);
        for (int item: newCityIndex) {
            if (item == 0 ){
                //System.out.print(-1 + " ");
                out.write((-1 + " ").getBytes());
            } else {
                //System.out.print(item + " ");
                out.write((item + " ").getBytes());
            }
        }
        out.flush();
    }
}
