import java.util.*;
import java.io.*;

// 12/5/2023 - 12:07
// My answer was 1 too high lol

public class Day4_part2 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("day4.dat"));

        int size = 212;

        int[] matches = new int[size];
        for (int i=0; i<size; i++) {
            matches[i] = 1;
        }
        matches[0] = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(": ");
            Scanner cardSc = new Scanner(line);
            cardSc.next();
            String next = cardSc.next();
            int cardNum = Integer.parseInt(next.substring(0,next.length()-1));
            String[] allNums = parts[1].split("\\|");
            Scanner numSc = new Scanner(allNums[0]);
            ArrayList<Integer> winNums = new ArrayList<Integer>();
            while (numSc.hasNextInt()) {
                winNums.add(numSc.nextInt());
            }
            numSc = new Scanner(allNums[1]);
            ArrayList<Integer> myNums = new ArrayList<Integer>();
            while (numSc.hasNextInt()) {
                myNums.add(numSc.nextInt());
            }
            int wins = 0;
            for (int n : myNums) {
                if (winNums.contains(n)) {
                    wins++;
                }
            }
            if (wins > 0) {
                for (int w=1; w<=wins; w++) {
                    matches[cardNum+w] += matches[cardNum];
                }
            }
            System.out.println(cardNum + ": " + matches[cardNum]);
        }
        int totalCards = 0;
        for (int m : matches) {
            totalCards += m;
        }
        System.out.println(totalCards);
    }
}
