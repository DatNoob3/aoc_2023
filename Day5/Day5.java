import java.util.*;
import java.io.*;

// 1:47 PM - 12/12/23
// Stupid longs, ruining my life
// This was so easy after I finally understood it
// And that took 5 days apparently

public class Day5 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day5.dat"));
        String[] seedLine = in.nextLine().split(": ");
        // gets seed #'s
        Scanner seedSc = new Scanner(seedLine[1]);
        ArrayList<Long> seed = new ArrayList<Long>();
        int sCount = 0;
        while (seedSc.hasNextLong()) {
            seed.add(seedSc.nextLong());
            sCount++;
        }
        long[] seeds = new long[sCount];
        for (int i=0; i<sCount; i++) {
            seeds[i] = seed.get(i);
        }
        // gets ranges of whole dataset
        ArrayList<String[]> ranges = new ArrayList<String[]>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (!line.contains(":")) {
                ranges.add(line.split(" "));
            }
        }
        for (int i=0; i<seeds.length; i++) {
            System.out.println("Seed #" + seeds[i]);
            boolean found = false;
            for (String[] r : ranges) {
                if (r.length <= 1) {
                    found = false;
                    System.out.println("---------------");
                }
                if (!found) {
                    if (r.length > 1) {
                        long s = seeds[i];
                        long destR = Long.parseLong(r[0]);
                        long sourceR = Long.parseLong(r[1]);
                        long len = Long.parseLong(r[2]);
                        if (s >= sourceR && s < sourceR+len) {
                            seeds[i] += destR-sourceR;
                            found = true;
                        }
                        System.out.println(Arrays.toString(r) + "\t" + seeds[i]);
                    }
                }
                
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(seeds));
        Arrays.sort(seeds);
        System.out.println("Shortest location is " + seeds[0]);

        // for (String[] r : ranges) {
        //     if (r.length > 1) {
        //         int[] range = new int[3];
        //         for (int i=0; i<3; i++) {
        //             range[i] = Integer.parseInt(r[i]);
        //         }
        //         int destR = range[0];
        //         int sourceR = range[1];
        //         int len = range[2];
        //         ArrayList<Integer> dest = new ArrayList<Integer>();
        //         boolean inRange = false;
        //         for (int s : seeds) {
        //             if (s >= sourceR && s<sourceR+len) {
        //                 dest.add(s - sourceR + destR);
        //                 inRange = true;
        //             }
        //             if (!inRange) dest.add(s);
        //         }
        //     }
        //     System.out.println(Arrays.toString(r));
        // }
    }
}