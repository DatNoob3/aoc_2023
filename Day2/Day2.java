import java.util.*;
import java.io.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day2.dat"));
        int idSum = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            int id = Integer.parseInt(parts[1].substring(0, parts[1].length()-1));
            String info = line.substring(line.indexOf(":")+2);
            String[] rounds = info.split("; ");
            int works = 0;
            for (String round : rounds) {
                int red = 0;
                int green = 0;
                int blue = 0;
                String[] colors = round.split(", ");
                for (String c : colors) {
                    String[] p = c.split(" ");
                    if (c.contains("red")) {
                        red += Integer.parseInt(p[0]);
                    }
                    if (c.contains("green")) {
                        green += Integer.parseInt(p[0]);
                    }
                    if (c.contains("blue")) {
                        blue += Integer.parseInt(p[0]);
                    }
                }
                if (red <= 12 && green <= 13 && blue <= 14) {
                    // System.out.println(red + " " + green + " " + blue);
                    works++;
                }
            }
            if (works == rounds.length) {
                // System.out.println(id);
                // System.out.println();
                idSum += id;
            }
            
        }
        System.out.println(idSum);
    }
}

// Answer: 2632