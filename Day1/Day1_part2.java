import java.util.*;
import java.io.*;

// 12/1/2023 - 12:43
// I'm literally stupid 

public class Day1_part2 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("day1.dat"));
        int sum = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            int[] digits = new int[100];
            ArrayList<Integer> numDigits = new ArrayList<Integer>();
            String guess = "one";
            int index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 1;
                index = line.indexOf(guess, index + 1);
            }
            guess = "two";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 2;
                index = line.indexOf(guess, index + 1);
            }
            guess = "three";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 3;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "four";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 4;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "five";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 5;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "six";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 6;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "seven";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 7;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "eight";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 8;
                index = line.indexOf(guess, index + 1);
                
            }
            guess = "nine";
            index = line.indexOf(guess);
            while (index >= 0) {
                digits[index] = 9;
                index = line.indexOf(guess, index + 1);
                
            }
            for (int i=0; i<line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    digits[i] = Integer.parseInt(line.substring(i, i+1));
                    numDigits.add(Integer.parseInt(line.substring(i, i+1)));
                }
            }
            int count = 0;
            for (int i=0; i<digits.length; i++) {
                if (digits[i] != 0) {
                    count++;
                }
            }
            if (numDigits.size() == 1 && count == 0) {
                sum += numDigits.get(0) * 10 + numDigits.get(0);
            } else {
                int first = -1;
                int last = -1;
                for (int i=0; i<digits.length; i++) {
                    if (digits[i] != 0) {
                        first = digits[i];
                        break;
                    }
                }
                for (int i=digits.length-1; i>=0; i--) {
                    if (digits[i] != 0) {
                        last = digits[i];
                        break;
                    }
                }
                sum += first * 10 + last;
            }
        }
        System.out.println(sum);
    }
}

// Answer: 53348