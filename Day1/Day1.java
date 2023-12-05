import java.util.*;
import java.io.*;

// 12/1/2023 - 12:24 AM
// Stayed up for the drop, took way too long

public class Day1 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("day1.dat"));
        int sum = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            ArrayList<Integer> digits = new ArrayList<Integer>();
            for (int i=0; i<line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    digits.add(Integer.parseInt(line.substring(i, i+1)));
                }
            }
            if (digits.size() == 1) {
                sum += digits.get(0) * 10 + digits.get(0);
            } else {
                sum += digits.get(0) * 10 + digits.get(digits.size()-1);
            }
        }
        System.out.println(sum);
    }
}

// Answer: 54644