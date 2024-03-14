import java.util.ArrayList;
import java.util.List;

public class AdjacencyListRepresentationOfGraph {
    private List<List<Integer>> adjList;
    int vertices;

    // Constructor
    public AdjacencyListRepresentationOfGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize list for each vertex
        }
    }

    // Add edge for undirected graph
    public void addEdge(int source, int destination) {
        // Add an edge from source to destination
        adjList.get(source).add(destination);

        // Add an edge from destination to source
        adjList.get(destination).add(source);
    }

    // Print the adjacency list
    public void printGraph() {
        System.out.println("Graph: (Adjacency List)");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " --> ");
            List<Integer> edges = adjList.get(i);
            for (Integer edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        AdjacencyListRepresentationOfGraph graph = new AdjacencyListRepresentationOfGraph(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        graph.printGraph(); // Print the graph
    }
}
