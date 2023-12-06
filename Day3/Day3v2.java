import java.util.*;
import java.io.*;

// 12/6/2023 - 12:38 PM
// FINALLY, WHY WAS THIS ONE SO HARD?!??!!?!?
// Stayed up until 2 one night doing it- failed
// Tried for another 3 days- failed
// Then it suddenly works

public class Day3v2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day3.dat"));
        int sum = 0;
        int size = 140;
        String[][] schem = new String[size][size];
        int row = 0;
        ArrayList<Integer[]> coords = new ArrayList<Integer[]>();
        ArrayList<String> lines = new ArrayList<String>();
        // puts schematic into a 2D array
        while (in.hasNextLine()) {
            String line = in.nextLine();
            lines.add(line);
            String[] parts = line.split("");
            for (int col=0; col<schem[0].length; col++) {
                schem[row][col] = parts[col];
            }
            row++;
        }
        for (int r=0; r<schem.length; r++) {
            for (int c=0; c<schem[0].length; c++) {
                String cell = schem[r][c]; 
                // check for a symbol
                if (isDigit(cell) || cell.equals(".")) {
                    continue;
                }
                // loop in a box around it
                for (int i=-1; i<=1; i++) {
                    for (int j=-1; j<=1; j++) {
                        int newRow = r + i;
                        int newCol = c + j;
                        if (newRow < 0 || newRow >= schem.length || newCol < 0 || newCol >= schem[r].length || !isDigit(schem[newRow][newCol])) {
                            continue;
                        }
                        // move left until you hit a non-digit or out-of-bounds
                        while (newCol > 0 && isDigit(schem[newRow][newCol-1])) {
                            newCol--;
                        }
                        int endCol = newCol;
                        // turns number into periods so you don't double count
                        while (endCol >= 0 && endCol < schem[0].length-1 && isDigit(schem[newRow][endCol])) {
                            schem[newRow][endCol] = ".";
                            endCol++;
                        }
                        Integer[] coord = {newRow, newCol};
                        coords.add(coord);
                    }
                }
            }
        }
        for (Integer[] co : coords) {
            // line starting from the index, spacing them apart, and deleting the empty space at index 0
            Scanner sc = new Scanner(lines.get(co[0]).substring(co[1]).replaceAll("", " ").substring(1));
            for (int i : co) {
                System.out.print(i + " ");
            }
            ArrayList<Integer> digits = new ArrayList<Integer>();
            for (int d : digits) {
                System.out.print(d);
            }
            while (sc.hasNextInt()) {
                digits.add(sc.nextInt());
            }
            // turns ArrayList of digits into actual number
            int num = 0;
            for (int i=0; i<digits.size(); i++) {
                num += Math.pow(10, digits.size()-i-1) * digits.get(i);
            }
            sum += num;
            System.out.print("- " + num); 
            System.out.println(); 
        }
        System.out.println(sum);
    }

    public static boolean isDigit(String str) {
        return Character.isDigit(str.charAt(0));
    }
}

// Answer: 556367
 