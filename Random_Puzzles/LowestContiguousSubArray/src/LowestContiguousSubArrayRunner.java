public class LowestContiguousSubArrayRunner {

    public static void main(String args[]) {

        int arr[] = {1, -2, 4, 3, 10, 2, -3, -1, -5, 5, -6, 28, 35, 66, 77};

        int minEndingHere = arr[0];
        int minSoFar      = arr[0];

        int startIndex = 0;
        int lastIndex = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < (minEndingHere + arr[i])) {
                minEndingHere = arr[i];
                startIndex = i;
            } else {
                minEndingHere = (minEndingHere + arr[i]);

            }


            if (minEndingHere < minSoFar) {
                minSoFar = minEndingHere;

                if (arr[i] > (minEndingHere + arr[i])) {
                    lastIndex = i;
                }
            }
        }

        System.out.println("Min Sum -> " + minSoFar);

        System.out.print("Sub array elements -> [");
        for (int j = startIndex; j <= lastIndex; j++) {
            System.out.print(arr[j] + ((j >= lastIndex) ? "" : ", "));
        }
        System.out.print("]");
    }
}
