import java.util.Random;

public class Print2DMatrixSpirallyRunner {

        private static int arr[][]     = new int[4][];
        private static int totalElms   = 0;
        private static int printedElms = 0;

        private static int rowHead = 0;
        private static int rowTail = 0;
        private static int colHead = 0;
        private static int colTail = 0;

        public static void main(String[] args) {

            create2DArray();

            rowTail = arr.length - 1;
            colTail = arr[0].length - 1;
            printSpirally(0, colTail, true);

        }

        public static void printSpirally(int indexOfRowToPrint, int indexOfColumnToPrint, boolean conventionalDirection) {

            if (printedElms == totalElms) {
                return;
            }

            printRow(indexOfRowToPrint,conventionalDirection);

            printCol(indexOfColumnToPrint,conventionalDirection);

            printSpirally((conventionalDirection ? rowTail : rowHead) , (conventionalDirection ? colHead : colTail), !conventionalDirection);
        }


        public static void printRow(int rowToPrint, boolean conventionalDirection) {

            if (conventionalDirection) {
                for (int i = colHead; i <= colTail; i++) {
                    System.out.print(arr[rowToPrint][i] + " ");
                    printedElms += 1;
                }
                rowHead += 1;
            } else {
                for (int i = colTail; i >= colHead; i--) {
                    System.out.print(arr[rowToPrint][i] + " ");
                    printedElms += 1;
                }
                rowTail -= 1;
            }
            System.out.println(" ");
        }

        public static void printCol(int colToPrint, boolean conventionalDirection) {

            if (conventionalDirection) {
                if (!(arr[rowHead].length < colToPrint)) {
                    for (int i = rowHead; i <= rowTail; i++) {
                        System.out.print(arr[i][colToPrint] + " ");
                        printedElms += 1;
                    }
                    colTail -= 1;
                }
            } else {
                if (!(arr[rowTail].length - 1 < colToPrint)) {
                    for (int i = rowTail; i >= rowHead; i--) {
                        System.out.print(arr[i][colToPrint] + " ");
                        printedElms += 1;
                    }
                    colHead += 1;
                }
            }
            System.out.println(" ");
        }

        private static void create2DArray() {

            for (int k = 0; k < arr.length; k++) {

                int secondDim = Math.abs((new Random()).nextInt(5));

                //secondDim = (secondDim <= 0) ? 1 : secondDim;
                secondDim = 4;

                int oneDimArray[] = new int[secondDim];

                Random rand = new Random();
                for (int l = 0; l < secondDim; l++) {
                    oneDimArray[l] = rand.nextInt(100);
                }

                arr[k] = oneDimArray;

                totalElms += secondDim;
            }
            printInputArray();
        }

        private static void printInputArray() {

            System.out.println("Input Array : ");

            for (int a = 0; a < arr.length; a++) {

                for (int b = 0; b < arr[a].length; b++) {
                    System.out.print(arr[a][b] + " ");
                }

                System.out.println(" ");
            }

            System.out.println("-----------------------------------------------------");
        }
    }
