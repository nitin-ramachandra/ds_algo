import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OptimalDeliveryRoutes {

    public static void main(String[] args) {
        LinkedList<ArrayList<Integer>> input = new LinkedList<>();

        ArrayList<Integer> coordinates1 = new ArrayList<>(2);
        ArrayList<Integer> coordinates2 = new ArrayList<>(2);
        ArrayList<Integer> coordinates3 = new ArrayList<>(2);
        ArrayList<Integer> coordinates4 = new ArrayList<>(2);
        ArrayList<Integer> coordinates5 = new ArrayList<>(2);
        ArrayList<Integer> coordinates6 = new ArrayList<>(2);

        coordinates2.add(1);
        coordinates2.add(-3);
        input.add(coordinates2);

        coordinates1.add(1);
        coordinates1.add(2);
        input.add(coordinates1);

        coordinates3.add(3);
        coordinates3.add(4);
        input.add(coordinates3);

        coordinates4.add(1);
        coordinates4.add(4);
        input.add(coordinates4);

        coordinates5.add(2);
        coordinates5.add(-1);
        input.add(coordinates5);

        coordinates6.add(3);
        coordinates6.add(-1);
        input.add(coordinates6);

        List<ArrayList<Integer>> output = findOptimalRoutes(input.size(), input, 4);


    }

    private static List<ArrayList<Integer>> findOptimalRoutes(int numDestinations, LinkedList<ArrayList<Integer>> allLocations, int numOfDeliveries) {
        long[] distanceFromOrigin = new long[numDestinations];

        for (int i = 0; i < numDestinations; i++) {
            List<Integer> location = allLocations.get(i);

            int x = location.get(0);
            int y = location.get(1);

            distanceFromOrigin[i] = Math.round(Math.sqrt((x * x) + (y * y)));
        }

        long[] distanceFromOriginCopy = Arrays.copyOf(distanceFromOrigin, distanceFromOrigin.length);

        Arrays.sort(distanceFromOriginCopy);

        distanceFromOriginCopy = Arrays.copyOfRange(distanceFromOriginCopy, 0, numOfDeliveries);

        List<ArrayList<Integer>> optimalRoutes = new ArrayList<>(numOfDeliveries);

        int optimalDeliveryCount = 0;
        for (int j = 0; j < distanceFromOrigin.length; j++) {
            if (Arrays.binarySearch(distanceFromOriginCopy, distanceFromOrigin[j]) >= -1) {
                optimalRoutes.add(allLocations.get(j));
                optimalDeliveryCount++;
            }

            if (optimalDeliveryCount == numOfDeliveries) {
                break;
            }
        }

        return optimalRoutes;
    }
}
