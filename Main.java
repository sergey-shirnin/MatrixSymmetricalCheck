import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

// if matrix is put as 2d array
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = IntStream.range(0, n).mapToObj(whatever
                -> Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        boolean mainDiaSym = true;

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    mainDiaSym = false;
                    break loop;
                }
            }
        }

        System.out.println(mainDiaSym ? "YES" : "NO");
    }
}


// -----------------------------------------------------------

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;

// if matrix is put as 1d array
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> inputIntArr = new ArrayList<>();

        IntStream.range(0, n).mapToObj(
                        whatever -> Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt).toArray())
                .forEach(arr -> Arrays.stream(arr).forEach(inputIntArr::add));
        
        int i = 1; 
        int step = 1;
        int lineRange = n;

        boolean mainDiaSym =  true;

        while (i < inputIntArr.size() - n && mainDiaSym) {
            lineRange--;
            
            for (int j = 0; j < lineRange; j++) {
                if (!inputIntArr.get(i).equals(inputIntArr.get(i + (n - 1) * (i % (n + 1))))) {
                    mainDiaSym = false;
                }
                i++;
            }

            step++;
            i += step;
        }
        
        System.out.println(mainDiaSym ? "YES" : "NO");
    }
}
