import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        System.out.println("Graph Test");
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Graph graph = new Graph(edges.toArray(new Edge[0]), 4);
        GraphAlgorithms graphAlgorithms = new GraphAlgorithms();
        double[][] incidenceMatrix = graphAlgorithms.getIncidenceMatrix(graph);
        Graph minSpanningTree = graphAlgorithms.getMinimumSpanningTree(graph);

        System.out.println("Graph  ->");
        System.out.println(graph.toString());

        System.out.println("Incidence Matrix  -> ");
        for (double[] row : incidenceMatrix) {
            for (double e : row)
                System.out.print(e+" ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Minimum Spanning Tree ->");
        System.out.println(minSpanningTree.toString());

    }
}
