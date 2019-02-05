import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DynamicArrayRunner {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> outputList = new LinkedList<>();

        List<Integer[]> seqList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            seqList.add(i, null);
        }

        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int xValue    = query.get(1);
            int yValue    = query.get(2);

            int seqIndex = (xValue ^ lastAnswer) % n;

            Integer[] subSeqOfInterestOld = seqList.get(seqIndex);

            Integer[] subSeqOfInterestNew = null;
            int subSeqOfInterestNewLength = 0;
            if (queryType == 1) {
                subSeqOfInterestNewLength = (subSeqOfInterestOld == null ? 1 : subSeqOfInterestOld.length + 1);

                subSeqOfInterestNew = Arrays.copyOf((subSeqOfInterestNewLength == 1 ? new Integer[]{0} : subSeqOfInterestOld), subSeqOfInterestNewLength);

                subSeqOfInterestNew[subSeqOfInterestNewLength - 1] = yValue;
            } else {
                lastAnswer = seqList.get(seqIndex)[yValue % (subSeqOfInterestOld.length)];

                outputList.add(lastAnswer);
            }

            if (!seqList.isEmpty()) {
                seqList.remove(seqIndex);
            }
            seqList.add(subSeqOfInterestNew);
        }

        return outputList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
