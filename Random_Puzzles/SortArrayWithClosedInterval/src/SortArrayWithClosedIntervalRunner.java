public class SortArrayWithClosedIntervalRunner {

    public static void main(String[] args) {

        int[] input          = {10, 10, 2, 5, 7, 16, 102, 28, 28, 4, 103};
        int[] closedInterval = {2, 105};

        int[] auxArray = new int[closedInterval[1] - closedInterval[0] + 1];

        for (int i = 0; i < input.length; i++) {
            auxArray[input[i] - closedInterval[0]] += 1;
        }

        for (int j = 0; j < auxArray.length; j++) {
            if (auxArray[j] == 0) {
                continue;
            }

            for (int k = 0; k < auxArray[j]; k++) {
                System.out.print(j + " ");
            }
        }
    }
}


