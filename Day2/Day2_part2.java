import java.util.*;
import java.io.*;

// 12/2/2023
public class Day2_part2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day2.dat"));
        int powerSum = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String info = line.substring(line.indexOf(":")+2);
            String[] rounds = info.split("; ");
            ArrayList<Integer> redList = new ArrayList<Integer>();
            ArrayList<Integer> greenList = new ArrayList<Integer>();
            ArrayList<Integer> blueList = new ArrayList<Integer>();
            int power = 1;
            for (String round : rounds) {
                String[] colors = round.split(", ");
                for (String c : colors) {
                    String[] p = c.split(" ");
                    if (c.contains("red")) {
                        redList.add(Integer.parseInt(p[0]));
                    }
                    if (c.contains("green")) {
                        greenList.add(Integer.parseInt(p[0]));
                    }
                    if (c.contains("blue")) {
                        blueList.add(Integer.parseInt(p[0]));
                    }
                }
            }
            int max = 0;
            for (int r : redList) {
                if (r > max) {
                    max = r;
                }
            }
            power *= max;
            max = 0;
            for (int g : greenList) {
                if (g > max) {
                    max = g;
                }
            }
            power *= max;
            max = 0;
            for (int b : blueList) {
                if (b > max) {
                    max = b;
                }
            }
            power *= max;
            powerSum += power;
        }
        System.out.println(powerSum);
    }
}

// Answer: 69629
