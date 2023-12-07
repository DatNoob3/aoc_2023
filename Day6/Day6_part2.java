import java.util.*;
import java.io.*;

// 1:05 PM - 12/7/2023
// I'm stupid, this should've taken 2 minutes

public class Day6_part2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day6.dat"));
        String time = in.nextLine().substring(11);
        String dist = in.nextLine().substring(11);
        in = new Scanner(time);
        String timeStr = "";
        while (in.hasNext()) {
            timeStr += in.next();
        }
        in = new Scanner(dist);
        String distStr = "";
        while (in.hasNextInt()) {
            distStr += in.next();
        }
        long t = Integer.parseInt(timeStr);
        long d = Long.parseLong(distStr);
        int numWins = 0;
        for (int j=0; j<t; j++) {
            long test = (t - j) * j;
            if (test > d) {
                numWins++;
            }
        }
        System.out.println(numWins);
    }
}

// Answer: 39570185