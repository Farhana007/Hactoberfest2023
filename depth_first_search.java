//This is Code OF Depth First Search Algo Code
//DFS, or Depth-First Search, is a fundamental graph traversal algorithm used to explore or traverse all the vertices of a graph 
// or tree in a depthward motion. It starts at a source node and explores as far as possible along each branch before backtracking.
//Here's a high-level description of the DFS algorithm, followed by a Java implementation:
//Start at a source node (often called the "root" node for trees).
//Visit the source node and mark it as visited.
//Recursively explore each unvisited neighboring node (adjacent node) of the current node.
//Repeat step 3 for the unvisited neighbor until there are no more unvisited neighbors.
//Backtrack to the previous node and repeat the process for any unvisited neighbors of that node.
//Continue this process until all nodes have been visited.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public void depthFirstSearch(int startNode) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        visited[startNode] = true;
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            System.out.print(currentNode + " ");

            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}

public class DFSTest {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Depth-First Search starting from node 0:");
        graph.depthFirstSearch(0);
    }
}
