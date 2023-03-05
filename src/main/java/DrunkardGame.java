import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DrunkardGame {
    public void game() throws IOException{
        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr)){
            ArrayDeque<Integer> firstCards = new ArrayDeque<>();
            ArrayDeque<Integer> secondCards = new ArrayDeque<>();
            String[] cards = br.readLine().trim().split(" ");
            for (String card: cards) {
                firstCards.offer(Integer.parseInt(card));
            }
            cards = br.readLine().trim().split(" ");
            for (String card: cards) {
                secondCards.offer(Integer.parseInt(card));
            }
            int steps = 0;
            while (steps < 1000000) {
                if (firstCards.isEmpty()) {
                    System.out.println("second " + steps);
                    return;
                }
                if (secondCards.isEmpty()) {
                    System.out.println("first " + steps);
                    return;
                }
                int cardF = firstCards.poll();
                int cardS = secondCards.poll();
                if (cardF > cardS) {
                    if (cardS == 0 && cardF == 9) {
                        secondCards.offer(cardF);
                        secondCards.offer(cardS);
                    } else {
                        firstCards.offer(cardF);
                        firstCards.offer(cardS);
                    }
                } else {
                    if (cardS == 9 && cardF == 0) {
                        firstCards.offer(cardF);
                        firstCards.offer(cardS);
                    } else {
                        secondCards.offer(cardF);
                        secondCards.offer(cardS);
                    }
                }
                steps++;
            }
            System.out.println("botva");
         }
    }
}
