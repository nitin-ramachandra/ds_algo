import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryMaze {

    private static final int ROW    = 9;
    private static final int COLUMN = 10;

    // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell
    private static int rowNum[] = {-1, 0, 0, 1};
    private static int colNum[] = {0, -1, 1, 0};

    public static void main(String[] args) {
        int[][] mat = {
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
                      };

        Point source      = new Point(0,0);
        Point destination = new Point(5, 4);

        int dist = BFS(mat, source, destination);

        if (dist != 0)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesnt exist");

    }

    private static int BFS(int[][] mat, Point source, Point destination) {
        // check source and destination cell
        // of the matrix have value 1
        if (mat[source.x][source.y] == 0 || mat[destination.x][destination.y] == 0)
            return -1;

        boolean[][] visited = new boolean[ROW][COLUMN];

        // Marking the source cell as visited
        visited[source.x][source.y] = true;

        // Queue for BFS
        Queue<QueueNode> q = new ArrayDeque<>();

        // Distance of source cell is 0
        QueueNode s = new QueueNode(source, 0);
        q.add(s);  // Enqueue source cell

        //BFS starting from source cell
        while (!q.isEmpty())
        {
            QueueNode curr = ((ArrayDeque<QueueNode>) q).getFirst();
            Point pt = curr.point;

            // Base case
            // If we have reached the destination cell,
            // we are done
            if (pt.x == destination.x && pt.y == destination.y)
                return curr.distance;

            // Otherwise dequeue the front cell in the queue
            // and enqueue its adjacent cells
            ((ArrayDeque<QueueNode>) q).pop();

            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path and
                // not visited yet, enqueue it.
                if (isValid(row, col) && mat[row][col] != 0 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;

                    QueueNode adjCell = new QueueNode(new Point(row, col), (curr.distance + 1));

                    ((ArrayDeque<QueueNode>) q).add(adjCell);
                }
            }
        }
        // Return -1 if destination cannot be reached
        return -1;
    }

    // Checking for valid cell
    public static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COLUMN);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class QueueNode {
        public Point   point;
        public int     distance;

        public QueueNode(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }
}
