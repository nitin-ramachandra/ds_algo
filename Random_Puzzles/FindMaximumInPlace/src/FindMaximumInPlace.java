
class FindMaximumInPlace {
    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static int min(int x, int y) {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
    arr[j] > arr[i] */
    public static int maxIndexDiff(int arr[]) {
        int lengthOfInput = arr.length;
        int maxDiff;

        int RMax[] = new int[lengthOfInput];
        int LMin[] = new int[lengthOfInput];

		/* Construct LMin[] such that LMin[i] stores the minimum value
		from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (int i = 1; i < lengthOfInput; ++i) {
            LMin[i] = min(arr[i], LMin[i - 1]);
        }

		/* Construct RMax[] such that RMax[j] stores the maximum value
		from (arr[j], arr[j+1], ..arr[lengthOfInput-1]) */
        RMax[lengthOfInput - 1] = arr[lengthOfInput - 1];
        for (int j = lengthOfInput - 2; j >= 0; --j) {
            RMax[j] = max(arr[j], RMax[j + 1]);
        }

        /*
        * Traverse both arrays from left to right to find optimum j - i
		* This process is similar to merge() of MergeSort
        * */
        int b = 0, a = 0; maxDiff = -1;
        while (a < lengthOfInput && b < lengthOfInput) {
            if (LMin[a] < RMax[b]) {
                maxDiff = max(maxDiff, b - a);
                b = b + 1;
            }
            else
                a = a + 1;
        }

        return maxDiff;
    }

    public static void main(String[] args) {

        int input[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};

        int maxDiff = maxIndexDiff(input);

        System.out.println("Max Difference -> " + maxDiff);
    }
}

