import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yurij Volkov on 14.10.2016.
 */
public class GraphGenerator {
    /**
     *
     * @param vertexNumber
     * @param edgeNumber
     * @return adjacency List
     */
    public static ArrayList<ArrayList<Integer>> generateGraph(int vertexNumber, int edgeNumber)
    {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<vertexNumber;i++)
        {
            adjList.add(new ArrayList());
        }
        for(int i = 0;i<edgeNumber;i++)
        {
            Random random = new Random();
            int start = random.nextInt(vertexNumber);
            int end = random.nextInt(vertexNumber);
            adjList.get(start).add(end);
        }
        return adjList;
    }
    public static int[][] getAdjMatrix(ArrayList<ArrayList<Integer>> adjList)
    {
        int[][] adjMatrix = new int[adjList.size()][adjList.size()];
        for(int i = 0;i<adjList.size();i++)
        {
            for (int j:adjList.get(i)) {
                adjMatrix[i][j] = 1;
            }
        }
        return adjMatrix;
    }


    public static void main(String[] args) {
        int[][] graph = getAdjMatrix( generateGraph(100, 100));
        for(int i = 0 ; i<100;i++){
            for(int j = 0;j<100;j++){
                System.out.print(graph[i][j]);
                if(j!=99)
                    System.out.print(',');
            }
            System.out.println();
        }
    }
}
