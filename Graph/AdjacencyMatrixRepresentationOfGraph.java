public class AdjacencyMatrixRepresentationOfGraph {
    private final int vertices;
    private int[][] adjacencyMatrix;

    // Constructor
    public AdjacencyMatrixRepresentationOfGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Add Edge for undirected graph with unit weight
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1; // Edge from source to destination
        adjacencyMatrix[destination][source] = 1; // Edge from destination to source
    }

    // Remove Edge for undirected graph
    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0; // Remove edge from source to destination
        adjacencyMatrix[destination][source] = 0; // Remove edge from destination to source
    }

    // Print the matrix
    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Example usage
        AdjacencyMatrixRepresentationOfGraph graph = new AdjacencyMatrixRepresentationOfGraph(5); // Create a graph with 5 vertices
        graph.addEdge(0, 1); // Add some edges
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        graph.printGraph(); // Print the graph
    }
}
