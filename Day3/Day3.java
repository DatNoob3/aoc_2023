import java.util.*;
import java.io.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day3.dat"));
        int sum = 0;
        int size = 10;
        String[][] schem = new String[size][size];
        int row = 0;
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Coords> locs = new ArrayList<Coords>();
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
            String line = lines.get(r);
            String newLine = line.replaceAll("[^0-9]+", " ");
            String[] nums = newLine.trim().split(" ");
            for (int c=0; c<schem[0].length; c++) {
                if (Character.isDigit(schem[r][c].charAt(0)) && check(r, c, schem)) {
                    System.out.println("passes " + c);
                    for (String n : nums) {
                        int ind = line.indexOf(n);
                        // range is from one more/less from the indexes that the number takes up
                        if (c >= ind-1 && c <= ind+n.length()) {
                            System.out.println(n + "-" + ind);
                            sum += Integer.parseInt(n);
                            System.out.println("sum = " + sum);
                            c = ind+n.length();
                        }
                    }
                }
            }
            System.out.println();
        }
        for (Coords coor : locs) {
            System.out.println(coor.getX() + " " + coor.getY());
        }

        System.out.println(sum);
    }

    public static boolean check(int row, int col, String[][] array) {
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < array.length && newCol >= 0 && newCol < array[row].length) {
                    String cell = array[newRow][newCol];
                    if (cell != null && !cell.equals(".") && !cell.matches("\\d+")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}