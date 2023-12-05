import java.util.*;
import java.io.*;

// 12/4/2023 - 10:54 AM
// Solved in Mr. Vallone's stats class

public class Day4 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("day4.dat"));

        int points = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(": ");
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
                for (int i=0; i<winNums.size(); i++) {
                    if (n == winNums.get(i)) {
                        wins++;
                    }
                }
            }
            if (wins > 0) {
                points += Math.pow(2, wins-1);
            }
        }
        System.out.println(points);
    }
}

// Answer: 20667