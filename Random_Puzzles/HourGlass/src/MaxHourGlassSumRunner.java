import java.io.*;
import java.util.*;

public class MaxHourGlassSumRunner {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        int rowHeadIndex = 0;
        int colHeadIndex = 0;

        do {

            int[] hourGlassAs1DInstance = {
                                            arr[rowHeadIndex + 0][colHeadIndex + 0], arr[rowHeadIndex + 0][colHeadIndex + 1], arr[rowHeadIndex + 0][colHeadIndex + 2],
                                            arr[rowHeadIndex + 1][colHeadIndex + 1],
                                            arr[rowHeadIndex + 2][colHeadIndex + 0], arr[rowHeadIndex + 2][colHeadIndex + 1], arr[rowHeadIndex + 2][colHeadIndex + 2],
                                          };
            colHeadIndex += 1;

            maxSum = Math.max(maxSum, calculateHourGlassSum(hourGlassAs1DInstance));

            if (arr[rowHeadIndex].length - colHeadIndex < 3) {
                rowHeadIndex += 1;
                colHeadIndex = 0;
            }
        } while (arr.length - rowHeadIndex >= 3);
        return maxSum;
    }

    private static int calculateHourGlassSum(int[] hourGlassAs1DInstance) {
        int hourGlassSum = 0;

        for (int elem : hourGlassAs1DInstance) {
            hourGlassSum += elem;
        }
        return hourGlassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:\\Test_Results\\OUTPUT.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}