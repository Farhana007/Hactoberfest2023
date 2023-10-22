//This is Code Of Dikstra Algorithm
// Dijkstra's algorithm is a widely used algorithm for finding the shortest path between nodes in a graph, specifically in graphs with non-negative edge weights. It was developed by Edsger Dijkstra in 1956. The algorithm starts from a source node and calculates the shortest distance to all 
//other nodes in the graph. Dijkstra's algorithm works for both directed and undirected graphs but does not work with negative edge weights.
// Here's a step-by-step explanation of Dijkstra's algorithm and a Java implementation:
// Step-by-Step Explanation:
// Create a set of unvisited nodes and initialize the distance to the source node as 0 and the distance to all other nodes as infinity.
// Choose the node with the minimum distance (initially, it's the source node) and mark it as visited.
// For the current node, consider all of its unvisited neighbors and calculate their tentative distances through the current node. Compare the newly calculated tentative distance to the current assigned value and assign the smaller one.
// Once you've considered all of the unvisited neighbors of the current node, mark the current node as visited, and remove it from the unvisited set. A visited node will not be checked again.
// If the destination node has been marked visited, or if the smallest tentative distance among the nodes in the unvisited set is infinity, stop. The algorithm has finished.
// Otherwise, select the unvisited node that is marked with the smallest tentative distance and go back to step 3.

//Code Below

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void dijkstra(int[][] graph, int source) {
        int numNodes = graph.length;
        int[] distance = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int minDistance = findMinDistanceNode(distance, visited);
            visited[minDistance] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minDistance][j] != 0 &&
                        distance[minDistance] != Integer.MAX_VALUE &&
                        distance[minDistance] + graph[minDistance][j] < distance[j]) {
                    distance[j] = distance[minDistance] + graph[minDistance][j];
                }
            }
        }

        printSolution(distance);
    }

    private static int findMinDistanceNode(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        int numNodes = distance.length;

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i] && distance[i] <= minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] distance) {
        System.out.println("Node \t Minimum Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}
