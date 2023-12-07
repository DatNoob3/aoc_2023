import java.util.*;
import java.io.*;

// 12:47 PM - 12/7/2023
// Definitely easiest puzzle yet, took 10 minutes

public class Day6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day6.dat"));
        String time = in.nextLine().substring(11);
        String dist = in.nextLine().substring(11);
        in = new Scanner(time);
        ArrayList<Integer> times = new ArrayList<Integer>();
        while (in.hasNextInt()) {
            times.add(in.nextInt());
        }
        in = new Scanner(dist);
        ArrayList<Integer> dists = new ArrayList<Integer>();
        while (in.hasNextInt()) {
            dists.add(in.nextInt());
        }
        int[] wins = new int[4];
        for (int i=0; i<4; i++) {
            int numWins = 0;
            int t = times.get(i);
            int d = dists.get(i);
            for (int j=0; j<t; j++) {
                int test = (t - j) * j;
                if (test > d) numWins++;
            }
            wins[i] = numWins;
        }
        int product = 1;
        for (int w : wins) {
            product *= w;
        }
        System.out.println(product);
    }
}

// Answer: 140220